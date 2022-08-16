package vitalii.bozadzhy.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vitalii.bozadzhy.dao.TicketDao;
import vitalii.bozadzhy.exception.DataProcessingException;
import vitalii.bozadzhy.lib.Dao;
import vitalii.bozadzhy.model.Ticket;
import vitalii.bozadzhy.util.HibernateUtil;

@Dao
public class TicketDaoImpl implements TicketDao {
    @Override
    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert a ticket: " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
