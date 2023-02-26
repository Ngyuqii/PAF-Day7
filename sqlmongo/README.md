### Query a relational database (MySQL)
- Import data (File: bgg.sql) into a new MySQL database - database bgg, table game.
- List out all games on index page with pagination. Limit and offset set to default 30 and 0 respectively.
- Hyperlink of games display the following (GET /game/{gameId}):
    1. Game name (year)
    2. Game URL
    3. Game image
    4. Game ranking
    5. Input fields for user to leave comments (user name, rating and comment)

### Query and Post to a document database (MongoDB)
- Import data (Files: game.json and comment.json) into a new MongoDB database - database bgg, collections game and comment.
- Posting of user comments inserts comment document into comment collection in mongodb (POST /game/comment). Document includes the followinng:
    1. Primary Key _id" : ObjectId
    2. Randomly generated user id
    3. User name
    4. User rating
    5. User comment
- Retrieve all comments (user, rating and comment) for the game (GET /game/comment/{gameId})