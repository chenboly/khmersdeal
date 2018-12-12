package com.khmersdeal.khmersdeal.controllers.restcontrollers;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.services.StoreServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreRestController{
    private StoreServices storeServices;

    public StoreRestController(StoreServices storeServices) {
        this.storeServices = storeServices;
    }
    @GetMapping("")
    public List<Store> getAllStores(){
        return this.storeServices.getAllStores();
    }

}
