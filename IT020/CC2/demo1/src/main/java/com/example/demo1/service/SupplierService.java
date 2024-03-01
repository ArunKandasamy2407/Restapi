package com.example.demo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo1.model.Suppliers;
import com.example.demo1.repo.SupplierRepo;

@Service
public class SupplierService {
    @Autowired
    SupplierRepo obj;
    public Suppliers postSupplier(Suppliers suppliers)
    {
          return obj.save(suppliers);
    }
    public List<Suppliers> getSuppliers()
    {
        
        return obj.findAll();
    }
    public Optional<Suppliers> getById(int supplierId)
    {
        return obj.findById(supplierId);
    }
    public void deleteMedicine(int supplierId) {
        
        Optional<Suppliers> medicineOptional = obj.findById(supplierId);
        if (medicineOptional.isPresent()) {
            obj.deleteById(supplierId);
        } else {
            throw new IllegalArgumentException("Supplier not found with id: " + supplierId);
        }
    }
}
