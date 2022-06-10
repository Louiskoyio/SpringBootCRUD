package com.example.fixture;


import com.example.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FixtureController {
    @Autowired
    private FixtureService service;
    @Autowired
    private PlayerRepository servicePlayer;


    @GetMapping("/fixtures")
    public String showfixturesList(Model model) {
        List<Fixture> fixtureList = service.listAll();
        model.addAttribute("fixtureList", fixtureList);

        return "fixtures";
    }

    /*@GetMapping("/fixtures/new")
    public String registerNewfixture(Model model){
        model.addAttribute("fixture",new Fixture());
        return "register_fixture";
    }*/

    /*@PostMapping("fixtures/save")
    public String savefixture(Fixture fixture, RedirectAttributes ra){
        service.save(fixture);
        String fixtureName = fixture.getFixtureName();
        ra.addFlashAttribute("message",fixtureName+" has been added.");
        return "redirect:/fixtures";

    }*/

    /*@GetMapping("/fixtures/view/{id}")
    public String viewfixture(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) throws FixtureNotFoundException {
        Fixture fixture = service.get(id);
        List<Player> players = servicePlayer.findByfixtureId(id);
        model.addAttribute("fixture", fixture);
        model.addAttribute("pageTitle", fixture.getfixtureName());
        model.addAttribute("fixtureName", fixture.getfixtureName());
        model.addAttribute("players", players);
        return "fixture";

    }*/

    /*@GetMapping("/fixtures/edit/{id}")
    public String editfixture(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Fixture fixture = service.get(id);
            model.addAttribute("fixture", fixture);
            model.addAttribute("pageTitle", "Edit " + fixture.ge() +"'s details" );
            return "register_fixture";
        } catch (FixtureNotFoundException e) {
            ra.addFlashAttribute("message", "fixture updated successfully");
            return "redirect:/fixtures";
        }

    }*/

    /*@GetMapping("/fixtures/delete/{id}")
    public String deletefixture(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (FixtureNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/fixtures";
    }*/

}
