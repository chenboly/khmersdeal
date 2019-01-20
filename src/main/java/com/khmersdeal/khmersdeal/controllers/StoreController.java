package com.khmersdeal.khmersdeal.controllers;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/stores")

public class StoreController {

    @Autowired
    private UserServices userServices;



    @GetMapping("/add")
    public String showAddStoreForm(Model model){

        model.addAttribute("store", new Store());
        model.addAttribute("userOwner",this.userServices.getAllUsers(""));
        return "/admin/stores/add-store";
    }


}
