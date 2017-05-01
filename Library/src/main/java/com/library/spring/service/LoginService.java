package com.library.spring.service;

import com.library.spring.model.*;

public interface LoginService{    
       public boolean checkLogin(String userName, String userPassword);
}