interface Result {
    boolean Pending();
    public int ID();
    public void complete();
    public void setMarksGot(int marksGot);
    public boolean graded();
}
