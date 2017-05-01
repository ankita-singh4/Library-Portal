package com.library.spring.service;

import com.library.spring.model.*;

public interface LoginService{    
       public Users checkLogin(String userName, String userPassword);
}