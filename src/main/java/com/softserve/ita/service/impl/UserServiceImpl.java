package com.softserve.ita.service.impl;

import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.User;
import com.softserve.ita.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUser(String email, String password) throws DAOException{
        User user = userDAO.getUserByEmailAndPassword(email, password);

        if (user == null) {
            throw new DAOException("User not found");
        }

        return user;
    }


}
