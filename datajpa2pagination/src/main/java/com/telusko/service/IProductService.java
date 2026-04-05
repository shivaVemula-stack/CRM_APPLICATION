package com.telusko.service;

import com.telusko.entity.Product;

import java.util.List;

public interface IProductService {
    Iterable<Product> fetchProductInfoSorting(Boolean status, String...properties);
    Iterable<Product> fetchProductByPagination(int pageNo,int pageSize, Boolean status, String...properties);
   void fetchProductByPagination(int pageSize);

}
