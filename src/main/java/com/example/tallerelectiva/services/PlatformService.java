package com.example.tallerelectiva.services;

import com.example.tallerelectiva.exeptions.HttpException;
import com.example.tallerelectiva.models.DeveloperModel;
import com.example.tallerelectiva.models.GameModel;
import com.example.tallerelectiva.models.PlatformModel;
import com.example.tallerelectiva.repositories.PlatformRepository;
import com.example.tallerelectiva.services.internal.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatformService extends CrudService<PlatformModel> {

    private final GameService gameService;

    @Autowired
    public PlatformService(PlatformRepository repository, GameService gameService) {
        super(repository);
        this.gameService = gameService;
    }

    public PlatformModel addGame(String platformId, GameModel game) throws HttpException {
        PlatformModel platformFound = this.getOne(platformId);
        GameModel gameCreated = this.gameService.save(game);

        platformFound.getGames().add(gameCreated);

        return this.save(platformFound);
    }

    public PlatformModel addGames(String platformId, List<GameModel> games) throws HttpException {
        PlatformModel platformFound = this.getOne(platformId);
        List<GameModel> gameCreated = this.gameService.saveAll(games);

        platformFound.getGames().addAll(gameCreated);

        return this.save(platformFound);
    }

    public PlatformModel removeGame(String platformId, String gameId) throws HttpException {
        PlatformModel platformFound = this.getOne(platformId);

        List<GameModel> gamesFilter = platformFound.getGames().stream().filter(gameModel -> !gameModel.getId().equals(gameId)).collect(Collectors.toList());

        platformFound.setGames(gamesFilter);

        return this.save(platformFound);
    }
}
