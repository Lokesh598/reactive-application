package com.lokesh.cloud.employee.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Slf4j
@Controller
public class SecureController {
    public static final String AUTHENTICATED_PATH = "/authenticated";
    @RequestMapping(AUTHENTICATED_PATH)
    public String authenticated() {
        log.info("✅ authenticated called");
        return "authenticated";
    }

    @RequestMapping("/users")
    @PreAuthorize("hasAuthority('users')")
    public String users() {
        return "roles";
    }

    @RequestMapping("/admins")
    @PreAuthorize("hasAuthority('admins')")
    public String admins() {
        return "roles";
    }

    @RequestMapping("/403")
    public String error403() {
        return "403";
    }
}
