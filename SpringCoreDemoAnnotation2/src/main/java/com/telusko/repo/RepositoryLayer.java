package com.telusko.repo;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryLayer {
    public RepositoryLayer(){
        System.out.println("Repo layer object/bean created");
    }
}
