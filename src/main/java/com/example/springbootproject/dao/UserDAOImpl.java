package com.example.springbootproject.dao;

import com.example.springbootproject.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers()  {
        String hql = "SELECT a FROM User a";
        return em.createQuery(hql, User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        em.remove(getUserById(id));
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void editUser(User user) {
        em.merge(user);
    }
}
