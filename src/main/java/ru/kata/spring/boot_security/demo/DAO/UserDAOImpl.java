package ru.kata.spring.boot_security.demo.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext()
    private EntityManager entityManager;
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User showUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    public void update(User updateUser) {
        entityManager.merge(updateUser);
        entityManager.flush();
    }

    public void delete(Long id) {
        entityManager.remove(showUser(id));
        entityManager.flush();
    }

    @Override
    public User findByUser(String email) {
        return (User)entityManager.createQuery("from User u where u.email = :email")
                .setParameter("email", email).getResultList().get(0);
    }
}
