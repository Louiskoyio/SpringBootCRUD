package com.example.player;


import com.example.team.Team;
import com.example.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService service;
    @Autowired
    private TeamService serviceTeam;

    @GetMapping("/players")
    public String showPlayersList(Model model) {
        List<Player> playerList = service.listAll();
        List<Team> teamList = serviceTeam.listAll();
        model.addAttribute("playerList", playerList);
        model.addAttribute("teamList", teamList);

        return "players";
    }

    @GetMapping("/players/new")
    public String registerNewPlayer(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("pageTitle", "Register New Player");
        return "register_player";
    }

    @PostMapping("players/save")
    public String savePlayer(Player player, RedirectAttributes ra) {
        service.save(player);
        String playerName = player.getFname() + " " + player.getLname();
        ra.addFlashAttribute("message", playerName + " has been added.");
        return "redirect:/players";

    }

    @GetMapping("/players/view/{id}")
    public String viewPlayer(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) throws PlayerNotFoundException {
        Player player = service.getPlayer(id);
        model.addAttribute("player", player);
        model.addAttribute("pageTitle", player.getFname() + " " + player.getLname());
        model.addAttribute("playerName", player.getFname() + " " + player.getLname());
        return "player";

    }

    @GetMapping("/players/edit/{id}")
    public String editPlayer(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Player player = service.getPlayer(id);
            model.addAttribute("player", player);
            model.addAttribute("pageTitle", "Edit " + player.getFname() + " " + player.getLname() + "'s details");
            return "register_player";
        } catch (PlayerNotFoundException e) {
            ra.addFlashAttribute("message", "player updated successfully");
            return "redirect:/players";
        }

    }

    @GetMapping("/players/delete/{id}")
    public String deletePlayer(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (PlayerNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/players";
    }

}
