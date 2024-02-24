package com.example.tallerelectiva.services;

import com.example.tallerelectiva.exeptions.HttpException;
import com.example.tallerelectiva.models.MainCharacterModel;
import com.example.tallerelectiva.models.DeveloperModel;
import com.example.tallerelectiva.models.GameModel;
import com.example.tallerelectiva.models.PlatformModel;
import com.example.tallerelectiva.repositories.MainCharacterRepository;
import com.example.tallerelectiva.repositories.DeveloperRepository;
import com.example.tallerelectiva.repositories.GameRepository;
import com.example.tallerelectiva.repositories.PlatformRepository;
import com.example.tallerelectiva.services.internal.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService extends CrudService<GameModel> {
    private final CrudService<DeveloperModel> developerService;
    private final CrudService<MainCharacterModel> characterService;
    private final CrudService<PlatformModel> platformService;
    @Autowired
    public GameService(GameRepository repository, DeveloperRepository developerRepository, MainCharacterRepository mainCharacterRepository, PlatformRepository platformRepository) {
        super(repository);
        this.developerService = new CrudService<>(developerRepository);
        this.characterService = new CrudService<>(mainCharacterRepository);
        this.platformService = new CrudService<>(platformRepository);
    }

    public GameModel setDeveloper(String gameId, DeveloperModel developer) throws HttpException {
        GameModel gameFound = this.getOne(gameId);
        DeveloperModel developerCreated = this.developerService.save(developer);

        gameFound.setDeveloper(developerCreated);

        return this.save(gameFound);
    }

    public GameModel setDeveloper(String gameId, String developerId) throws HttpException {
        GameModel gameFound = this.getOne(gameId);
        DeveloperModel developerFound = this.developerService.getOne(developerId);

        gameFound.setDeveloper(developerFound);

        return this.save(gameFound);
    }

    public GameModel addNewPlatform(String gameId, PlatformModel platform) throws HttpException {
        GameModel gameFound = this.getOne(gameId);

        PlatformModel platformCreated = this.platformService.save(platform);

        gameFound.getPlatforms().add(platformCreated);

        this.save(gameFound);

        return gameFound;
    }

    public GameModel updatePlatforms(String gameId, List<PlatformModel> platforms) throws HttpException {
        GameModel gameFound = this.getOne(gameId);

        List<PlatformModel> platformsCreated = this.platformService.saveAll(platforms);

        gameFound.setPlatforms(platformsCreated);

        this.save(gameFound);

        return gameFound;
    }

    public GameModel deletePlatform(String gameId, String platformId) throws HttpException {
        GameModel gameFound = this.getOne(gameId);

        List<PlatformModel> filteredPlatforms = gameFound.getPlatforms().stream().filter(platformModel -> !platformModel.getId().equals(platformId)).collect(Collectors.toList());

        gameFound.setPlatforms(filteredPlatforms);

        this.save(gameFound);

        return gameFound;
    }

    public GameModel deletePlatforms(String gameId, List<PlatformModel> platforms) throws HttpException {
        GameModel gameFound = this.getOne(gameId);

        List<PlatformModel> filteredPlatforms = gameFound.getPlatforms().stream()
                .filter(platform -> !platforms.contains(platform)).collect(Collectors.toList());

        gameFound.setPlatforms(filteredPlatforms);

        this.save(gameFound);

        return gameFound;
    }

    public GameModel setMainCharacter(String gameId, MainCharacterModel mainCharacter) throws HttpException {
        GameModel gameFound = this.getOne(gameId);
        MainCharacterModel characterCreated = this.characterService.save(mainCharacter);

        gameFound.setCharacter(characterCreated);

        return this.save(gameFound);
    }
}
