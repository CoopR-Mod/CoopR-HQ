package com.coopr.hq.endpoints;

import com.coopr.hq.models.Character;
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
  private final String CHARACTER_LIST = "characters/";
  private final String METHOD_SAVE = "save";
  private final String METHOD_FETCH = "fetch";

  private MongoTemplate mongoTemplate;

  @Autowired
  public HqEndpoint(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @PostMapping(value = API_VERSION + CHARACTER_LIST + METHOD_SAVE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateCharacters(@RequestBody List<Character> characters) {
    characters.forEach(this::updateCharacter);
  }

  @PostMapping(value = API_VERSION + CHARACTER + METHOD_SAVE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateCharacter(@RequestBody Character character) {
    mongoTemplate.save(character);
    log.info("character with uid " + character.getUid() + " has been saved");
  }

  @GetMapping(API_VERSION + CHARACTER_LIST + METHOD_FETCH)
  public List<Character> fetchAllCharaters() {
    return mongoTemplate.findAll(Character.class);
  }

  @GetMapping(API_VERSION + CHARACTER + METHOD_FETCH + "{id}")
  public Character fetchCharacter(@PathVariable("id") String id) {
    return mongoTemplate.findById(id, Character.class);
  }

}
