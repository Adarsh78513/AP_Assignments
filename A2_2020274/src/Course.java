public class Course {
    static int totalQuizzes = 0;
    static int totalAssignments = 0;

    public static int getTotalQuizzes() {
        return totalQuizzes;
    }
    public static void totalQuizzesIncrease() {
        totalQuizzes += 1;
    }
    public static int getTotalAssignments(){
        return totalAssignments;
    }
    public static void totalAssignmentsIncrease() {
        totalAssignments += 1;
    }
}
