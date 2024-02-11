package com.uni_sabios.views;

public class ViewPeriod extends ViewMain {

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createPeriod();
                    break;
                case 2:
                    getPeriod();
                    break;
                case 3:
                    modifyPeriod();
                    break;
                case 4:
                    deletePeriod();
                    break;
                default:
                    break;
            }
            
        }while(opc>0 && opc<5);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Period's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Period");
        System.out.println("\t 2) Get Period by ID");
        System.out.println("\t 3) Edit Period");
        System.out.println("\t 4) Delete Period");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createPeriod(){
        
        servicePeriod.create(Period);
    }

    private static void getPeriod() {
        
    }

    private static void modifyPeriod() {
        
    }

    private static void deletePeriod() {
      
    }
    
}
