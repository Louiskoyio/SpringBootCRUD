package com.example.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixtureService {
    @Autowired
    private FixtureRepository repository;


    public List<Fixture> listAll() {
        return (List<Fixture>) repository.findAll();
    }


    public void save(Fixture Fixture) {
        repository.save(Fixture);
    }

    public Fixture get(Integer id) throws FixtureNotFoundException {
        Optional<Fixture> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new FixtureNotFoundException("Could not find Fixture with id: " + id);
    }

    public void delete(Integer id) throws FixtureNotFoundException {
        Long count = repository.countById(id);
        if (count == null || count == 0) {
            throw new FixtureNotFoundException("Couldn't find any Fixtures with ID " + id);
        }
        repository.deleteById(id);
    }
}
