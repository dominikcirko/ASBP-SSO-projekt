package com.example.ASBPappProjekt.controller;
import com.example.ASBPappProjekt.service.GetUsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class GetUsersController {
    private final GetUsersService getUsersService;

    public GetUsersController(GetUsersService getUsersService) {
        this.getUsersService = getUsersService;
    }

    @GetMapping
    public List<String> listUsers() {
        return getUsersService.getAllUsers();
    }
}
