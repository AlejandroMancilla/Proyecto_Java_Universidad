package com.uni_sabios.views;

import com.uni_sabios.exceptions.fareexceptions.FareNullException;
import com.uni_sabios.exceptions.periodexceptions.PeriodNullException;
import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.repository.models.Fare;

public class ViewFare extends ViewMain {

    public static void startMenu() throws ProgramNullException, PeriodNullException {
        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    createFare();
                    break;
                case 2:
                    printFare();
                    break;
                case 3:
                    modifyFare();
                    break;
                case 4:
                    listFares();
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
        System.out.println("*".repeat(13) + " Fare's Menu " + "*".repeat(13));
        System.out.println("\t 1) Create a new Fare");
        System.out.println("\t 2) Get Fare by ID");
        System.out.println("\t 3) Edit Fare");
        System.out.println("\t 4) List Fares");
        System.out.println("\t 0) Return to Main Menu");
        System.out.println("*".repeat(35));
        System.out.print("Choose an Option: ");
        return sc.nextInt();
    } 

    private static void createFare(){
        sc.nextLine();
        System.out.println("Creating new Fare...");
        System.out.print("\t Program ID: ");
        int program = sc.nextInt();
        System.out.print("\t Period ID: ");
        int period = sc.nextInt();
        System.out.print("\t Credit Value: ");
        int value = sc.nextInt();
        Fare fare = new Fare(program, period, value);
        serviceFare.create(fare);
        sc.next();
    }

    private static Fare getFare() {
        sc.nextLine();
        System.out.print("\t Fare's ID: ");
        int id = sc.nextInt();
        try {
            return serviceFare.getFare(id);
        } catch (FareNullException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void printFare() throws ProgramNullException, PeriodNullException {
        System.out.println("Searching a Fare...");
        sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        try {
            Fare fare = serviceFare.getFare(id);
            System.out.println();
            fare.print();
        } catch (FareNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void modifyFare() {
        System.out.println("Modifying a Fare...");
        Fare fare = getFare();
        if(fare != null) {
            int opc = 0;
            System.out.println(" 1) Program");
            System.out.println(" 2) Period");
            System.out.println(" 3) Credit Value");
            opc = sc.nextInt();
            sc.nextLine();
            if(opc == 1){
                System.out.print("\t New Program: ");
                int program = sc.nextInt();
                fare.setProgramId(program);
            }else if(opc == 2){
                System.out.print("\t New Period: ");
                int period = sc.nextInt();
                fare.setPeriodId(period);
            }else if(opc == 3){
                System.out.print("\t New Credit Value: ");
                int value = sc.nextInt();
                fare.setCreditValue(value);
            }else{
                System.out.println("Incorrect Choose");
            }
            serviceFare.modify(fare);
            System.out.println("Fare Modified");
        }
        sc.next(); 
    }

    private static void listFares() throws ProgramNullException, PeriodNullException {
        clear();
        System.out.println("*".repeat(28) + " FARE'S LIST" + "*".repeat(28));
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(30) + "+" + "-".repeat(10) + "+" + "-".repeat(20) + "+");
        System.out.printf("|%-5s|%-30s|%-10s|%-20s|\n", "ID", "PROGRAM", "PERIOD", "CREDITVALUE");
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(30) + "+" + "-".repeat(10) + "+" + "-".repeat(20) + "+");
        for(Fare fare : serviceFare.list()) {
            fare.print();
        }
        sc.next();
    }
}
