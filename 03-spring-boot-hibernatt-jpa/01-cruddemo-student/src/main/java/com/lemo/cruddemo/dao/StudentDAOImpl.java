package com.lemo.cruddemo.dao;

import com.lemo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//special  annoation for repository , support component scanning , translaate jdbc exceptions
@Repository
public class StudentDAOImpl implements StudentDAO {

    // inject entity mangaer using constructor injection
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager)
    {
        entityManager = theEntityManager ;
    }

//    use annotation Transactonal when make update in database
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return  entityManager.find(Student.class , id);
    }

    @Override
    public List<Student> findAll() {
    //        create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by last_name" , Student.class);
    //        return query result
        return theQuery.getResultList();


    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE last_name = :theData   " , Student.class);
        theQuery.setParameter("theData" ,theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class , id);

        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
       int numRowsDeleteeed = entityManager.createQuery("DELETE FROM Student").executeUpdate();
       return numRowsDeleteeed;
    }


}
