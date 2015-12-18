package com.epam.association.controller;

import com.epam.association.model.entity.GamePlate;
import com.epam.association.model.entity.Result;
import com.epam.association.model.service.ServiceInterface;
import com.epam.association.model.util.AnswerChecker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping({"/association"})
public class PicturesController {
    public static final String MAIN_VIEW = "pictures";
    @Inject
    private ServiceInterface<GamePlate> gamePlateService;

    @RequestMapping({"", "/"})
    public String getPictures(HttpSession session) {
        List<GamePlate> list = gamePlateService.getList(5);
        session.setAttribute("pictureList", list);
        return MAIN_VIEW;
    }

    @RequestMapping(value = "/answer", params = {"hint"})
    public String getHint(HttpSession session, HttpServletRequest request) {
        String hintName = request.getParameter("hint");
        String[] hints = hintName.split("Hint");
        int plateId = Integer.valueOf(hints[1]);
        GamePlate gamePlate = gamePlateService.find(plateId);
        Result result = gamePlate.getResult();
        int hintCounter = result.getHintCounter();
        hintCounter++;
        result.setHintCounter(hintCounter);
        gamePlate.setResult(result);
        gamePlateService.update(gamePlate);
        getPictures(session);
        return MAIN_VIEW;
    }

    @RequestMapping(value = "/answer", params = {"submit", "userAnswer[]"})
    public String userAnswerCheck(HttpSession session, HttpServletRequest request) {
        GamePlate gamePlate;
        AnswerChecker checker = new AnswerChecker();
        String[] answers = request.getParameterValues("userAnswer[]");
        String[] plateIds = request.getParameterValues("plateId[]");
        for (int i = 0; i < plateIds.length; i++) {
            gamePlate = gamePlateService.find(Integer.valueOf(plateIds[i]));
            boolean isAnswerRight = checker.checkAnswer(answers[i], gamePlate);
            session.setAttribute("answerCheck" + plateIds[i], isAnswerRight);
        }
        getPictures(session);
        return MAIN_VIEW;
    }
}