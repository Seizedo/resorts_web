package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DAOFactory {

    private final MySQLDAO mySQLDAO;

    @Autowired
    public DAOFactory(MySQLDAO mySQLDAO) {
        this.mySQLDAO = mySQLDAO;
    }

    public IMyDAO getDAO() {
        return mySQLDAO;
    }
}


