package com.coopr.hq.endpoints;

import com.coopr.hq.core.models.Character;
import com.coopr.hq.core.models.Player;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***************************************
 * Author: xetra11                     
 * Datum: 12.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/
@RestController
@Log
public class HqEndpoint {
  private final String API_VERSION = "/api/v0.1/";
  private final String CHARACTER = "character/";
  private final String PLAYER = "player/";
  private final String CHARACTER_LIST = "characters/";
  private final String METHOD_SAVE = "save";
  private final String METHOD_FETCH = "fetch";

  private MongoTemplate mongoTemplate;

  @Autowired
  public HqEndpoint(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  //Posts
  @PostMapping(value = API_VERSION + CHARACTER_LIST + METHOD_SAVE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateCharacters(@RequestBody List<Character> characters) {
    characters.forEach(this::updateCharacter);
  }

  @PostMapping(value = API_VERSION + CHARACTER + METHOD_SAVE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateCharacter(@RequestBody Character character) {
    mongoTemplate.save(character);
    log.info("character with uid " + character.getUid() + " has been saved");
  }

  @PostMapping(value = API_VERSION + PLAYER + METHOD_SAVE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updatePlayer(@RequestBody Player player) {
    mongoTemplate.save(player);
  }

  //Queries
  @CrossOrigin
  @GetMapping(API_VERSION + CHARACTER_LIST + METHOD_FETCH)
  public List<Character> fetchAllCharacters() {
    return mongoTemplate.findAll(Character.class);
  }

  @CrossOrigin
  @GetMapping(API_VERSION + CHARACTER + METHOD_FETCH + "/{characterId}")
  public Character fetchCharacter(@PathVariable("characterId") String characterId) {
    return mongoTemplate.findById(characterId, Character.class);
  }

}
