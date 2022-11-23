package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.UsersApplication;

import java.util.List;

public interface ServiceInterfaceUser {
    public List<UsersApplication> getUsersApplication();


    public UsersApplication getOnlyOneUsersApplication(String userApplication) throws Exception;


    public String setCreateUsersApplication(UsersApplication UsersApplicationIn);


    public UsersApplication getUpdateUsersApplication(UsersApplication UsersApplicationIn) throws Exception;

    public String getDeleteUsersApplication(String userApplication);
}
