package com.ciclo3.TodoCompleto.Controllers;


import com.ciclo3.TodoCompleto.Models.Profile;
import com.ciclo3.TodoCompleto.Service.InterfaceProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProfileController {

    @Autowired
    private InterfaceProfile ProfileBDX;


    @GetMapping("/ProfileRegister")
    public String getProfileRegister(Model model){
        model.addAttribute("formProfileRegister",new Profile());
        return "ProfileRegister";
    }

    @PostMapping("/CreateProfileBD")
    public String CreateProfile (@ModelAttribute("redirect:/WelcomeProfile") Profile ProfileX){
        ProfileBDX.setCreateProfile(ProfileX);
        return "redirect:/WelcomeProfile";
    }


    @GetMapping("/profileList")
    public String getUserList(Model model){
        model.addAttribute("Profile",ProfileBDX.getProfile());
        return "ProfileList";
    }

    @PostMapping("/deleteProfileBD/{idProfile}")
    public String deleteProfile(@PathVariable Long idProfile, Model model){
        try {
            ProfileBDX.getDeleteProfile(idProfile);
            return "redirect:/WelcomeProfile";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @GetMapping("/updateProfileBD/{idProfile}")
    public String updateProfile(@PathVariable Long idProfile, Model model){
        try {
            model.addAttribute("ProfileUpdate",ProfileBDX.getOnlyOneProfile(idProfile));
            return "updateProfileNew";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PostMapping("/updateProfileBD")
    public String updateProfile(@ModelAttribute("redirect:/WelcomeProfile") Profile ProfileX){
        try {
            ProfileBDX.getUpdateProfile(ProfileX);
            return "redirect:/WelcomeProfile";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }
    @GetMapping("/TaskOfProfileBD/{idProfile}")
    public String TaskOfProfile(@PathVariable Long idProfile, Model model){
        try {
            Profile ProfileX = ProfileBDX.getOnlyOneProfile(idProfile);
            model.addAttribute("TasksProfile",ProfileX.getTask());
            return "TasksOfProfile";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

}
