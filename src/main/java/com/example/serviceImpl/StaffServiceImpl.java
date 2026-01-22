package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.entities.Staff;
import com.example.repositories.StaffRepository;
import com.example.services.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Staff saveStaff(Staff staff) {
        staff.setStaffPassword(
            passwordEncoder.encode(staff.getStaffPassword())
        );
        return staffRepository.save(staff);
    }


    @Override
    public Staff findByStaffUsername(String staffUsername) {
        Optional<Staff> staff = staffRepository.findByStaffUsername(staffUsername);
        return staff.orElse(null);
    }

    @Override
    public boolean updateStaff(Staff staff) {
        if (staffRepository.existsById(staff.getStaffId())) {
            staffRepository.save(staff);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByStaffId(int staffId) {
        if (staffRepository.existsById(staffId)) {
            staffRepository.deleteById(staffId);
            return true;
        }
        return false;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public int getStaffIdByStaffUsername(String username) {
        return staffRepository.getStaffIdByStaffUsername(username);
    }
}
