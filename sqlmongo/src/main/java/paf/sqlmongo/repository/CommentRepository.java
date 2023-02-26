package paf.sqlmongo.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import paf.sqlmongo.model.Comment;

import static paf.sqlmongo.model.Constants.*;

@Repository
public class CommentRepository {

	@Autowired
	private MongoTemplate template;

	//Method to insert document into collection
	//db.tv_shows.insert({Document})
	public void insertComment(Comment comment) {
		Document doc = comment.toDocument();
		template.insert(doc, COLLECTION);
	}

}