package com.library.spring.dao;
import com.library.spring.model.*;

public interface LoginDAO{    
       public Users checkLogin(String userName, String userPassword);
}