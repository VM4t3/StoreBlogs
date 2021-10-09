package application;

import Print.Print;
import database.DBEngine;
import model.User;

public class Main {

    public static void main(String[] args) {
        DBEngine engine = new DBEngine();
        System.out.println(engine.isConnected());
 /*       //engine.createAccount("mtae","aaa","admin","a@gmail.com");
        System.out.println(engine.isloggedIn("mtae"));
        engine.logOut("mtae");
        System.out.println(engine.isloggedIn("mtae"));
        engine.logIn("mtae","aaa");
        System.out.println(engine.isloggedIn("mtae"));
        System.out.println("pass");
        System.out.println(engine.isPasswordEquals("mtae", "aaa"));
        engine.changePassword("mtae","aaa","bbb");*/
       // engine.savePost("mtae","postcím1","posttartalom1");
       // engine.saveComment("mtae","nagyon király",1);
        //engine.getPostsByUserName("mtae");
        //engine.getCommentsByUserName("mtae");
        // engine.getAllUsers();
        Print.printUserList(engine.getAllUsers());
        User vincseszter = new User("Vincs Eszter");
        //Print.printCommentList(engine.getCommentsByUserName(vincseszter));
        //Print.printCommentList(engine.getCommentsByPostId(2));
        Print.printPostList(engine.getPostsByUserName(vincseszter));
       // engine.getAllUsers();

    }

}
