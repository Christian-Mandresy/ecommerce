package com.e.commerce.service.impl;

import com.e.commerce.dao.ProduitDao;
import com.e.commerce.model.Produit;
import com.e.commerce.model.ProduitCategorie;
import com.e.commerce.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitDao produitDao;

    @Override
    public List findall()
    {
        return produitDao.findall();
    }

    @Override
    public void save(Produit produit, ProduitCategorie[] produitCategories)
    {
        try {
            produitDao.save(produit,produitCategories);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
