# Twitter 
Tech stack:Springboot, Mysql

# API:
## USER
  POST: users <br/>
  GET: users <br/>
  PUT: users/{id} <br/>
  DELETE: users/{id} <br/>
## TWEET
  POST: tweets <br/>
  GET(GetAllTeweets): tweets <br/>
  GET: {userId}/{tweetId}/comments <br/>
GET: /{userId}/{tweetId}/likes <br/>
## LIKES
POST(Tweet): tweet/{tweetId} <br/>
POST(Comment): comment/{commentId} <br/>
GET(Tweet): tweet/{tweetId} <br/>
GET(Comment): comment/{commentId} <br/>
## Follow
POST:/{followerId}/follow/{followeeId} <br/>
GET: /follows <br/>


