package com.e.commerce.service.impl;



import com.e.commerce.dao.UserDao;
import com.e.commerce.model.User;
import com.e.commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUtilisateur(String user, String mdp)
    {
        return userDao.getUtilisateur(user,mdp);
    }
}
