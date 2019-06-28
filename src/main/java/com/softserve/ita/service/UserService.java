package com.softserve.ita.service;

import com.softserve.ita.exception.DAOException;
import com.softserve.ita.model.User;

public interface UserService {

    User getUser(String email, String password) throws DAOException;
}
