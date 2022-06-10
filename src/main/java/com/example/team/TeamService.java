package com.example.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository repository;


    public List<Team> listAll() {
        return (List<Team>) repository.findAll();
    }


    public void save(Team team) {
        repository.save(team);
    }

    public Team get(Integer id) throws TeamNotFoundException {
        Optional<Team> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new TeamNotFoundException("Could not find team with id: " + id);
    }

    public void delete(Integer id) throws TeamNotFoundException {
        Long count = repository.countById(id);
        if (count == null || count == 0) {
            throw new TeamNotFoundException("Couldn't find any teams with ID " + id);
        }
        repository.deleteById(id);
    }
}
