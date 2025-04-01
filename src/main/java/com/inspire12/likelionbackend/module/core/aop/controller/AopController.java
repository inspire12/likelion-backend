package com.inspire12.likelionbackend.module.core.aop.controller;

import com.inspire12.likelionbackend.module.core.aop.model.request.UserRequest;
import com.inspire12.likelionbackend.module.core.aop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/aop")
@RestController
public class AopController {

    private final UserService userService;

    public AopController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/users")
    public ResponseEntity<Void> registerUser(@RequestBody UserRequest userRequest) {
        userService.registerUser(userRequest.getUsername(), userRequest.getEmail());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<Void> registerUser(@RequestBody UserRequest userRequest,
                                             @PathVariable Long id) {
        userService.geUser(id);

        return ResponseEntity.ok().build();
    }
}
