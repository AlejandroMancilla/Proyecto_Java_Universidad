package com.uni_sabios.views;

public class ViewDepartment extends ViewMain {

    public static void startMenu() {
        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createDepartment();
                    break;
                case 2:
                    getDepartment();
                    break;
                case 3:
                    modifyDepartment();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                default:
                    break;
            }
            
        }while(opc>0 && opc<4);
    }

    private static int showMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " Department's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Department");
        System.out.println("\t 2) Get Department by ID");
        System.out.println("\t 3) Edit Department");
        System.out.println("\t 4) Delete Department");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createDepartment(){
        
        //serviceDepartment.create(Department);
    }

    private static void getDepartment() {
        
    }

    private static void modifyDepartment() {
        
    }

    private static void deleteDepartment() {
      
    }
    
}
