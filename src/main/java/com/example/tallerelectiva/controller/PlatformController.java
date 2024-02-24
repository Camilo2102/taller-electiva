package com.example.tallerelectiva.controller;

import com.example.tallerelectiva.DTO.MultiplePlatformGame;
import com.example.tallerelectiva.DTO.PlatformGameDTO;
import com.example.tallerelectiva.controller.internal.CrudController;
import com.example.tallerelectiva.exeptions.HttpException;
import com.example.tallerelectiva.models.PlatformModel;
import com.example.tallerelectiva.repositories.PlatformRepository;
import com.example.tallerelectiva.responses.ResponseHandler;
import com.example.tallerelectiva.services.GameService;
import com.example.tallerelectiva.services.PlatformService;
import com.example.tallerelectiva.services.internal.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform")
public class PlatformController extends CrudController<PlatformModel> {

    private final PlatformService platformService;
    @Autowired
    protected PlatformController(PlatformService platformService) {
        super(platformService);
        this.platformService = platformService;
    }

    @PostMapping("/addNewGame")
    public ResponseEntity<?> addNewGame(@RequestBody PlatformGameDTO platformGame) throws HttpException {
        PlatformModel platform = this.platformService.addGame(platformGame.getPlatformId(), platformGame.getGame());
        return ResponseHandler.generateResponse("Added game successfully", HttpStatus.OK, platform);
    }

    @PostMapping("/addGames")
    public ResponseEntity<?> addNewGame(@RequestBody MultiplePlatformGame platformGames) throws HttpException {
        PlatformModel platform = this.platformService.addGames(platformGames.getPlatformId(), platformGames.getGames());
        return ResponseHandler.generateResponse("Added games successfully", HttpStatus.OK, platform);
    }

    @PostMapping("/removeGame")
    public ResponseEntity<?> removeGame(@RequestBody PlatformGameDTO platformGameDTO) throws HttpException {
        PlatformModel platform = this.platformService.removeGame(platformGameDTO.getPlatformId(), platformGameDTO.getGame().getId());
        return ResponseHandler.generateResponse("Remove game successfully", HttpStatus.OK, platform);
    }
}
