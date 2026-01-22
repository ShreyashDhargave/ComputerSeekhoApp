package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entities.Staff;
import com.example.services.StaffService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    // CREATE
    @PostMapping
    public Staff createStaff(@Valid @RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }

    // READ ALL
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    // READ BY USERNAME
    @GetMapping("/username/{username}")
    public Staff getByUsername(@PathVariable String username) {
        return staffService.findByStaffUsername(username);
    }

    // UPDATE
    @PutMapping
    public String updateStaff(@Valid @RequestBody Staff staff) {
        boolean updated = staffService.updateStaff(staff);
        return updated ? "Staff updated successfully" : "Staff not found";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStaff(@PathVariable int id) {
        boolean deleted = staffService.deleteByStaffId(id);
        return deleted ? "Staff deleted successfully" : "Staff not found";
    }
}
