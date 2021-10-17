import java.util.Date;

interface LectureMaterial {
    public void add(LectureMaterial material, String topic);
    public String toString();
    public Date getDateOfUpload();
}
