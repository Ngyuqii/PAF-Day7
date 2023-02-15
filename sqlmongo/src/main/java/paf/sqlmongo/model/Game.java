package paf.sqlmongo.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {

    private Integer gameId;
    private String name;

    //Getters
    public Integer getGameId() {
        return gameId;
    }
    public String getName() {
        return name;
    }

    //Setters
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static Game create(SqlRowSet rs) {
        Game game = new Game();
        game.setGameId(rs.getInt("gid"));
        game.setName(rs.getString("name"));
        return game;
    }



    

    
}
