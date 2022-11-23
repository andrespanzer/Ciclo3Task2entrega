package com.ciclo3.TodoCompleto.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Profiles")
public class Profile {
    @Id
    private Long idProfile;
    @Column
    private String nameProfile;

    @Column
    private String phoneProfile;

    @OneToMany(mappedBy = "profileTask")
    private List<Task> tasks;

    @Column
    private java.sql.Date createdAtProfile;
    @Column
    private Date updatedAtProfile;



    public Profile(Long idProfile, String nameProfile, String NITProfile, String phoneProfile, String addressProfile) {
        this.idProfile = idProfile;
        this.nameProfile = nameProfile;
        this.phoneProfile = phoneProfile;
    }

    public Profile() {
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    public String getPhoneProfile() {
        return phoneProfile;
    }

    public void setPhoneProfile(String phoneProfile) {
        this.phoneProfile = phoneProfile;
    }


    public java.sql.Date getCreatedAtProfile() {
        return createdAtProfile;
    }

    public void setCreatedAtProfile(java.sql.Date createdAtProfile) {
        this.createdAtProfile = createdAtProfile;
    }

    public Date getUpdatedAtProfile() {
        return updatedAtProfile;
    }

    public List<Task> getTask(){
        return tasks;
    }

    public void setUpdatedAtProfile(Date updatedAtProfile) {
        this.updatedAtProfile = updatedAtProfile;
    }
}
