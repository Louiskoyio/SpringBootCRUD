package com.example.team;


import com.example.player.Player;
import com.example.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TeamController {
    @Autowired
    private TeamService service;
    @Autowired
    private PlayerRepository servicePlayer;


    @GetMapping("/teams")
    public String showTeamsList(Model model) {
        List<Team> teamList = service.listAll();
        model.addAttribute("teamList", teamList);

        return "teams";
    }

    @GetMapping("/teams/new")
    public String registerNewTeam(Model model) {
        model.addAttribute("team", new Team());
        model.addAttribute("pageTitle", "Register New team");
        return "register_team";
    }

    @PostMapping("/teams/save")
    public String saveTeam(Team team, RedirectAttributes ra) {
        service.save(team);
        String teamName = team.getTeamName();
        ra.addFlashAttribute("message", teamName + " has been added.");
        return "redirect:/teams";

    }

    @GetMapping("/teams/view/{id}")
    public String viewteam(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) throws TeamNotFoundException {
        Team team = service.get(id);
        List<Player> players = servicePlayer.findByTeamId(id);
        model.addAttribute("team", team);
        model.addAttribute("pageTitle", team.getTeamName());
        model.addAttribute("teamName", team.getTeamName());
        model.addAttribute("players", players);
        return "team";

    }

    @GetMapping("/teams/edit/{id}")
    public String editteam(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Team team = service.get(id);
            model.addAttribute("team", team);
            model.addAttribute("pageTitle", "Edit " + team.getTeamName() + "'s details");
            return "register_team";
        } catch (TeamNotFoundException e) {
            ra.addFlashAttribute("message", "team updated successfully");
            return "redirect:/teams";
        }

    }

    @GetMapping("/teams/delete/{id}")
    public String deleteTeam(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (TeamNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/teams";
    }

}
