package paf.sqlmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import paf.sqlmongo.model.Game;
import paf.sqlmongo.services.GameService;

@Controller
@RequestMapping
public class GameController {

    @Autowired
    private GameService gameSvc;

    @GetMapping(path="/")
    public String showGames(@RequestParam(defaultValue = "30") int limit, 
    @RequestParam(defaultValue = "0") int offset, Model model){
        
        List<Game> listOfGames = gameSvc.getGames(limit, offset);
        model.addAttribute("games", listOfGames);
        model.addAttribute("limit", limit);
        model.addAttribute("previous", offset - limit);
        model.addAttribute("next", offset + limit);

        return "index";
    }

}
