package com.ciclo3.TodoCompleto.Service;



import com.ciclo3.TodoCompleto.Models.Profile;

import java.util.List;

public interface InterfaceProfile {

    public List<Profile> getProfile();


    public Profile getOnlyOneProfile(Long idProfile) throws Exception;


    public String setCreateProfile(Profile ProfileIn);


    public Profile getUpdateProfile(Profile ProfileIn) throws Exception;

    public String getDeleteProfile(Long idProfile) throws Exception;

}
