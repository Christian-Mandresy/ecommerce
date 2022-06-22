package com.e.commerce.dao.impl;

import com.e.commerce.dao.ProduitDao;
import com.e.commerce.model.Categorie;
import com.e.commerce.model.Produit;
import com.e.commerce.model.ProduitCategorie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProduitDaoImpl implements ProduitDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List findall()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List type = session.createCriteria(Produit.class).list();
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
    public void save(Produit prod, ProduitCategorie[] listcat)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = null;
        try
        {
            tx=session.beginTransaction();
            session.save(prod);
            int id=prod.getId();
            listcat[0].setIdproduit(id);
            session.save(listcat[0]);
            for (int i = 1; i < listcat.length; i++) {
                listcat[i].setIdproduit(id);
                session.save(listcat[i]);
            }
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }


}
