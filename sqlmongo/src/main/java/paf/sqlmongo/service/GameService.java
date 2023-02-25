package paf.sqlmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.sqlmongo.model.Game;
import paf.sqlmongo.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepo;

     //Methods to retrieve all games with limit and offset
    public List<Game> getGames() {
		return getGames(30, 0);
	}
	public List<Game> getGames(int limit, int offset) {
        return gameRepo.getGames(limit, offset);
    }

    //Method to retrieve game details by game id
    public Optional<Game> getGameByGId(int gameId) {
        return gameRepo.getGameByGId(gameId);
    } 

}
