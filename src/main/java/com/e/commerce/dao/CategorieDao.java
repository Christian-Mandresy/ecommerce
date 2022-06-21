package com.e.commerce.dao;

import java.util.List;

public interface CategorieDao {
    List findCategParent();

    List findSousCat(int id);
}
