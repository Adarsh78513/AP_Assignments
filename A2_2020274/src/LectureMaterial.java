import java.util.Date;

interface LectureMaterial {
    void add(LectureMaterial material, String topic);
    Date getDateOfUpload();
}
