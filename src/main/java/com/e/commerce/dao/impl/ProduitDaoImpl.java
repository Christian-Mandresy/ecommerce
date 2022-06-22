package com.e.commerce.dao.impl;

import com.e.commerce.dao.ProduitDao;
import com.e.commerce.model.Produit;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public List findByCategorie(int idCateg)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria=session.createCriteria(Produit.class);
            Criterion criterion= Restrictions.eq("idcategorie",idCateg);
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
    public List findMulti(String nom, String idCategorie, String prix1, String prix2)
    {
        Session session = this.sessionFactory.openSession();
        try {

            // test si dans la clause where il faut mettre where ou and
            Boolean test=true;
            StringBuilder sql=new StringBuilder("select * from Produit ");
            if (nom.equals("")==false) {
                sql.append(test ? "where " : " and ");
                sql.append("nom like "+nom);
                test=false;
            }
            if (idCategorie.equals("")==false) {
                sql.append(test ? "where " : " and ");
                sql.append("idcategorie = "+idCategorie);
                test=false;
            }
            if (prix1.equals("")==false && prix2.equals("")==false) {
                sql.append(test ? "where " : " and ");
                sql.append("prix between "+prix1+ " and "+prix2);
                test=false;
            }

            String queryFinal=sql.toString();
            SQLQuery query= session.createSQLQuery(queryFinal)
                    .addEntity(Produit.class);
            List resultat = query.list();
            return resultat;
        } catch (Exception e) {
            throw e;
        }
        finally {
            session.close();
        }
    }


}
