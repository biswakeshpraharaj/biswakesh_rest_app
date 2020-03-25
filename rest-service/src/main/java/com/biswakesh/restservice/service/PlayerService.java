package com.biswakesh.restservice.service;

import com.biswakesh.restservice.entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAllPlayers() throws Exception;

    Player findById(String id) throws Exception;

    void updateHeightOrWeight(String playerID, int heightOrWeight) throws Exception;
}
