package com.khmersdeal.khmersdeal.services.impl;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.repositories.StoreRepository;
import com.khmersdeal.khmersdeal.services.StoreServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreServices {
    private StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getAllStores() {
        return this.storeRepository.getAllStores();
    }
}
