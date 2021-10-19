public class InitialiseBackpack {

    public static void initialise(){
        //Making dummy Course
        Course ap = new Course();
        Backpack.allCourses.add(ap);

        //making dummy instructors
        for ( int i = 0; i < 4; i++){
            Instructor temp = new Instructor("Instructor_" + i, i);
            Instructor.allInstructors.add(temp);
        }

        //making dummy students
        for ( int i = 0; i< 10; i++){
            Student temp = new Student("Student_" + i, i);
            Student.allStudents.add(temp);
        }

        System.out.println("Welcome to Backpack");
    }
}
