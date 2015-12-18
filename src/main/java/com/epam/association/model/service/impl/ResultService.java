package com.epam.association.model.service.impl;

import com.epam.association.model.dao.DAO;
import com.epam.association.model.entity.Result;
import com.epam.association.model.service.ServiceInterface;

import javax.inject.Inject;
import java.util.List;

public class ResultService implements ServiceInterface<Result> {

    @Inject
    private DAO<Result> resultDAO;

    public void create(Result entity) {
        resultDAO.create(entity);
    }

    public void delete(int id) {
        resultDAO.delete(id);
    }

    public void update(Result entity) {
        resultDAO.update(entity);
    }

    public Result find(int id) {
        return resultDAO.find(id);
    }

    public List<Result> getList(int number) {
        return resultDAO.getList(number);
    }
}
