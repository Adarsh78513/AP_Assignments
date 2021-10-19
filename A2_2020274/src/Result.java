interface Result {
    boolean Pending();
    public int ID();
    public void complete();
    public void setMarksGot(int marksGot, User instructor);
    public int getMarksGot();
    public boolean graded();
    public String submittedFileName();
    public String gradedBy();

    String getAnswer();

    boolean closed();
}
