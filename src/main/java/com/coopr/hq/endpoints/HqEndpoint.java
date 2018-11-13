package com.coopr.hq.endpoints;

import com.coopr.hq.models.Character;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

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

  private MongoTemplate mongoTemplate;

  @Autowired
  public HqEndpoint(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @PostMapping(value = "/save/characters/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateCharacters(@RequestBody List<Character> characters) {
    characters.forEach(this::updateCharacter);
  }

  @PostMapping(value = "/save/character/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateCharacter(@RequestBody Character character) {
    mongoTemplate.save(character);
    log.info("character with uid " + character.getUid() + " has been saved");
  }

  @GetMapping("/fetch/characters/")
  public List<Character> fetchCharacter() {
    return mongoTemplate.findAll(Character.class);
  }

}
