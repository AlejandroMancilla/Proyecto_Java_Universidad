package com.uni_sabios.views;

public class ViewClassroom extends ViewMain{

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createClassroom();
                    break;
                case 2:
                    getClassroom();
                    break;
                case 3:
                    modifyClassroom();
                    break;
                case 4:
                    deleteClassroom();
                    break;
                default:
                    break;
            }
            
        }while(opc>0 && opc<4);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Student's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Classroom");
        System.out.println("\t 2) Get Classroom by ID");
        System.out.println("\t 3) Edit Classroom");
        System.out.println("\t 4) Delete Classroom");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createClassroom(){
        
        //serviceClassroom.create(Classroom);
    }

    private static void getClassroom() {
        
    }

    private static void modifyClassroom() {
        
    }

    private static void deleteClassroom() {
      
    }
    
}
