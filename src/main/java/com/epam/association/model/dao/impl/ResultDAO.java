package com.epam.association.model.dao.impl;

import com.epam.association.model.dao.DAO;
import com.epam.association.model.entity.Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ResultDAO implements DAO<Result> {

    @PersistenceContext
    private EntityManager manager;

    public void create(Result entity) {
        manager.persist(entity);
    }

    public void delete(int id) {
        Result plate = find(id);
        manager.remove(plate);
    }

    //todo fix it
    public void update(Result entity) {
        manager.merge(entity);
    }

    public Result find(int id) {
        return manager.find(Result.class, id);
    }

    public List<Result> getList(int number) {
        Query query = manager.createQuery("SELECT e FROM Result e");
        query.setMaxResults(number);
        return query.getResultList();
    }


}
