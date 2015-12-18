package com.epam.association.model.dao.impl;

import com.epam.association.model.dao.DAO;
import com.epam.association.model.entity.GamePlate;
import com.epam.association.model.entity.Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class GamePlateDAO implements DAO<GamePlate> {
    @Inject
    private DAO<Result> resultDAO;

    @PersistenceContext
    private EntityManager manager;

    public void create(GamePlate entity) {
        manager.persist(entity);
    }

    public void delete(int id) {
        GamePlate plate = find(id);
        manager.remove(plate);
    }

    //todo fix it
    public void update(GamePlate entity) {
        resultDAO.update(entity.getResult());
        manager.merge(entity);
    }

    public GamePlate find(int id) {
        return manager.find(GamePlate.class, id);
    }

    public List<GamePlate> getList(int number) {
        Query query = manager.createQuery("SELECT e FROM GamePlate e");
        query.setMaxResults(number);
        return query.getResultList();
    }
}