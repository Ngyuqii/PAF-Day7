package paf.sqlmongo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.sqlmongo.model.Comment;
import paf.sqlmongo.model.Game;
import paf.sqlmongo.repository.CommentRepository;
import paf.sqlmongo.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    @Autowired
	private CommentRepository commentRepo;

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
    
    //Method to post comment into collection and return comment id
    public String insertComment(Comment comment) {

        //Generate a random 8 char id and set into comment as comment id
		String commentId = UUID.randomUUID().toString().substring(0, 8);
		comment.setCommentId(commentId);
		commentRepo.insertComment(comment);
		return commentId;

	}

}