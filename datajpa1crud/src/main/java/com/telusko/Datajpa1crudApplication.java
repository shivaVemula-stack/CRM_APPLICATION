package com.telusko;

import com.telusko.entity.Product;
import com.telusko.service.IProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Datajpa1crudApplication {

	public static void main(String[] args) {

        ConfigurableApplicationContext container = SpringApplication.run(Datajpa1crudApplication.class, args);
        IProductService service = container.getBean(IProductService.class);

        Product pd1 = new Product("Laptop", "Electronics", 45000.00, 980);
        System.out.println(service.saveproduct(pd1));

//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Books","Stationery",200.00,120));
//        products.add(new Product("Watch","Electronics",4000.00,50));
//        products.add(new Product("Jacket","Clothing",2000.00,450));
//        products.add(new Product("Mobile","Electronics",20000.00,500));
//
//        service.saveMultipleProducts(products).forEach(p-> System.out.println(p));
//          service.getAllProducts().forEach(p-> System.out.println(p));
        Product product = service.getProductById(1);
        System.out.println(product);
        System.out.println(service.isProductAvailable(1));
        List<Integer>ids = Arrays.asList(53,52,55);
//        service.getAllProdutsByIds(ids).forEach(p-> System.out.println(p));
//        Long totalProductsCount = service.getTotalProductsCount();
//        System.out.println(totalProductsCount);
//        System.out.println( service.deleteProductById(52));
        System.out.println(service.deleteProductsByIds(ids));

    }

}
