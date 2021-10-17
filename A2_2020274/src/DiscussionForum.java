import java.util.ArrayList;

public class DiscussionForum {
    static ArrayList<Comment> allComments = new ArrayList<>();

    public static void addComments(User user, String message){
        Comment comment = new Comment(user, message);
        allComments.add(comment);
    }

    public static void viewComments(){
        for ( Comment comment : allComments){
            System.out.println(comment);
        }
    }
}


