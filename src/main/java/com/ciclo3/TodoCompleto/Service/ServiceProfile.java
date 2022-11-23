package com.ciclo3.TodoCompleto.Service;


import com.ciclo3.TodoCompleto.Models.Profile;
import com.ciclo3.TodoCompleto.Repositories.RepositoryProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceProfile implements InterfaceProfile {

    Date Today = new Date();

    @Autowired
    RepositoryProfile repositoryProfile;

    @Override
    public List<Profile> getProfile() {
        return repositoryProfile.findAll();
    }


    @Override
    public Profile getOnlyOneProfile(Long idProfile) throws Exception {
        Optional<Profile> ProfileBD = repositoryProfile.findById(idProfile);
        if(ProfileBD.isPresent()){
            return ProfileBD.get();
        }
        throw new Exception("IdProfile no asignado a ninguna Profile de nuestra base de datos");
    }


    @Override
    public String setCreateProfile(Profile ProfileIn) {
        Optional<Profile> ProfileBD = repositoryProfile.findById(ProfileIn.getIdProfile());
        if(!ProfileBD.isPresent()){
            repositoryProfile.save(ProfileIn);
            return "Profile Creada con exito";

        }
        return ("Ese Id ya esta regitrado a una Profile Existente");
    }

    @Override
    public Profile getUpdateProfile(Profile ProfileIn) throws Exception {
        Profile ProfileBD = getOnlyOneProfile(ProfileIn.getIdProfile());

        if(ProfileIn.getNameProfile()!=null && !ProfileIn.getNameProfile().equals("")){
            ProfileBD.setNameProfile(ProfileIn.getNameProfile());
        }


        if(ProfileIn.getPhoneProfile()!=null && !ProfileIn.getPhoneProfile().equals("")){
            ProfileBD.setPhoneProfile(ProfileIn.getPhoneProfile());
        }

        if(ProfileIn.getCreatedAtProfile()!=null && !ProfileIn.getCreatedAtProfile().equals("")){
            ProfileBD.setCreatedAtProfile(ProfileIn.getCreatedAtProfile());
        }

        ProfileBD.setUpdatedAtProfile(Today);

        return repositoryProfile.save(ProfileBD);
    }

    @Override
    public String getDeleteProfile(Long idProfile) throws Exception {
        Optional<Profile> ProfileBD = repositoryProfile.findById(idProfile);
        if(ProfileBD.isPresent()){
            repositoryProfile.deleteById(idProfile);
            return "Profile Eliminada con exito";
        }
        throw new Exception("Profile NOOOOO encontarda");
    }
}
