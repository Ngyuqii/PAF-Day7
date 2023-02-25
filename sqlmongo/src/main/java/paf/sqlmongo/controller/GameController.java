package paf.sqlmongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import paf.sqlmongo.model.Game;
import paf.sqlmongo.service.GameService;

@Controller
@RequestMapping(path="/")
public class GameController {

    @Autowired
    private GameService gameSvc;

    //Get all games with limit and offset
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

    //Retrieve game details by game id
    @GetMapping(path="/game/{gameId}")
    public String getGameByGId(@PathVariable int gameId, Model model) {
        
        Optional<Game> game = gameSvc.getGameByGId(gameId);

        if (game.isEmpty()){
            model.addAttribute("gameId", gameId);
            return "gamenotfound";
        }
        else {
            model.addAttribute("gameId", gameId);
            model.addAttribute("game", game.get());
            return "game";
        }
    }

}