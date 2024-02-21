package com.example.demo1.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo1.model.Medicine;
import com.example.demo1.service.MedicineService;
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
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @PostMapping("/addmed")
    public Medicine addMedicine(@RequestBody Medicine medicine) {  
        return medicineService.addMedicine(medicine);
    }
    @GetMapping("/getmed")
    public List<Medicine> getMedicines() { 
        return medicineService.getMedicines();
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
