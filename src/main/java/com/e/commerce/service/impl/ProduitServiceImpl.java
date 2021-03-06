package com.e.commerce.service.impl;

import com.e.commerce.dao.ProduitDao;
import com.e.commerce.model.Produit;
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
    public List finByCategorie(int id)
    {
        return produitDao.findByCategorie(id);
    }

    @Override
    public List findMulti(String nom, String idcategorie, String prix1, String prix2)
    {
        return produitDao.findMulti(nom,idcategorie,prix1,prix2);
    }
}
