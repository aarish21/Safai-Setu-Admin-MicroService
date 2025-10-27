package com.aarish.safai_setu_admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aarish.safai_setu_admin.model.Report;
import com.aarish.safai_setu_admin.repo.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository repo;
	
	public List<Report> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Report verifyResolve(int id) {
		// TODO Auto-generated method stub
		Optional<Report> optional = repo.findById(id);
		Report report = optional.get();
		
		if ("Pending Verification".equals(report.getStatus())) {
            report.setStatus("Resolved");
            return repo.save(report);
        }

        return null;
	}
}
