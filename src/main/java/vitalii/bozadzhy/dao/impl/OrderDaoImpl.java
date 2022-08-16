package vitalii.bozadzhy.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import vitalii.bozadzhy.dao.OrderDao;
import vitalii.bozadzhy.exception.DataProcessingException;
import vitalii.bozadzhy.lib.Dao;
import vitalii.bozadzhy.model.Order;
import vitalii.bozadzhy.model.User;
import vitalii.bozadzhy.util.HibernateUtil;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can not add order " + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery("SELECT DISTINCT o "
                    + "FROM Order o "
                    + "JOIN FETCH o.user "
                    + "JOIN FETCH o.tickets t "
                    + "JOIN FETCH t.movieSession ms "
                    + "JOIN FETCH ms.movie "
                    + "JOIN FETCH ms.cinemaHall "
                    + "WHERE o.user = :user", Order.class);
            return query.setParameter("user", user).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find order by user: " + user, e);
        }
    }
}
