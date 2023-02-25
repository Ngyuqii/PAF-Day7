package paf.sqlmongo.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {

    private Integer gameId;
    private String name;
    private String url;
    private String image;
    private Integer ranking;
    private Integer year;

    //Getters
    public Integer getGameId() {
        return gameId;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
    public String getImage() {
        return image;
    }
    public Integer getRanking() {
        return ranking;
    }
    public Integer getYear() {
        return year;
    }
    
    //Setters
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    //Create Game object from SqlRowSet object that holds queryForRowSet result
    //1. SELECT only gid and name
    public static Game createGame(SqlRowSet rs) {
        Game game = new Game();
        game.setGameId(rs.getInt("gid"));
        game.setName(rs.getString("name"));
        return game;
    }

    //2. SELECT *
    public static Game createGameDetails(SqlRowSet rs) {
        Game game = new Game();
        game.setGameId(rs.getInt("gid"));
        game.setName(rs.getString("name"));
        game.setUrl(rs.getString("url"));
        game.setImage(rs.getString("image"));
        game.setRanking(rs.getInt("ranking"));
        game.setYear(rs.getInt("year")); 
        return game;
    }
    
}