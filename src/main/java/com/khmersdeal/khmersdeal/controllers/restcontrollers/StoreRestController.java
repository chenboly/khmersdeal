package com.khmersdeal.khmersdeal.controllers.restcontrollers;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.services.StoreServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String, Object>> save(@RequestBody Store store){
        Map<String, Object> response = new HashMap<>();
        boolean status = this.storeServices.save(store);
        if(status = true){
            response.put("message", "Save Store Successfully!!!");
            response.put("status", true);
            return ResponseEntity.ok(response);
        }
        else {
            response.put("message", "Save Store Failed!!");
            response.put("status", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
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
