package paf.sqlmongo.model;

import org.bson.Document;
import org.springframework.util.MultiValueMap;

import static paf.sqlmongo.model.Constants.*;

public class Comment {
    
    private String commentId;
	private String userName;
	private int rating;
	private String comment;
    private int gameId;
    
    //Getters
    public String getCommentId() {
        return commentId;
    }
    public String getUserName() {
        return userName;
    }
    public int getRating() {
        return rating;
    }
    public String getComment() {
        return comment;
    }
    public int getGameId() {
        return gameId;
    }
    
    //Setters
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    //Create Comment object from form data input into multivaluemap
    public static Comment createComment(MultiValueMap<String, String> form) {
		Comment comment = new Comment();
		comment.setUserName(form.getFirst("userName"));
		comment.setRating(Integer.parseInt(form.getFirst("rating")));
		comment.setComment(form.getFirst("comment"));
        comment.setGameId(Integer.parseInt(form.getFirst("gameId")));
		return comment;
	}

    //Build and return a document object with key-value pairs 
    public Document toDocument() {
		Document doc = new Document();
		doc.put(FIELD_COMMENTID, getCommentId());
		doc.put(FIELD_USERNAME, getUserName());
		doc.put(FIELD_RATING, getRating());
		doc.put(FIELD_COMMENT, getComment());
        doc.put(FIELD_GAMEID, getGameId());
		return doc;    
    }

    @Override
	public String toString() {
		return "Comment[commentId=%s, username=%s, rating=%d, comment=%s, gameId=%]"
			.formatted(commentId, userName, rating, comment, gameId);
	}

}