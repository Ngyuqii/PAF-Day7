package paf.sqlmongo.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.sqlmongo.model.Game;
import static paf.sqlmongo.repositories.SqlQueries.*;

@Repository
public class GameRepository {

    @Autowired
    private JdbcTemplate template;

    //Methods to retrieve all games with limit and offset
    //SQL_SELECTGAMES = "select gid, name from game limit ? offset ?"
	public List<Game> getGames() {
		return getGames(30, 0);
	}
	public List<Game> getGames(int limit, int offset) {

		List<Game> games = new LinkedList<>();

		SqlRowSet rs = template.queryForRowSet(SQL_SELECTGAMES, limit, offset);
		while (rs.next()) {
			games.add(Game.create(rs));
        }

		return games;

	}
    
}