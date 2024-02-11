package com.uni_sabios.views;

public class ViewProgram extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createProgram();
                    break;
                case 2:
                    getProgram();
                    break;
                case 3:
                    modifyProgram();
                    break;
                case 4:
                    deleteProgram();
                    break;
                default:
                    break;
            }
        }while(opc>0 && opc<5);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Program's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Program");
        System.out.println("\t 2) Get Program by ID");
        System.out.println("\t 3) Edit Program");
        System.out.println("\t 4) Delete Program");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createProgram(){
        System.out.println("Crear");
    }

    private static void getProgram() {
        
    }

    private static void modifyProgram() {
        
    }

    private static void deleteProgram() {
      
    }
    
}
