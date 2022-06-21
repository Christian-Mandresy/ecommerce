package com.e.commerce.service;

import java.util.List;

public interface CategorieService {
    List findCategParent();

    List findSousCat(int id);
}
