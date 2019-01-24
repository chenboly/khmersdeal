package com.khmersdeal.khmersdeal.services;

import com.khmersdeal.khmersdeal.models.Store;
import com.khmersdeal.khmersdeal.utilities.Paginate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreServices {
    List<Store> getAllStores(String name);
    List<Store> getAllStoresPagination(String name, Paginate paginate);
    int count(String name);
    boolean save (Store store);
    int update (Store store);
    int delete (Integer id);
}
