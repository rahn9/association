package com.epam.association.model.service.impl;

import com.epam.association.model.dao.DAO;
import com.epam.association.model.entity.GamePlate;
import com.epam.association.model.entity.Result;
import com.epam.association.model.service.ServiceInterface;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GamePlateService implements ServiceInterface<GamePlate> {
    @Inject
    private DAO<Result> resultDAO;
    @Inject
    private DAO<GamePlate> gamePlateDAO;

    public void create(GamePlate entity) {
        gamePlateDAO.create(entity);
    }

    public void delete(int id) {
        gamePlateDAO.delete(id);
    }

    public void update(GamePlate entity) {
        gamePlateDAO.update(entity);
    }

    public GamePlate find(int id) {
        GamePlate gamePlate = gamePlateDAO.find(id);
        resultDAO.find(gamePlate.getResult().getId());
        return gamePlate;
    }

    public List<GamePlate> getList(int number) {
        return gamePlateDAO.getList(number);
    }
}
