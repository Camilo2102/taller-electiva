package com.example.tallerelectiva.controller;

import com.example.tallerelectiva.controller.internal.CrudController;
import com.example.tallerelectiva.models.MainCharacterModel;
import com.example.tallerelectiva.repositories.MainCharacterRepository;
import com.example.tallerelectiva.services.internal.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class MainCharacterController extends CrudController<MainCharacterModel> {

    @Autowired
    protected MainCharacterController(MainCharacterRepository mainCharacterRepository) {
        super(new CrudService<>(mainCharacterRepository));
    }
}
