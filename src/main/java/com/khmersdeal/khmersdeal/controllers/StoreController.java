package com.khmersdeal.khmersdeal.controllers;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.services.UserServices;
import com.khmersdeal.khmersdeal.services.impl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/stores")

public class StoreController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private FileUploadService fileUploadService;



    @GetMapping("/add")
    public String showAddStoreForm(Model model){

        model.addAttribute("store", new Store());
        model.addAttribute("userOwner",this.userServices.getAllUsers(""));
        return "/admin/stores/add-store";
    }

    @PostMapping("/add/submit")
    public String AddStoreForm(Store store, @RequestParam("storePhoto")MultipartFile file){
        System.out.println(store);
        System.out.println(file);
        return "redirect:/admin/stores/add";
    }


}
