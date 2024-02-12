package com.uni_sabios.views;

public class ViewReports extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    studentByCourse();
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
        System.out.println("\t 1) Students by Course");
        System.out.println("\t 2) Cost of a Student's semester");
        System.out.println("\t 3) University income per semester");
        System.out.println("\t 4) Display a student's timetable");
        System.out.println("\t 5) Number of Students by Program (Ordered)");
        System.out.println("\t 6) Return to Main Menu");
        return sc.nextInt();
    }

    private static void studentByCourse(){

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
