package com.example.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;


    public List<Player> listAll() {
        return (List<Player>) playerRepository.findAll();
    }

    public void save(Player player) {
        playerRepository.save(player);
    }

    public Player getPlayer(Integer id) throws PlayerNotFoundException {
        Optional<Player> result = playerRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new PlayerNotFoundException("Could not find player with id: " + id);
    }

    public void delete(Integer id) throws PlayerNotFoundException {
        Long count = playerRepository.countById(id);
        if (count == null || count == 0) {
            throw new PlayerNotFoundException("Couldn't find any players with ID " + id);
        }
        playerRepository.deleteById(id);
    }
}
