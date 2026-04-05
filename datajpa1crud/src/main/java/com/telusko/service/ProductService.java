package com.telusko.service;

import com.telusko.entity.Product;
import com.telusko.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo repo;

    @Override
    public Long getTotalProductsCount() {
        System.out.println("Implementing class of Repo "+ repo.getClass().getName());
        return repo.count();
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isPresent())
            return optional.get();
        return new Product();
    }

    @Override
    public Iterable<Product> getAllProdutsByIds(List<Integer> ids) {
        return repo.findAllById(ids);
    }

    @Override
    public boolean isProductAvailable(Integer id) {
        return repo.existsById(id);
    }

    @Override
    public String deleteProductsByIds(List<Integer> ids) {
        List<Product> products = (List<Product>) repo.findAllById(ids); // downcasting to list from iterable
        if (products.size() != 0)               //deletes even one record is found
//      if (products.size() == ids.size())      //deletes only when all the records are present
        {
            repo.deleteAllById(ids);
            return "All records with given IDs will be deleted";
        }
        else {
            return "Product Info given ids are not in records to delete";
        }

    }

    @Override
    public String deleteProductById(Integer id) {
        Optional<Product> optional = repo.findById(id);
        if (optional.isPresent()){
            repo.deleteById(id);
            return "Product with id "+ id + " is deleted";
        }else {
            return "Product with id "+ id + " is not in records";

        }
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public String saveproduct(Product product) {

        Product pd = repo.save(product);
        return "Product Stored with id"+ pd.getId();
    }

    

}
