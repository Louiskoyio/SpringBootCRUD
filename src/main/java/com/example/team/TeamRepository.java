package com.example.team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    Long countById(Integer id);

    /*@Query("SELECT Player.fname, Player.lname,Player.nationalId, Player.phoneNumber, Team.teamName FROM Player JOIN Team on Player.teamId = Team.id where Player.teamId =:id")
    List<Player> players(@Param("id") Integer id);*/
}
