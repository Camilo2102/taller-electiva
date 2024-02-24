package com.example.tallerelectiva.controller;

import com.example.tallerelectiva.DTO.GamePlatformDTO;
import com.example.tallerelectiva.DTO.AssignCharacterDTO;
import com.example.tallerelectiva.DTO.AssignDeveloperDTO;
import com.example.tallerelectiva.DTO.MultipleGamePlatformDTO;
import com.example.tallerelectiva.controller.internal.CrudController;
import com.example.tallerelectiva.exeptions.HttpException;
import com.example.tallerelectiva.models.GameModel;
import com.example.tallerelectiva.responses.ResponseHandler;
import com.example.tallerelectiva.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/game")
public class GameController extends CrudController<GameModel> {
    private final GameService gameService;
    @Autowired
    protected GameController(GameService gameService) {
        super(gameService);
        this.gameService = gameService;
    }

    @PostMapping("/assignNewDeveloper")
    public ResponseEntity<?> assignDeveloper(@RequestBody AssignDeveloperDTO assignDeveloperDTO) throws HttpException {
        GameModel gameModified = this.gameService.setDeveloper(assignDeveloperDTO.getGameId(), assignDeveloperDTO.getDeveloper());
        return ResponseHandler.generateResponse("Modified developer successfully", HttpStatus.OK, gameModified);
    }

    @PostMapping("/assignDeveloper")
    public ResponseEntity<?> assignDeveloperById(@RequestBody AssignDeveloperDTO assignDeveloperDTO) throws HttpException {
        GameModel gameModified = this.gameService.setDeveloper(assignDeveloperDTO.getGameId(), assignDeveloperDTO.getDeveloper().getId());
        return ResponseHandler.generateResponse("Modified developer successfully", HttpStatus.OK, gameModified);
    }

    @PostMapping("/addPlatform")
    public ResponseEntity<?> addNewPlatform(@RequestBody GamePlatformDTO gamePlatformDTO) throws HttpException {
        GameModel gameModified = this.gameService.addNewPlatform(gamePlatformDTO.getGameId(), gamePlatformDTO.getPlatformModel());
        return ResponseHandler.generateResponse("Added platform successfully", HttpStatus.OK, gameModified);
    }

    @PostMapping("/updatePlatforms")
    public ResponseEntity<?> updatePlatforms(@RequestBody MultipleGamePlatformDTO multipleGamePlatformDTO) throws HttpException {
        GameModel gameModified = this.gameService.updatePlatforms(multipleGamePlatformDTO.getGameId(), multipleGamePlatformDTO.getPlatforms());
        return ResponseHandler.generateResponse("Added platform successfully", HttpStatus.OK, gameModified);
    }

    @PostMapping("/deletePlatform")
    public ResponseEntity<?> deletePlatform(@RequestBody  GamePlatformDTO gamePlatformDTO) throws HttpException {
        GameModel gameModified = this.gameService.deletePlatform(gamePlatformDTO.getGameId(), gamePlatformDTO.getPlatformModel().getId());
        return ResponseHandler.generateResponse("Added platform successfully", HttpStatus.OK, gameModified);
    }

    @PostMapping("/deletePlatforms")
    public ResponseEntity<?> deletePlatforms(@RequestBody MultipleGamePlatformDTO multipleGamePlatformDTO) throws HttpException {
        GameModel gameModified = this.gameService.deletePlatforms(multipleGamePlatformDTO.getGameId(), multipleGamePlatformDTO.getPlatforms());
        return ResponseHandler.generateResponse("Added platform successfully", HttpStatus.OK, gameModified);
    }

    @PostMapping("/assignNewCharacter")
    public ResponseEntity<?> assignDeveloper(@RequestBody AssignCharacterDTO assignCharacterDTO) throws HttpException {
        GameModel gameModified = this.gameService.setMainCharacter(assignCharacterDTO.getGameId(), assignCharacterDTO.getCharacter());
        return ResponseHandler.generateResponse("Modified character successfully", HttpStatus.OK, gameModified);
    }

}
