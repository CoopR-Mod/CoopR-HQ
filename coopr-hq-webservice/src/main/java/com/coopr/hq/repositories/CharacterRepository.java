package com.coopr.hq.repositories;

import com.coopr.hq.core.models.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

/***************************************
 * Author: xetra11                     
 * Datum: 12.11.2018                      
 * Funktion/Komponente: -              
 * Beschreibung: -                     
 * API: -                              
 **************************************/

public interface CharacterRepository extends MongoRepository<Character, String> { }
