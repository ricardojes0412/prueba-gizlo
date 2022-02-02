package com.gizlo.resource;

import com.gizlo.entity.Person;
import com.gizlo.service.IPersonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonResource {

    Logger logger = LoggerFactory.getLogger(PersonResource.class);

    @Autowired
    private IPersonService _service;

    @PostMapping("savePerson")
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        try {
            logger.info("save person");
            return new ResponseEntity<>(_service.save(person), HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findAllPerson")
    public ResponseEntity<?> findAllPerson() {
        try {
            logger.info("findAll");
            return new ResponseEntity<>(_service.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("updatePerson")
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        try {
            logger.info("update person");
            return new ResponseEntity<>(_service.update(person), HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("flushCache")
    public void flushCache() {
        logger.info("flushCache");
        _service.flushCache();
    }
}
