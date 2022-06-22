package com.e.commerce.service;

import com.e.commerce.model.Produit;

import java.util.List;

public interface ProduitService {
    List findall();

    abstract List finByCategorie(int id);
}
