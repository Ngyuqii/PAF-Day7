package paf.sqlmongo.repository;

public class SqlQueries {

	public static final String SQL_SELECTGAMES = """
		SELECT gid, name FROM game LIMIT ? OFFSET ?
		""";

	public static final String SQL_SELECTGAMEBYID = """
		SELECT * FROM game WHERE gid = ?
		""";
	
}
