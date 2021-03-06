//package com.trainingApplication.repository.user;
//
//import com.trainingApplication.domain.UserEntity;
//import lombok.AllArgsConstructor;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//@Transactional
//@AllArgsConstructor
//public class HibernateUserRepository implements UserRepository {
//
//    private final SessionFactory sessionFactory;
//
//    public UserEntity save(UserEntity userEntity) {
//        sessionFactory.openSession().save(userEntity);
//        return userEntity;
//    }
//
//    public List<UserEntity> findAll() {
//        return sessionFactory.openSession().createQuery("SELECT u FROM UserEntity u", UserEntity.class).list();
//    }
//
//    public boolean remove(Long id) {
//        var entity = getUserById(id);
//
//        if (sessionFactory.openSession().contains("entity", entity.orElse(null))) {
//            sessionFactory.openSession().remove(entity);
//            return true;
//        }
//        return false;
//    }
//
//    public UserEntity getUserEntityByNickNameAndPassword(String nickname, String password) {
//        String hql = "SELECT u FROM UserEntity u WHERE nickname =:nickname AND password =:password";
//        var query = sessionFactory.openSession().createQuery(hql);
//        query.setParameter("nickname", nickname);
//        query.setParameter("password", password);
//        List<UserEntity> userEntities = (List<UserEntity>) query.list();
//        return userEntities.stream().findFirst().orElse(null);
//    }
//
//    public Optional<UserEntity> getUserById(Long userId) {
//        var entity = (sessionFactory.openSession().get(UserEntity.class, userId));
//        return Optional.ofNullable(entity);
//    }
//
//    public UserEntity getUserByNickName(String nickname) {
//        var query = sessionFactory.openSession().createQuery(
//                "select u FROM UserEntity u where mail = :nickname");
//        query.setParameter("nickname", nickname);
//        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
//        if (!userList.isEmpty()) {
//            return userList.get(0);
//        }
//        return null;
//    }
//
//    public boolean existsUserByNickname(String nickname) {
//        var query = sessionFactory.openSession().createQuery(
//                "select u FROM UserEntity u where nickname = :nickname");
//        query.setParameter("nickname", nickname);
//        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
//        return !userList.isEmpty();
//    }
//
//    public UserEntity getUserByMail(String mail) {
//        var query = sessionFactory.openSession().createQuery(
//                "select u FROM UserEntity u where mail = :mail");
//        query.setParameter("mail", mail);
//        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
//        if (!userList.isEmpty()) {
//            return userList.get(0);
//        }
//        return null;
//    }
//
//    public boolean existsUserByMail(String mail) {
//        var query = sessionFactory.openSession().createQuery(
//                "select u FROM UserEntity u where mail = :mail");
//        query.setParameter("mail", mail);
//        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
//        return !userList.isEmpty();
//    }
//
//    public boolean verifyUserByNickname(String nickname) {
//        var query = sessionFactory.openSession().createQuery(
//                "select u FROM UserEntity u where nickname = :nickname");
//        query.setParameter("nickname", nickname);
//        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
//        return !userList.isEmpty();
//    }
//
//    public boolean verifyUserByPassword(String password) {
//        var query = sessionFactory.openSession().createQuery(
//                "select u FROM UserEntity u where password = :password");
//        query.setParameter("password", password);
//        List<UserEntity> userList = (List<UserEntity>) query.getResultList();
//        return !userList.isEmpty();
//    }
//}
