package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo1.model.Medicine;
import com.example.demo1.model.Suppliers;
import com.example.demo1.service.MedicineService;
import com.example.demo1.service.SupplierService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MedicineController
{
    @Autowired
    MedicineService medicineService;
    @Autowired
    SupplierService supplierService;

    @PostMapping("/addmed")
    public Medicine addMedicine(@RequestBody Medicine medicine) {  
        return medicineService.addMedicine(medicine);
    }
    @PostMapping("/postsupplier")
    public Suppliers postMethodName(@RequestBody Suppliers entity) {
        
        return supplierService.postSupplier(entity);
    }
    
    @GetMapping("/getmed/{no}/{sz}")
    public List<Medicine> getMedicines(@PathVariable int no, @PathVariable int sz) {
        return medicineService.getMedicines(no,sz);
    }
    @GetMapping("/getsupplier")
    public List<Suppliers> getSuppliers() { 
        return supplierService.getSuppliers();
    }
    @GetMapping("/getmed/{id}")
    public Optional<Medicine> getMedicineById(@PathVariable("id") Long medicineId) {
        return medicineService.getById(medicineId);
    }    
    @PutMapping("/updatemed/{id}")
    public Medicine updateMedicine(@PathVariable("id") Long medicineId, @RequestBody Medicine medicine) {
    return medicineService.updateMedicine(medicineId, medicine);
    }
    @DeleteMapping("/deletemed/{id}")
    public void deleteMedicine(@PathVariable("id") Long medicineId) {
        medicineService.deleteMedicine(medicineId);
    }
}
