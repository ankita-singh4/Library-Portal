package com.library.spring.dao;
import com.library.spring.model.*;

public interface LoginDAO{    
       public boolean checkLogin(String userName, String userPassword);
}