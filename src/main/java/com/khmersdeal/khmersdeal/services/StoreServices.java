package com.khmersdeal.khmersdeal.services;

import com.khmersdeal.khmersdeal.models.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreServices {
    List<Store> getAllStores();
    boolean save (Store store);
    int update (Store store);
    int delete (Integer id);
}
