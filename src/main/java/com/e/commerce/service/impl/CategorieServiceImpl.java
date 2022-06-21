package com.e.commerce.service.impl;

import com.e.commerce.dao.CategorieDao;
import com.e.commerce.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieDao categorieDao;

    @Override
    public List findCategParent()
    {
        return categorieDao.findCategParent();
    }

    @Override
    public List findSousCat(int id)
    {
        return categorieDao.findSousCat(id);
    }
}
