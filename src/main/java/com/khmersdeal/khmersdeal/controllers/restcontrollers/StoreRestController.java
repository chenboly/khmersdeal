package com.khmersdeal.khmersdeal.controllers.restcontrollers;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.services.StoreServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public String save(@RequestBody Store store){
        int status = this.storeServices.save(store);
        if(status > 0){
            return "Save store successfully!!";
        }
        return "Save store failed!!";
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<String> update (@RequestBody Store store){
        int status = this.storeServices.update(store);
        if (status > 0){
            return ResponseEntity.ok("Update Store Successfully !!");
        }return new ResponseEntity<>("Update Store Failed!!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") Integer id){
        int status = this.storeServices.delete(id);
        if(status > 0){
            return ResponseEntity.ok("Delete Store Successfully!!");
        }return new ResponseEntity<>("Delete Store Failed!!", HttpStatus.NOT_FOUND);
    }

}
