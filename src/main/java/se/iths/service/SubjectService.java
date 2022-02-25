package se.iths.service;


import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {
    @PersistenceContext
    EntityManager entityManager;

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT s from Subject s", Subject.class).getResultList();
    }

    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

}
