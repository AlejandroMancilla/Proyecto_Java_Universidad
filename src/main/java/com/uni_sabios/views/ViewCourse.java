package com.uni_sabios.views;

import com.uni_sabios.exceptions.courseexceptions.CourseNullException;
import com.uni_sabios.repository.models.Course;

public class ViewCourse extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    printCourse();
                    break;
                case 3:
                    modifyCourse();
                    break;
                case 4:
                    deleteCourse();
                    break;
                case 5:
                    listCourses();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Not Available Choice");
                    sc.next();
            }
        }while(opc>0);
    }

        private static int showMenu() {
        System.out.println("*".repeat(10) + " Course's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Course");
        System.out.println("\t 2) Get Course by ID");
        System.out.println("\t 3) Edit Course");
        System.out.println("\t 4) Delete Course");
        System.out.println("\t 5) List Courses");
        System.out.println("\t 0) Return to Main Menu");
        System.out.println("*".repeat(35));
        System.out.print("Choose an Option: ");
        return sc.nextInt();
    } 

    private static void createCourse(){
        sc.nextLine();
        System.out.println("Creating new Course...");
        System.out.print("\t Course's Name: ");
        String name = sc.nextLine();
        System.out.print("\t URL Course's guide: ");
        String urlguide = sc.nextLine();
        Course course = new Course(name, urlguide);
        serviceCourse.create(course);
        sc.next();
    }

    private static Course getCourse() {
        sc.nextLine();
        System.out.print("\t Course's ID: ");
        int id = sc.nextInt();
        try {
            return serviceCourse.getCourse(id);
        } catch (CourseNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void printCourse() {
        System.out.println("Searching a Course...");
        sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        try {
            Course course = serviceCourse.getCourse(id);
            System.out.println();
            course.print();
        } catch (CourseNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifyCourse() {
        System.out.println("Modifying a Course...");
        Course course = getCourse();
        if(course != null) {
            int opc = 0;
            System.out.println(" 1) Name");
            System.out.println(" 2) Guide Document");
            opc = sc.nextInt();
            sc.nextLine();
            if(opc == 1){
                System.out.print("\t New Course's Name: ");
                String name = sc.nextLine();
                course.setName(name);
            }else if(opc == 2){
                System.out.print("\t New Course's Name: ");
                String urlguide = sc.nextLine();
                course.setGuideDoc(urlguide);
            }else{
                System.out.println("Incorrect Choose");
            }
            serviceCourse.modify(course);
            System.out.println("Course Modified");
        }
        sc.next(); 
    }

    private static void deleteCourse() {
        Course course = getCourse();
        if(course != null) {
            serviceCourse.delete(course);
            System.out.println("Course deleted sucessfully");
        } else {
            System.out.println("Course not deleted sucessfully");
        }
        sc.next();
    }

    private static void listCourses() {
        clear();
        System.out.println("*".repeat(17) + " COURSE'S LIST" + "*".repeat(17));
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(40)+ "+");
        System.out.printf("|%-5s|%-40s|\n", "ID", "NAME");
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(40)+ "+");
        for(Course course : serviceCourse.list()) {
            course.print();
        }
        sc.next();
    }
    
}
