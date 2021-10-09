package model;

/*
	post_id INT UNSIGNED AUTO_INCREMENT,
    user_name VARCHAR(50),
    title  VARCHAR(50),
    content  VARCHAR(5000),
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (post_id),
    FOREIGN KEY(user_name) REFERENCES users(user_name)
 */

public class Post {

    int postId;
    String userName;
    String title;
    String content;
    String creationDate;
    String updateDate;

    public Post(int postId, String userName, String title, String content, String creationDate, String updateDate) {
        this.postId = postId;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Post(int postId, String userName, String title, String content) {
        this.postId = postId;
        this.userName = userName;
        this.title = title;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public String getUserName() {
        return userName;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
