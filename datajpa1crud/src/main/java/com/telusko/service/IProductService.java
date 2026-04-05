package com.telusko.service;

import com.telusko.entity.Product;

import java.util.List;

public interface IProductService {
    String saveproduct(Product product);
    Iterable<Product> saveMultipleProducts(Iterable<Product> products);
    Iterable<Product> getAllProducts();
    String deleteProductById(Integer id);
    Product getProductById(Integer id);
    boolean isProductAvailable(Integer id);
    Iterable<Product> getAllProdutsByIds(List<Integer> ids);
    Long getTotalProductsCount();
    String deleteProductsByIds(List<Integer> ids);



}
