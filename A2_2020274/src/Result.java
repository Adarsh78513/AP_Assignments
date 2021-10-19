interface Result {
    boolean Pending();
    int ID();
    void complete();
    void setMarksGot(int marksGot, User instructor);
    int getMarksGot();
    boolean graded();
    String submittedFileName();
    String gradedBy();

    String getAnswer();

    boolean closed();
}
