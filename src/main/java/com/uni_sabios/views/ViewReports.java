package com.uni_sabios.views;

import java.sql.SQLException;
import java.util.List;

import com.uni_sabios.exceptions.fareexceptions.FareNullException;
import com.uni_sabios.exceptions.personexceptions.PersonNullException;
import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.exceptions.studentexceptions.StudentNullException;
import com.uni_sabios.exceptions.subjectexceptions.SubjectNullException;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Register;
import com.uni_sabios.repository.models.Schedule;
import com.uni_sabios.utils.Format;

public class ViewReports extends ViewMain{

    public static void startMenu() throws SQLException, ProgramNullException, SubjectNullException, FareNullException, PersonNullException, StudentNullException {
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
        System.out.println("\t 0) Return to Main Menu");
        System.out.println("*".repeat(35));
        System.out.print("Choose an Option: ");
        return sc.nextInt();
    }

    private static void studentByProgram() throws SQLException, ProgramNullException, StudentNullException{
        System.out.println("Students per Program...");
        System.out.println("Program ID: ");
        int programId = sc.nextInt();
        System.out.println(serviceProgram.getProgram(programId).getName() + "'s Students");
        for(Person person : serviceReport.getStudentbyProgram(programId)){
            person.print();
            System.out.println();
        }
        
    }

    private static void calculateCostSemester() throws SubjectNullException, FareNullException, PersonNullException, ProgramNullException, StudentNullException {
        sc.nextLine();
        System.out.println("Students per Program...");
        System.out.print("Student's Document: ");
        String document = sc.nextLine();
        System.out.print("Period's ID: ");
        int period = sc.nextInt();
        int fare = serviceFare.getFarebyPeriodSubject(document, period);
        clear();
        System.out.println("-".repeat(17) + " SUMMARY REGISTER" + "-".repeat(17));
        System.out.println("+" + "-".repeat(40) + "+" + "-".repeat(8) + "+");
        System.out.println("\tName: " + servicePerson.findByDocument(document).getFullName());
        System.out.println("\tProgram: " + serviceProgram.getProgram(serviceStudent.findbyId(servicePerson.findByDocument(document).getId()).getProgramId()).getName());
        System.out.println("+" + "-".repeat(40) + "+" + "-".repeat(8) + "+");
        System.out.printf("|%-40s|%-8s|\n", "COURSE", "CREDITS");
        System.out.println("+" + "-".repeat(40) + "+" + "-".repeat(8) + "+");
        int TotalSemester = 0;
        for(Register register : serviceReport.calculateSemester(document, period)){
            System.out.printf("|%40s|%8s|\n", serviceSubject.getSubject(register.getSubjectId()).getName(),serviceSubject.getSubject(register.getSubjectId()).getCredits());
            System.out.println("+" + "-".repeat(40) + "+" + "-".repeat(8) + "+");
            TotalSemester += serviceSubject.getSubject(register.getSubjectId()).getCredits() * fare;
        }
        System.out.println("\tTOTAL COST: " + Format.formatoMonedaPesos(TotalSemester));
    }

    private static void incomePerSemester() {
        
    }

    private static void studentSchedule() {
        sc.nextLine();
        List<Schedule> schedules = null;
        System.out.println("Enter the student's document: ");
        String document = sc.nextLine();
        int studentId;
        try {
            studentId = serviceStudent.findByDocument(document).getId();
            schedules = serviceSchedule.listByStudentId(studentId);
            if(schedules != null) {
                for(Schedule schedule : schedules) {
                    schedule.print();
                    System.out.println();
                }
            } else {
                System.out.println("No schedules found for student with ID: " + studentId);
            }
        } catch (PersonNullException e) {
            e.printStackTrace();
        }
        sc.next();
    }
        
    private static void orderProgramsByStudents() {

    }
    
}
