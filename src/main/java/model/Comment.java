package model;
/*
	comment_id INT UNSIGNED AUTO_INCREMENT,
    content  VARCHAR(200),
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_name VARCHAR(50),
    post_id INT UNSIGNED,
	PRIMARY KEY (comment_id),
    FOREIGN KEY(user_name) REFERENCES users(user_name),
    FOREIGN KEY(post_id) REFERENCES posts(post_id)
 */
public class Comment {
    int comment_id;
    String content;
    String creationDate;
    String userName;
    int postId;

    public Comment(int comment_id, String content, String creationDate, String userName, int postId) {
        this.comment_id = comment_id;
        this.content = content;
        this.creationDate = creationDate;
        this.userName = userName;
        this.postId = postId;
    }

    public Comment(int comment_id, String content, String userName, int postId) {
        this.comment_id = comment_id;
        this.content = content;
        this.userName = userName;
        this.postId = postId;
    }

    public int getComment_id() {
        return comment_id;
    }

    public String getContent() {
        return content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getUserName() {
        return userName;
    }

    public int getPostId() {
        return postId;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
