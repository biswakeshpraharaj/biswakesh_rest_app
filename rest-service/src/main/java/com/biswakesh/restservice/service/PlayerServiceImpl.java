package com.biswakesh.restservice.service;

import com.biswakesh.restservice.dao.PlayerDao;
import com.biswakesh.restservice.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerServiceImpl.class);

    @Autowired
    private PlayerDao playerDao;

    @Override
    public List<Player> findAllPlayers() throws Exception {
        List<Player> players = null;

        try {
            LOGGER.info("FETCH ALL PLAYERS: ");
            players = playerDao.findAllPlayers();
        } catch(Exception e) {
            LOGGER.error("ERR: WHILE FETCHING PLAYERS: ",e);
            throw e;
        }

        return players;
    }

    @Override
    public Player findById(String id) throws Exception {
        Player player = null;

        try {
            LOGGER.info("FETCH FROM DB: "+id);
            player =  playerDao.findOne(id);
        } catch(Exception e) {
            LOGGER.error("ERR: WHILE FETCHING PLAYER WITH ID "+id+" : ",e);
            throw e;
        }

        return player;

    }

    @Override
    @Transactional
    public void updateHeightOrWeight(String playerId,int heightOrWeight) throws Exception {
        Player player = null;

        try {
            player = playerDao.findOne(playerId);
            if(null == player) {
                throw new Exception("PLAYER WITH ID: "+playerId+" NOT FOUND");
            }
            if(0 == heightOrWeight) {
                player.setHeight(player.getHeight()+1);
            } else if(1 == heightOrWeight) {
                player.setWeight(player.getWeight()+1);
            }

            playerDao.update(player);

        } catch (Exception e) {
            LOGGER.error("ERR: WHILE FETCHING PLAYER WITH ID "+playerId+" : ",e);
            throw e;
        }
    }
}
