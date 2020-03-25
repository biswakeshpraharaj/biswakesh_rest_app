package com.biswakesh.restservice.dao.common;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Component
public abstract class AbstractJpaDAO<T extends Serializable> {
    private Class<T> clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    public final void setClazz(Class<T> classToSet) {
        this.clazz = classToSet;
    }

    public T findOne(String id) {
        return entityManager.find(clazz,id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("from "+clazz.getName())
                .getResultList();
    }

    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(String id) {
        final T entity = findOne(id);
        delete(entity);
    }


}
