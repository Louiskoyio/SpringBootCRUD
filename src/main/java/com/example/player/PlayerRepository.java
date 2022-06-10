package com.example.player;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Long countById(Integer id);

    List<Player> findByTeamId(Integer id);
}
