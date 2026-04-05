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

//        service.fetchProductInfoSorting(false,"price").
//                forEach(product -> System.out.println(product));
//        service.fetchProductByPagination(1,2,false,"price").
//                forEach(product -> System.out.println(product));

        service.fetchProductByPagination(5);

    }

}
