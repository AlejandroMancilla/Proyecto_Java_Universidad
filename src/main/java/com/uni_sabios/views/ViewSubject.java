package com.uni_sabios.views;

import com.uni_sabios.exceptions.courseexceptions.CourseNullException;
import com.uni_sabios.exceptions.subjectexceptions.SubjectNullException;
import com.uni_sabios.repository.models.Subject;

public class ViewSubject extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    createSubject();
                    break;
                case 2:
                    printSubject();
                    break;
                case 3:
                    modifySubject();
                    break;
                case 4:
                    deleteSubject();
                    break;
                case 5:
                    listSubjects();
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
        System.out.println("*".repeat(10) + " Student's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Subject");
        System.out.println("\t 2) Get Subject by ID");
        System.out.println("\t 3) Edit Subject");
        System.out.println("\t 4) Delete Subject");
        System.out.println("\t 5) List Subjects");
        System.out.println("\t 0) Return to Main Menu");
        System.out.println("*".repeat(35));
        System.out.print("Choose an Option: ");
        return sc.nextInt();
    } 

    private static void createSubject() {
        sc.nextLine();
        System.out.println("Creating new Subject...");
        System.out.print("\t Course ID: ");
        int course = sc.nextInt();
        System.out.print("\t Period ID: ");
        int period = sc.nextInt();
        System.out.print("\t Teacher ID: ");
        int teacher = sc.nextInt();
        System.out.print("\t Num Credits: ");
        int credits = sc.nextInt();
        System.out.print("\t Capacity: ");
        int capacity = sc.nextInt();
        System.out.print("\t Duration: ");
        int duration = sc.nextInt();
        String name = "";
        try {
            name = "C" + course + "-PER" + period + "-" + serviceCourse.getCourse(course).getName();
        } catch (CourseNullException e) {
            e.printStackTrace();
        }
        Subject subject = new Subject(credits, capacity, duration, name, teacher, course, period);
        serviceSubject.create(subject);
        sc.next();
    }

    private static Subject getSubject() {
        sc.nextLine();
        System.out.print("\t Subject's ID: ");
        int id = sc.nextInt();
        try {
            return serviceSubject.getSubject(id);
        } catch (SubjectNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void printSubject() {
        System.out.println("Searching a Subject...");
        sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        try {
            Subject subject = serviceSubject.getSubject(id);
            System.out.println();
            subject.print();
        } catch (SubjectNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifySubject() {
        System.out.println("Modifying a Fare...");
        Subject subject = getSubject();
        if(subject != null) {
            int opc = 0;
            System.out.println(" 1) Period ID");
            System.out.println(" 2) Teacher ID");
            System.out.println(" 3) Course ID");
            System.out.println(" 4) Credits");
            System.out.println(" 5) Capacity");
            opc = sc.nextInt();
            sc.nextLine();
            switch(opc){
                case 1:
                    System.out.print("\t Period ID: ");
                    int period = sc.nextInt();
                    subject.setPeriodId(period);
                    break;
                case 2:
                    System.out.print("\t Teacher ID: ");
                    int teacher = sc.nextInt();
                    subject.setTeacherId(teacher);
                    break;
                case 3:
                    System.out.print("\t Course ID: ");
                    int course = sc.nextInt();
                    subject.setCourseId(course);
                    break;
                case 4:
                    System.out.print("\t Credits: ");
                    int credit = sc.nextInt();
                    subject.setCredits(credit);
                    break;
                case 5:
                    System.out.print("\t Capacity: ");
                    int capacity = sc.nextInt();
                    subject.setCapacity(capacity);
                    break;
                default:
                    System.out.println("Incorrect Choose");
                    break;
                
            }
            serviceSubject.modify(subject);
            System.out.println("Subject Modified");
        }
        sc.next();
    }

    private static void deleteSubject() {
        System.out.println("Deleting a Subject...");
        Subject subject = getSubject();
        if(subject != null) {
            serviceSubject.delete(subject);
            System.out.println("Subject deleted sucessfully");
        } else {
            System.out.println("Subject not deleted sucessfully");
        }
        sc.next();
    }

    private static void listSubjects() {
        System.out.println("Subject's List");
        for(Subject subject : serviceSubject.list()) {
            subject.print();
            System.out.println();
        }
        sc.next();
    }
    
}
