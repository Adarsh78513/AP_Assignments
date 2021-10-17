import java.util.Date;

public class Comment {
    private final java.util.Date date;
    String message;
    User user;


    Comment(User user, String message){
        this.user = user;
        this.message = message;
        this.date = new java.util.Date();
    }

    @Override
    public String toString(){
        return this.message + " - " + user.getName() + "\n" + date;
    }
}
