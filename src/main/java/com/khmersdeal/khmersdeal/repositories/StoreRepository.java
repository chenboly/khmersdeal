package com.khmersdeal.khmersdeal.repositories;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.repositories.providers.StoreProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository {

    @SelectProvider(type = StoreProvider.class, method = "getAllStoresProvider")
    List<Store> getAllStores();
}
