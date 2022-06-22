package com.e.commerce.dao.impl;

import com.e.commerce.dao.UserDao;
import com.e.commerce.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUtilisateur(String util, String mdp)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            Criterion critere = Restrictions.eq("utilisateur", util);
            Criterion critere1 = Restrictions.eq("mdp", mdp);
            criteria.add(critere);
            criteria.add(critere1);
            List valiny=criteria.list();
            if (valiny.size()==0)
            {
                return new User();
            }
            else
            {
                User utilisa=(User) valiny.get(0);
                tx.commit();
                return utilisa;
            }

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
