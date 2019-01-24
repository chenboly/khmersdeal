package com.khmersdeal.khmersdeal.controllers;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.models.User;
import com.khmersdeal.khmersdeal.services.StoreServices;
import com.khmersdeal.khmersdeal.services.UserServices;
import com.khmersdeal.khmersdeal.services.impl.FileUploadService;
import com.khmersdeal.khmersdeal.utilities.Paginate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin/stores")

public class StoreController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private StoreServices storeServices;


    //without pagination
    @GetMapping("/all")
    public String showAllStore(@RequestParam(required = false) String name, Model model){
        List<Store> stores = this.storeServices.getAllStores(name);
        model.addAttribute("storeList", stores);
        return "/admin/stores/all-stores";
    }

    //with pagination

    @GetMapping("/all/paginate")
    public String showAllStorePaginate(@RequestParam(required = false) String name, Model model, Paginate paginate){
        if (name == null)
            name="";
        int totalRecord = this.storeServices.count(name);
        paginate.setTotalCount(totalRecord);
        List<Store> stores = this.storeServices.getAllStoresPagination(name, paginate);
        model.addAttribute("storeList", stores);
        model.addAttribute("pagination", paginate);
        model.addAttribute("nameFilter", name);
        return "/admin/stores/all-stores";
    }

    @GetMapping("/add")
    public String showAddStoreForm(Model model){

        model.addAttribute("store", new Store());
        model.addAttribute("userOwner",this.userServices.getAllUsers(""));
        return "/admin/stores/add-store";
    }

    @PostMapping("/add/submit")
    public String AddStoreForm(Store store, @RequestParam("photo")MultipartFile file){
        System.out.println(store);
        System.out.println(file);
        String fileName = this.fileUploadService.upload(file);
        store.setImage_url(fileName);

        if(this.storeServices.save(store)){
            System.out.println("Save Success!!");
        }
        return "redirect:/admin/stores/add";
    }


}
