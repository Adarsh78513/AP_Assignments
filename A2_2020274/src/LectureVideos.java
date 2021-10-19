import java.util.ArrayList;
import java.util.Date;

public class LectureVideos implements LectureMaterial{
    static ArrayList<LectureMaterial> allVideos = new ArrayList<>();
    private String topic;
    private String fileName;
    private final java.util.Date date;
    private final User uploadedBy;


    LectureVideos(User uploadedBy) {
	    this.topic = "Not yet specified";
        this.fileName = "Not available";
        this.date = new java.util.Date();
        this.uploadedBy = uploadedBy;
    }


    public void addTopic(String topic){
        this.topic = topic;
    }

    public void setFileName(LectureMaterial video, String fileName){
        if ( fileName.endsWith(".mp4")){
            this.fileName = fileName;
            allVideos.add(video);
        }
        else{
            System.out.println(fileName + " is not a valid file name.");
            System.out.println("The file should be in .mp4 format");            
        }
    }

    @Override
    public void add(LectureMaterial video, String topic) {
        addTopic(topic);
        allVideos.add(video);

        System.out.print("Enter filename of the video: ");
        String fileName =  Main.scanner.nextLine();
        setFileName(video, fileName);
    }

    public String getTopic(){
        return this.topic;
    }

    public String getFileName(){
        return this.fileName;
    }

    
    @Override
    public Date getDateOfUpload(){
        return this.date;
    }

    private String getInstructor() {
        return this.uploadedBy.getName();
    }

    @Override
    public String toString() {
        return "Title of video: " + getTopic() + "\n" +
                "Video file: " + getFileName() + "\n" +
                "Date of Upload: " + getDateOfUpload() + "\n" +
                "Uploaded by: " + getInstructor();
    }

}
