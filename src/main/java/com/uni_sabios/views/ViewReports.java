package com.uni_sabios.views;

import java.sql.SQLException;

import com.uni_sabios.repository.models.Person;

public class ViewReports extends ViewMain{

    public static void startMenu() throws SQLException {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    studentByProgram();
                    break;
                case 2:
                    calculateCostSemester();
                    break;
                case 3:
                    incomePerSemester();
                    break;
                case 4:
                    studentSchedule();
                    break;
                case 5:
                    orderProgramsByStudents();
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
        System.out.println("\t 1) Students by Program");
        System.out.println("\t 2) Cost of a Student's semester");
        System.out.println("\t 3) University income per semester");
        System.out.println("\t 4) Display a student's timetable");
        System.out.println("\t 5) Number of Students by Program (Ordered)");
        System.out.println("\t 6) Return to Main Menu");
        return sc.nextInt();
    }

    private static void studentByProgram() throws SQLException{
        System.out.println("Students per Program...");
        System.out.println("Program ID: ");
        int programId = sc.nextInt();
        for(Person person : serviceReport.getStudentbyProgram(programId)){
            person.print();
            System.out.println();
        }
    }

    private static void calculateCostSemester() {
        
    }

    private static void incomePerSemester() {
        
    }

    private static void studentSchedule() {
        
    }

    private static void orderProgramsByStudents() {

    }
    
}
