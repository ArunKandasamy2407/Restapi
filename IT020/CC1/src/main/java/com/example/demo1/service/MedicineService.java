package com.example.demo1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.model.Medicine;
import com.example.demo1.repo.MedicineRepo;

@Service
public class MedicineService {
    @Autowired
    MedicineRepo medicineRepo;
    public Medicine addMedicine(Medicine medicine)
    {
        return medicineRepo.save(medicine);
    }
    public List<Medicine> getMedicines()
    {
        return medicineRepo.findAll();
    }   
    public Optional<Medicine> getById(Long medicineId)
    {
        return medicineRepo.findById(medicineId);
    }
    public Medicine updateMedicine(Long medicineId, Medicine updatedMedicine) {
        Optional<Medicine> existingMedicineOptional = medicineRepo.findById(medicineId);
        if (existingMedicineOptional.isPresent()) {
            Medicine existingMedicine = existingMedicineOptional.get();
            existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
            existingMedicine.setDescription(updatedMedicine.getDescription());
            existingMedicine.setExpiryDate(updatedMedicine.getExpiryDate());
            existingMedicine.setMedicineId(updatedMedicine.getMedicineId());
            existingMedicine.setManufacturedIn(updatedMedicine.getManufacturedIn());
            existingMedicine.setMedicineFor(updatedMedicine.getMedicineFor());
            existingMedicine.setMedicinePrice(updatedMedicine.getMedicinePrice());
            existingMedicine.setMedicineBrand(updatedMedicine.getMedicineBrand());
            return medicineRepo.save(existingMedicine);
        } else 
        {
            throw new IllegalArgumentException("Medicine not found with id: " + medicineId);
        }
    }

    public void deleteMedicine(Long medicineId) {
        
        Optional<Medicine> medicineOptional = medicineRepo.findById(medicineId);
        if (medicineOptional.isPresent()) {
            medicineRepo.deleteById(medicineId);
        } else {
            throw new IllegalArgumentException("Medicine not found with id: " + medicineId);
        }
    }
}