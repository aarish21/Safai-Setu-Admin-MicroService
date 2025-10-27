package com.aarish.safai_setu_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aarish.safai_setu_admin.model.Report;
import com.aarish.safai_setu_admin.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService service;
	
	@GetMapping("/report")
	public ResponseEntity<?> getReports(){
		return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
	}
	
	@PutMapping("/resolve/{id}")
	public ResponseEntity<?> verifyResolve(@PathVariable int id) {
		Report report = service.verifyResolve(id);
		if(report == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST) 
					.body("No pending report found or already verified.");
		}
		 return ResponseEntity.ok("Report verified and marked as resolved!");
	}
}
