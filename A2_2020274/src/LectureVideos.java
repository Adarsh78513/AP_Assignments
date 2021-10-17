public class LectureVideos implements LectureMaterial{
    String topic;
    String fileName;

    LectureVideos() {
	    this.topic = "Not yet specified";
        this.fileName = "Not available";
    }

    public void fileName(String fileName){
        if ( fileName.endsWith(".mp4")){
            this.fileName = fileName;
        }
        else{
            System.out.println("The video format is not acceptable.");
        }
    }

    public void addTopic(String topic){
        this.topic = topic;
    }

    public void setFileName(String fileName){
        if ( fileName.endsWith(".mp4")){
            this.fileName = fileName;
        }
        else{
            System.out.println(fileName + " is not a valid file name.");
            System.out.println("The file should be in .mp4 format");            
        }
    }

    @Override
    public void add(String topic) {
        addTopic(topic);
        System.out.print("Enter filename of the video: ");
        String fileName =  Main.scanner.next();
        setFileName(fileName);
    }
}
