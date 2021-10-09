package database;

import model.Comment;
import model.Post;
import model.Privilege;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBEngine {

    private Connection connection;

    public DBEngine() {
        connection = connect();
    }

    public boolean isConnected() {
        return (connection != null);
    }

    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/blogDB" +
                "?" +
                "useUnicode=yes" +
                "&" +
                "characterEncoding=UTF-8";
        Properties properties = new Properties();
        properties.put("user", System.getenv("DB_USER"));
        properties.put("password", System.getenv("DB_PASSWORD"));
        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

 /*   public void createAccount(String userName, String password, String privilege, String emailAddress) {

        try {
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate("INSERT INTO users" +
                    "(user_name, psw, logged_in, privilege, email_address,template_id) " +
                    "VALUES ('" + userName + "','" + password + "',true ,'user','" + emailAddress + "',1);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

        public void createAccount(User newUser) {

        try {
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate("INSERT INTO users" +
                    "(user_name, psw, logged_in, privilege, email_address,template_id) " +
                    "VALUES ('" + newUser.getUsrName() + "','" + newUser.getPassword() + "',true ,'user','" + newUser.getEmailAddress() + "',1);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean isloggedIn(User user) {
        String query = "SELECT user_name,logged_in FROM users where user_name = '" + user.getUsrName() + "';";
        boolean isloggedIn = false;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                //resultSet.getLong(1); nem biztonságos
                isloggedIn = resultSet.getBoolean("logged_in");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isloggedIn;
    }

    public boolean isloggedIn(String user) {
        String query = "SELECT user_name,logged_in FROM users where user_name = '" + user + "';";
        boolean isloggedIn = false;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                //resultSet.getLong(1); nem biztonságos
                isloggedIn = resultSet.getBoolean("logged_in");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isloggedIn;
    }


    public void logOut(User user) {

        try {
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate("update users set logged_in = false where user_name = '" + user.getUsrName() + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void logIn(User user) {
        if (isPasswordEquals(user.getUsrName(),user.getPassword())) {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("update users set logged_in = true where user_name = '"+ user.getUsrName() +"' ;");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isPasswordEquals(String username,String password) {
        String query = "SELECT user_name,psw FROM users where user_name = '" + username + "';";
        boolean isEquals = false;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                //resultSet.getLong(1); nem biztonságos
                String storedPassword = resultSet.getString("psw");
                if (storedPassword.equals(password)) {
                    isEquals = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isEquals;
    }
/*
    public void changePassword(String userName, String oldPassword, String newPassword) {
        if (isPasswordEquals(userName, oldPassword)) {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("update users set psw ='" + newPassword + "' where user_name = '" + userName + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
*/
    public void changeTemplate(User user, int templateID) {
        if (isloggedIn(user)) {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("update users set template_id ='" + templateID + "' where user_name = " + user.getUsrName() + ";");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
/*
    public void changeEmailAddress(String userName, String password, String newEmailAddress) {
        if (isPasswordEquals(userName, password)) {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("update users set email_address ='" + newEmailAddress + "' where user_name = '" + userName + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
  */
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
/*
    public void savePost(User user, String title, String content) {
        if (isloggedIn(user)) {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("INSERT INTO posts" +
                        "(user_name, title , content) " +
                        "VALUES ('" + user.getUsrName() + "','" + title + "','" + content + "');");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
*/

    public void savePost(Post post) {
        if (isloggedIn(post.getUserName())) {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("INSERT INTO posts" +
                        "(user_name, title , content) " +
                        "VALUES ('" + post.getUserName() + "','" + post.getTitle() + "','" + post.getContent() + "');");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public List<Post> getPostsByUserName(User user){
        String query = "SELECT * FROM posts where user_name = '" + user.getUsrName() + "';";
        List<Post> postByUser = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int postID = resultSet.getInt("post_id");
                String userName = resultSet.getString("user_name");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String creationDate = resultSet.getString("creation_date");
                String update = resultSet.getString("update_date");
                Post post = new Post(postID,userName,title,content,creationDate,update);
                postByUser.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postByUser;
    }
/*
    public void saveComment(User user, String content, int postId) {
        if (isloggedIn(user)) {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("INSERT INTO comments" +
                        "(content, user_name , post_id) " +
                        "VALUES ('" + content + "','" + user.getUsrName() + "','" + postId + "');");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
*/

    public void saveComment(Comment comment) {
        if (isloggedIn(comment.getUserName())) {
            try {
                Statement statement = connection.createStatement();
                int resultSet = statement.executeUpdate("INSERT INTO comments" +
                        "(content, user_name , post_id) " +
                        "VALUES ('" + comment.getContent() + "','" + comment.getUserName() + "','" + comment.getPostId() + "');");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public List<Comment> getCommentsByUserName(User user){
        String query = "SELECT * FROM comments where user_name = '" + user.getUsrName() + "';";
        List<Comment> commentsByUser = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int commentID = resultSet.getInt("comment_id");
                String content = resultSet.getString("content");
                String creationDate = resultSet.getString("creation_date");
                String userName = resultSet.getString("user_name");
                int postId = resultSet.getInt("post_id");
                Comment comment = new Comment(commentID,content,creationDate,userName,postId);
                commentsByUser.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentsByUser;
    }

    public List<Comment> getCommentsByPostId(int postId){
        String query = "SELECT * FROM comments where post_id = '" + postId + "';";
        List<Comment> commentsByPostId = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int commentID = resultSet.getInt("comment_id");
                String content = resultSet.getString("content");
                String creationDate = resultSet.getString("creation_date");
                String userName = resultSet.getString("user_name");
                //int postId = resultSet.getInt("post_id");
                Comment comment = new Comment(commentID,content,creationDate,userName,postId);
                commentsByPostId.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentsByPostId;
    }

    public List<User> getAllUsers(){
        String query = "SELECT * FROM users;";
        List<User> allUser = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                String UserName =  resultSet.getString("user_name");
                String password = resultSet.getString("psw");
                boolean loggedIn = resultSet.getBoolean("logged_in");
                String privilege = resultSet.getString("privilege");
                String emailAddress = resultSet.getString("email_address");
                String registrationDate = resultSet.getString("reg_date");
                int templateId = resultSet.getInt("template_id");

                User user = new User(UserName,password,loggedIn, Privilege.getPrivilegeByType(privilege),emailAddress,registrationDate,templateId);
                allUser.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
            return allUser;
    }


}



