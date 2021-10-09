package Print;

import model.Comment;
import model.Post;
import model.User;

import java.util.List;

public class Print {

    static public void printUserList(List<User> users){

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user.getUsrName());
            //System.out.println(user.getPassword());
            System.out.println(user.getEmailAddress());
            System.out.println(user.getPrivilege());
            System.out.println(user.getRegistrationDate());
            System.out.println(user.getTemplateId());
            System.out.println(user.isLoggedIn());

        }
    }

    static public void  printCommentList(List<Comment> comments){

        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            System.out.println(comment.getComment_id());
            System.out.println(comment.getContent());
            System.out.println(comment.getCreationDate());
            System.out.println(comment.getPostId());
            System.out.println(comment.getUserName());
        }
    }

    static public void  printPostList(List<Post> posts){

        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.println(post.getPostId());
            System.out.println(post.getTitle());
            System.out.println(post.getContent());
            System.out.println(post.getCreationDate());
            System.out.println(post.getUpdateDate());
            System.out.println(post.getUserName());

        }
    }




}
