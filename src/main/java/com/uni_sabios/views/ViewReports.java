package com.uni_sabios.views;

import java.sql.SQLException;

import com.uni_sabios.exceptions.fareexceptions.FareNullException;
import com.uni_sabios.exceptions.personexceptions.PersonNullException;
import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.exceptions.subjectexceptions.SubjectNullException;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Register;

public class ViewReports extends ViewMain{

    public static void startMenu() throws SQLException, ProgramNullException, SubjectNullException, FareNullException, PersonNullException {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    studentByProgram();
                    sc.next();
                    break;
                case 2:
                    calculateCostSemester();
                    sc.next();
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

    private static void studentByProgram() throws SQLException, ProgramNullException{
        System.out.println("Students per Program...");
        System.out.println("Program ID: ");
        int programId = sc.nextInt();
        System.out.println(serviceProgram.getProgram(programId).getName() + "'s Students");
        for(Person person : serviceReport.getStudentbyProgram(programId)){
            person.print();
            System.out.println();
        }
        
    }

    private static void calculateCostSemester() throws SubjectNullException, FareNullException, PersonNullException {
        sc.nextLine();
        System.out.println("Students per Program...");
        System.out.print("Student's Document: ");
        String document = sc.nextLine();
        System.out.print("Period's ID: ");
        int period = sc.nextInt();
        int fare = serviceFare.getFarebyPeriodSubject(document, period);
        int TotalSemester = 0;
        for(Register register : serviceReport.calculateSemester(document, period)){
            TotalSemester += serviceSubject.getSubject(register.getSubjectId()).getCredits() * fare;
        }
        System.out.println("Total Cost: " + TotalSemester);
    }

    private static void incomePerSemester() {
        
    }

    private static void studentSchedule() {
        
    }

    private static void orderProgramsByStudents() {

    }
    
}
