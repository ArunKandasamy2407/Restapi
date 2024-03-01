package com.example.demo1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.Suppliers;
@Repository
public interface SupplierRepo extends JpaRepository<Suppliers,Integer>{
    
}
