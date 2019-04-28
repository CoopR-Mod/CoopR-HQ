package com.coopr.hq.security;

import com.coopr.hq.core.models.Player;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/***************************************
 * Author: xetra11                     
 * Datum: 12.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/
@RestController
@Log
public class AuthenticationEndpoint {
  private final String LOGIN = "login";

  private MongoTemplate mongoTemplate;

  @Autowired
  public AuthenticationEndpoint(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @PostMapping(LOGIN)
  public AuthResponse loginUser(@RequestBody UserCredentials userCredentials) {
    String uid = userCredentials.getSteamid();
    String password = userCredentials.getPassword();

    log.info("trying to authenticate for " + uid);
    Query query = new Query().addCriteria(Criteria.where("_id").is(uid));
    Player player = mongoTemplate.findOne(query, Player.class);

    if (player == null) {
      return new AuthResponse(false, "given Steam-ID '" + uid + "' could not be found in database");
    }

    if (player.getPassword().equals(password) == false) {
      return new AuthResponse(false, "given password does not match user");
    }

    return new AuthResponse(true, "login successful");
  }

}
