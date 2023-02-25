package paf.sqlmongo.repository;

import static paf.sqlmongo.repository.SqlQueries.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.sqlmongo.model.Game;

@Repository
public class GameRepository {

    @Autowired
    private JdbcTemplate template;

    //Methods to retrieve all games with limit and offset
    //SQL_SELECTGAMES = "SELECT gid, name FROM game LIMIT ? OFFSET ?"
	public List<Game> getGames() {
		return getGames(30, 0);
	}
	public List<Game> getGames(int limit, int offset) {

		List<Game> games = new LinkedList<>();

		//SqlRowSet object holds the result from a queryForRowSet()
		SqlRowSet rs = template.queryForRowSet(SQL_SELECTGAMES, limit, offset);
		while (rs.next()) {
			games.add(Game.createGame(rs));
        }

		return games;

	}

	//Method to retrieve game details by game id
	//SQL_SELECTGAMEBYID = "SELECT * FROM game WHERE gid = ?"
	public Optional<Game> getGameByGId(int gameId) {

		SqlRowSet rs = template.queryForRowSet(SQL_SELECTGAMEBYID, gameId);
		if (!rs.next()) {
			return Optional.empty();
		}
		else {
			return Optional.of(Game.createGameDetails(rs));
		}
	}
   
}