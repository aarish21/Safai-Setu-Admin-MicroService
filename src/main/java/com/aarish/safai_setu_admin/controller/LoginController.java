package com.aarish.safai_setu_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/admin/login")
    public String loginPage() {
        return "login"; // This will load login.html (from templates/)
    }
}
