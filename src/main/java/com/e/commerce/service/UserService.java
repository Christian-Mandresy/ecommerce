package com.e.commerce.service;


import com.e.commerce.model.User;

public interface UserService {
    User getUtilisateur(String user, String mdp);
}
