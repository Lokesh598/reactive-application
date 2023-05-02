package com.lokesh.cloud.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

import java.security.Principal;

@Controller
public class HomeController {
//    @GetMapping("/")
//    String home(Principal user) {
////        return "Hello " + user.getName();
//        if(user!=null) {
//            return "redirect:" + SecureController.AUTHENTICATED_PATH;
//        }
//        return "home";
//    }
    @GetMapping("/home")
    public Mono<Rendering> redirect(Principal user) {
        String fullName = user.getName();
        Mono.just(Rendering.redirectTo("http://localhost:4200/Home").build())
                .map(rendering -> {
                    rendering.modelAttributes().put("key", fullName);
                    return rendering;
                });
        return null;
    }

//    @GetMapping("/swagger")
//    public Mono<Rendering> redirectToSwagger () {
//        return Mono.just(Rendering.redirectTo("http://localhost:8092/swagger-ui.html#/").build());
//    }
}
