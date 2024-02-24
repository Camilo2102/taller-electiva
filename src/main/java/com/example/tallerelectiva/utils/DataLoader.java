package com.example.tallerelectiva.utils;

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
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {
    private final CrudService<GameModel> gameService;
    private final CrudService<PlatformModel> platformService;
    private final CrudService<DeveloperModel> developerService;

    private List<DeveloperModel> developers;
    private List<PlatformModel> platforms;

    public DataLoader(GameRepository gameRepository, PlatformRepository platformRepository, DeveloperRepository developerRepository) {
        this.gameService = new CrudService<>(gameRepository);
        this.platformService = new CrudService<>(platformRepository);
        this.developerService = new CrudService<>(developerRepository);
    }


    @Override
    public void run(String... args) {
        log.info("Initializing");
        try {
            if(this.gameService.count() != 0) {
                log.info("Initialize ended");
                return;
            }

            this.developers = this.developerService.saveAll(getDeveloperList());
            this.platforms = this.platformService.saveAll(getPlatformList());
            this.gameService.saveAll(getGameList());
            log.info("Initialize ended");
        } catch (HttpException e) {
            log.error("Initialize failed");
            throw new RuntimeException(e);
        }
    }

    private DeveloperModel getDeveloperByName(String name){
        return this.developers.stream().filter(developerModel -> developerModel.getName().equals(name)).findFirst().orElse(null);
    }

    private List<PlatformModel> getPlatformsByName(String... names) {
        return platforms.stream().filter(platform -> Arrays.asList(names).contains(platform.getName())).toList();
    }

    private List<DeveloperModel> getDeveloperList() {
        return Arrays.asList(
                DeveloperModel.builder()
                        .name("Bethesda Softworks")
                        .country("USA")
                        .yearFounded(1986)
                        .website("https://bethesda.net")
                        .build(),
                DeveloperModel.builder()
                        .name("Ubisoft")
                        .country("France")
                        .yearFounded(1986)
                        .website("https://www.ubisoft.com/")
                        .build(),
                DeveloperModel.builder()
                        .name("Rockstar Games")
                        .country("USA")
                        .yearFounded(1998)
                        .website("https://www.rockstargames.com/")
                        .build(),
                DeveloperModel.builder()
                        .name("CD Projekt Red")
                        .country("Poland")
                        .yearFounded(1994)
                        .website("https://en.cdprojektred.com/")
                        .build(),
                DeveloperModel.builder()
                        .name("Naughty Dog")
                        .country("USA")
                        .yearFounded(1984)
                        .website("https://www.naughtydog.com/")
                        .build(),
                DeveloperModel.builder()
                        .name("Square Enix")
                        .country("Japan")
                        .yearFounded(1986)
                        .website("https://www.square-enix.com/")
                        .build(),
                DeveloperModel.builder()
                        .name("Nintendo")
                        .country("Japan")
                        .yearFounded(1889)
                        .website("https://www.nintendo.com/")
                        .build(),
                DeveloperModel.builder()
                        .name("Blizzard Entertainment")
                        .country("USA")
                        .yearFounded(1991)
                        .website("https://www.blizzard.com/")
                        .build(),
                DeveloperModel.builder()
                        .name("Valve Corporation")
                        .country("USA")
                        .yearFounded(1996)
                        .website("https://www.valvesoftware.com/")
                        .build(),
                DeveloperModel.builder()
                        .name("Electronic Arts")
                        .country("USA")
                        .yearFounded(1982)
                        .website("https://www.ea.com/")
                        .build(),
                DeveloperModel.builder()
                        .name("Mojang Studios")
                        .country("Sweden")
                        .yearFounded(2009)
                        .website("https://www.mojang.com/")
                        .build(),

                DeveloperModel.builder()
                        .name("Epic Games")
                        .country("USA")
                        .yearFounded(1991)
                        .website("https://www.epicgames.com/")
                        .build(),

                DeveloperModel.builder()
                        .name("Game Freak")
                        .country("Japan")
                        .yearFounded(1989)
                        .website("https://www.gamefreak.co.jp/")
                        .build(),

                DeveloperModel.builder()
                        .name("Infinity Ward")
                        .country("USA")
                        .yearFounded(2002)
                        .website("https://www.infinityward.com/")
                        .build()
        );
    }

    private List<PlatformModel> getPlatformList() {
        return Arrays.asList(PlatformModel.builder()
                        .name("PlayStation 5")
                        .manufacturer("Sony Interactive Entertainment")
                        .releaseYear("2020")
                        .build(),
                PlatformModel.builder()
                        .name("Xbox Series X")
                        .manufacturer("Microsoft Corporation")
                        .releaseYear("2020")
                        .build(),
                PlatformModel.builder()
                        .name("Nintendo Switch")
                        .manufacturer("Nintendo")
                        .releaseYear("2017")
                        .build(),
                PlatformModel.builder()
                        .name("PC")
                        .manufacturer("Various")
                        .releaseYear("N/A")
                        .build(),
                PlatformModel.builder()
                        .name("PlayStation 4")
                        .manufacturer("Sony Interactive Entertainment")
                        .releaseYear("2013")
                        .build(),
                PlatformModel.builder()
                        .name("Xbox One")
                        .manufacturer("Microsoft Corporation")
                        .releaseYear("2013")
                        .build(),
                PlatformModel.builder()
                        .name("Nintendo 3DS")
                        .manufacturer("Nintendo")
                        .releaseYear("2011")
                        .build(),
                PlatformModel.builder()
                        .name("PlayStation 3")
                        .manufacturer("Sony Interactive Entertainment")
                        .releaseYear("2006")
                        .build(),
                PlatformModel.builder()
                        .name("Xbox 360")
                        .manufacturer("Microsoft Corporation")
                        .releaseYear("2005")
                        .build(),
                PlatformModel.builder()
                        .name("Nintendo DS")
                        .manufacturer("Nintendo")
                        .releaseYear("2004")
                        .build());
    }

    private List<GameModel> getGameList(){
        return Arrays.asList(
                GameModel.builder()
                        .title("The Elder Scrolls V: Skyrim")
                        .description("Open-world action RPG")
                        .price(new BigDecimal("29.99"))
                        .releaseYear(2011)
                        .character(new MainCharacterModel("Dovahkiin", "Dragonborn", "The protagonist of Skyrim is a Dragonborn, a mortal with the soul of a dragon."))
                        .developer(getDeveloperByName("Bethesda Softworks"))
                        .platforms(getPlatformsByName("PC", "Xbox 360"))
                        .build(),
                GameModel.builder()
                        .title("The Legend of Zelda: Breath of the Wild")
                        .description("Action-adventure game")
                        .price(new BigDecimal("59.99"))
                        .releaseYear(2017)
                        .character(new MainCharacterModel("Link", "Hero of Hyrule", "Link is the main protagonist of the game, who awakens from a long slumber to defeat Calamity Ganon."))
                        .developer(getDeveloperByName("Nintendo"))
                        .platforms(getPlatformsByName("Nintendo Switch"))
                        .build(),
                GameModel.builder()
                        .title("Grand Theft Auto V")
                        .description("Action-adventure game")
                        .price(new BigDecimal("29.99"))
                        .releaseYear(2013)
                        .character(new MainCharacterModel("Michael De Santa", "Retired Bank Robber", "Michael De Santa is one of the three playable protagonists in GTA V, he is a retired bank robber who lives under the protection of the FIB witness protection program."))
                        .developer(getDeveloperByName("Rockstar Games"))
                        .platforms(getPlatformsByName("PlayStation 4", "Xbox One"))
                        .build(),
                GameModel.builder()
                        .title("Red Dead Redemption 2")
                        .description("Action-adventure game")
                        .price(new BigDecimal("39.99"))
                        .releaseYear(2018)
                        .character(new MainCharacterModel("Arthur Morgan", "Outlaw", "Arthur Morgan is the central character and main protagonist of Red Dead Redemption 2, he is an outlaw and a member of the Van der Linde gang."))
                        .developer(getDeveloperByName("Rockstar Games"))
                        .platforms(getPlatformsByName("PlayStation 4", "Xbox One"))
                        .build(),
                GameModel.builder()
                        .title("Super Mario Odyssey")
                        .description("Platformer")
                        .price(new BigDecimal("49.99"))
                        .releaseYear(2017)
                        .character(new MainCharacterModel("Mario", "Plumber", "Mario is a plumber and the main character of the Mario series, known for his adventures in the Mushroom Kingdom."))
                        .developer(getDeveloperByName("Nintendo"))
                        .platforms(getPlatformsByName("Nintendo Switch"))
                        .build(),
                GameModel.builder()
                        .title("The Witcher 3: Wild Hunt")
                        .description("Open-world action RPG")
                        .price(new BigDecimal("39.99"))
                        .releaseYear(2015)
                        .character(new MainCharacterModel("Geralt of Rivia", "Witcher", "Geralt of Rivia is a witcher, a monster hunter for hire, and the main protagonist of The Witcher 3: Wild Hunt."))
                        .developer(getDeveloperByName("CD Projekt Red"))
                        .platforms(getPlatformsByName("PlayStation 4", "PC", "Xbox One"))
                        .build(),
                GameModel.builder()
                        .title("Minecraft")
                        .description("Sandbox game")
                        .price(new BigDecimal("19.99"))
                        .releaseYear(2011)
                        .character(new MainCharacterModel("Steve", "Blocky Adventurer", "Steve is the default player character in Minecraft, known for his adventures in the blocky world."))
                        .developer(getDeveloperByName("Mojang Studios"))
                        .platforms(getPlatformsByName("PC", "PlayStation 4", "Xbox One", "Nintendo Switch"))
                        .build(),
                GameModel.builder()
                        .title("Fortnite")
                        .description("Battle Royale game")
                        .price(BigDecimal.ZERO)
                        .releaseYear(2017)
                        .character(new MainCharacterModel("Unknown", "N/A", "The protagonist of Fortnite is not explicitly named or characterized in-game."))
                        .developer(getDeveloperByName("Epic Games"))
                        .platforms(getPlatformsByName("PC", "PlayStation 4", "Xbox One", "Nintendo Switch"))
                        .build(),
                GameModel.builder()
                        .title("Pokémon Sword and Shield")
                        .description("Role-playing game")
                        .price(new BigDecimal("59.99"))
                        .releaseYear(2019)
                        .character(new MainCharacterModel("Unnamed Pokémon Trainer", "Pokémon Trainer", "The player character in Pokémon Sword and Shield, whose name and appearance are chosen by the player."))
                        .developer(getDeveloperByName("Game Freak"))
                        .platforms(getPlatformsByName("Nintendo Switch"))
                        .build(),
                GameModel.builder()
                        .title("Call of Duty: Modern Warfare")
                        .description("First-person shooter")
                        .price(new BigDecimal("59.99"))
                        .releaseYear(2019)
                        .character(new MainCharacterModel("Unnamed Soldier", "Soldier", "The player character in Call of Duty: Modern Warfare, representing various soldiers in the game's campaign."))
                        .developer(getDeveloperByName("Infinity Ward"))
                        .platforms(getPlatformsByName("PC", "PlayStation 4", "Xbox One"))
                        .build()
        );
    }
}
