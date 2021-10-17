public class InitialiseBackpack {

    public static void initialise(){
        //Making dummy Course
        Course ap = new Course();
        Backpack.allCourses.add(ap);

//        Instructor k1 = new Instructor("k1", 0);
//        Instructor k2 = new Instructor("k2", 1);
//        Instructor k3 = new Instructor("k3", 2);
//        Instructor k4 = new Instructor("k4", 3);
//        Instructor.allInstructors.add(k1);
//        Instructor.allInstructors.add(k2);
//        Instructor.allInstructors.add(k3);
//        Instructor.allInstructors.add(k4);

//        Student s1 = new Student("s1",0 );
//        Student s2 = new Student("s2", 1);
//        Student s3 = new Student("s3", 2);
//        Student s4 = new Student("s4", 4);
//        Student s5 = new Student("s5", 5);
//        Student s6 = new Student("s6", 6);
//        Student s7 = new Student("s7", 7);
//        Student s8 = new Student("s8", 8);
//        Student s9 = new Student("s9", 9);
//        Student s10 = new Student("s10", 10);
//        Student.allStudents.add(s1);
//        Student.allStudents.add(s2);
//        Student.allStudents.add(s3);
//        Student.allStudents.add(s4);
//        Student.allStudents.add(s5);
//        Student.allStudents.add(s6);
//        Student.allStudents.add(s7);
//        Student.allStudents.add(s8);
//        Student.allStudents.add(s9);
//        Student.allStudents.add(s10);

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
