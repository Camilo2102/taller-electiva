package com.example.tallerelectiva.controller;

import com.example.tallerelectiva.controller.internal.CrudController;
import com.example.tallerelectiva.models.DeveloperModel;
import com.example.tallerelectiva.repositories.DeveloperRepository;
import com.example.tallerelectiva.services.internal.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/developer")
public class DeveloperController extends CrudController<DeveloperModel> {

    @Autowired
    protected DeveloperController(DeveloperRepository developerRepository) {
        super(new CrudService<>(developerRepository));
    }
}
