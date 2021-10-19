public class InitialiseBackpack {

    public static void initialise(){
        //Making dummy Course
        Course ap = new Course();
        Backpack.allCourses.add(ap);

        //making dummy instructors
        for ( int i = 0; i < 4; i++){
            Instructor temp = new Instructor("K" + i, i);
            Instructor.allInstructors.add(temp);
        }

        //making dummy students
        for ( int i = 0; i< 10; i++){
            Student temp = new Student("S" + i, i);
            Student.allStudents.add(temp);
        }

        System.out.println("Welcome to Backpack");
    }
}
