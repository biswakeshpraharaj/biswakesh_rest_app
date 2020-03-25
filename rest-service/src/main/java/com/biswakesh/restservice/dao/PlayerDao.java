package com.biswakesh.restservice.dao;

import com.biswakesh.restservice.dao.common.AbstractJpaDAO;
import com.biswakesh.restservice.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDao extends AbstractJpaDAO<Player> {
    public PlayerDao() {
        super();
        setClazz(Player.class);
    }

    public List<Player> findAllPlayers() {
        return entityManager.createNamedQuery("Player.findAllPlayers")
                .getResultList();
    }
}
