package com.e.commerce.dao;


import com.e.commerce.model.User;

public interface UserDao {
    User getUtilisateur(String util, String mdp);
}
