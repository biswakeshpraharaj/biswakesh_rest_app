package com.biswakesh.restservice.controller;

import com.biswakesh.restservice.entity.Player;
import com.biswakesh.restservice.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
//TODO use caching and Meter
public class PlayerResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerResource.class);

    @Autowired
    private PlayerService playerService;

    /**
     * Fetch all books
     * @return List of all books
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/players",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Player>> getAllPlayers() {
        ResponseEntity<List<Player>> responseEntity = null;
        List<Player> players = null;

        try {
            LOGGER.info("REQ: FETCH ALL PLAYERS");
            players = this.playerService.findAllPlayers();
            LOGGER.info("RSP: PLAYERS FETCHED: "+players);
            if(null == players) {
                responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<>(players, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOGGER.error("ERR: WHILE FETCHING ALL PLAYERS: ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    /**
     * Fetch player for the given id
     * @param playerID Id of the player
     * @return Player for the given id
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/players/{playerID}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Player> getBook(@PathVariable(name = "playerID") String playerID) {
        Assert.notNull(playerID,"Path variable playerID cannot be empty");
        ResponseEntity<Player> responseEntity = null;
        Player player = null;

        try {
            LOGGER.info("REQ: FETCH PLAYER WITH ID: "+playerID);
            player = this.playerService.findById(playerID);
            LOGGER.info("RSP: PLAYER FETCHED: "+player);
            if(null == player) {
                responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                responseEntity = new ResponseEntity<>(player, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOGGER.error("ERR: WHILE FETCHING PLAYER WITH ID "+playerID+" :",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    /**
     * Increment height of existing player else return 404
     * @param playerID Id of the player
     * @return Http status
     */
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/players/{playerID}/height"
    )
    public ResponseEntity<Void> updateHeight(@PathVariable(name = "playerID") String playerID) {
        Assert.notNull(playerID,"Path variable playerID cannot be empty");
        ResponseEntity<Void> responseEntity = null;
        Player player = null;
        boolean status = false;
        try {
            LOGGER.info("REQ: UPDATE PLAYER HEIGHT WITH ID: "+playerID);
            player = this.playerService.findById(playerID);
            LOGGER.info("RSP: PLAYER FETCHED: "+player);
            if(null == player) {
                responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
               this.playerService.updateHeightOrWeight(playerID,0);
            }
        } catch (Exception e) {
            LOGGER.error("ERR: WHILE UPDATING PLAYER HEIGHT WITH ID "+playerID+" : ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }

    /**
     * Increment weight of existing player else return 404
     * @param playerID Id of the player
     * @return Http status
     */
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/players/{playerID}/weight"
    )
    public ResponseEntity<Void> updateWeight(@PathVariable(name = "playerID") String playerID) {
        Assert.notNull(playerID,"Path variable playerID cannot be empty");
        ResponseEntity<Void> responseEntity = null;
        Player player = null;
        boolean status = false;
        try {
            LOGGER.info("REQ: UPDATE PLAYER WEIGHT WITH ID: "+playerID);
            player = this.playerService.findById(playerID);
            LOGGER.info("RSP: PLAYER FETCHED: "+player);
            if(null == player) {
                responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                this.playerService.updateHeightOrWeight(playerID,1);
            }
        } catch (Exception e) {
            LOGGER.error("ERR: WHILE UPDATING PLAYER HEIGHT WITH ID "+playerID+" : ",e);
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }
}
