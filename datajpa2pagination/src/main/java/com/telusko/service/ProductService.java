package com.telusko.service;

import com.telusko.entity.Product;
import com.telusko.repo.IProductRepo;
import org.hibernate.query.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo repo;

    @Override
    public void fetchProductByPagination(int pageSize) {
        long count = 12l;
        long pageCount = count/pageSize;    // => 12/3 = 4
        //14/5 = 2.8 => 2 => 3
        // 14%5 != 0 ? increment the pagecount
        // 14%2 == 0 ? keep pagecount
        pageCount = count%pageSize==0?pageCount:++pageCount;

        for (int i=0 ; i < pageCount; i++){
            PageRequest pageable = PageRequest.of(i, pageSize);
            Page<Product> page = repo.findAll(pageable);
            page.getContent().forEach(product -> System.out.println(product));
            System.out.println("*************************************");
        }


    }

    @Override
    public Iterable<Product> fetchProductByPagination(int pageNo, int pageSize, Boolean status, String... properties) {
        Sort sort = Sort.by(status? Sort.Direction.ASC: Sort.Direction.DESC, properties);
        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Product> page = repo.findAll(pageable);
        return  page.getContent();
    }

    @Override
    public Iterable<Product> fetchProductInfoSorting(Boolean status, String... properties) {
        Sort sort = Sort.by(status? Sort.Direction.ASC: Sort.Direction.DESC,properties);
        return repo.findAll(sort);
    }
}
