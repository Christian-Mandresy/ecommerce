package com.e.commerce.dao.impl;

import com.e.commerce.dao.CategorieDao;
import com.e.commerce.model.Categorie;
import com.e.commerce.model.Produit;
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
public class CategorieDaoImpl implements CategorieDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List findCategParent()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria=session.createCriteria(Categorie.class);
            Criterion criterion= Restrictions.isNull("idParent");
            criteria.add(criterion);
            List type = criteria.list();
            tx.commit();
            return type;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List findSousCat(int id)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria=session.createCriteria(Categorie.class);
            Criterion criterion= Restrictions.eq("idParent",id);
            criteria.add(criterion);
            List type = criteria.list();
            tx.commit();
            return type;
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
