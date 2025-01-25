#Twitter 
Tech stack:Springboot, Mysql

API:
USER
POST:http://localhost:8080/users
GET:http://localhost:8080/users
PUT:http://localhost:8080/users/{id}
DELETE:http://localhost:8080/users/{id}
TWEET
POST:http://localhost:8080/tweets
GET(GetAllTeweets):http://localhost:8080/tweets
GET:http://localhost:8080/{userId}/{tweetId}/comments
GET:http://localhost:8080//{userId}/{tweetId}/likes
LIKES
POST(Tweet):http://localhost:8080/tweet/{tweetId}
POST(Comment):http://localhost:8080/comment/{commentId}
GET(Tweet):http://localhost:8080/tweet/{tweetId}
GET(Comment):http://localhost:8080/comment/{commentId}
