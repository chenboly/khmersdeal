package com.khmersdeal.khmersdeal.services.impl;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.repositories.StoreRepository;
import com.khmersdeal.khmersdeal.services.StoreServices;
import com.khmersdeal.khmersdeal.utilities.Paginate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreServices {
    private StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store getOneStoreById(Integer id) {
        return this.storeRepository.getOneStoreById(id);
    }

    @Override
    public List<Store> getAllStores(String name) {
        return this.storeRepository.getAllStores(name);
    }

    @Override
    public List<Store> getAllStoresPagination(String name, Paginate paginate) {
        return this.storeRepository.getAllStoresPagination(name, paginate);
    }

    @Override
    public int count(String name) {
        return this.storeRepository.count(name);
    }

    @Override
    public boolean save(Store store) {
        return this.storeRepository.save(store);
    }

    @Override
    public int update(Store store) {
        return this.storeRepository.update(store);
    }

    @Override
    public int delete(Integer id) {
        return this.storeRepository.delete(id);
    }
}
