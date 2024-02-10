package com.uni_sabios.views;

public class ViewStudent extends ViewMain{

    public static void startMenu() {

        int opc = 0;

        do {
            opc = showMenu();
            switch (opc) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    getStudent();
                    break;
                case 3:
                    modifyStudent();
                    break;
                case 4:
                    deleteStudent();
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
        System.out.println("\t 1) Create a new Student");
        System.out.println("\t 2) Get Student by ID");
        System.out.println("\t 3) Edit Student");
        System.out.println("\t 4) Delete Student");
        System.out.println("\t 5) Return to Main Menu");
        return sc.nextInt();
    } 

    private static void createStudent() {
        sc.nextLine();
        System.out.println("*".repeat(40));
        System.out.println("Create a new Student");
        System.out.print("- Name: ");
        String Name = sc.nextLine();
        System.out.print("- LastName: ");
        String lastName = sc.nextLine();
        System.out.print("- Id Number: ");
        int Id = sc.nextInt();
        System.out.println("- Phone Number: ");
        String Phone = sc.nextLine();
        System.out.println("- Date of Birth");
        System.out.println("\t- Age: ");
        int Age = sc.nextInt();
        System.out.println("\t- Month: ");
        int Month = sc.nextInt();
        System.out.println("\t- Day: "); 
        int Day = sc.nextInt();
        System.out.println("- Gender");
        System.out.println("\t- 1) Male");
        System.out.println("\t- 2) Female");

        int Age = sc.nextInt();
        System.out.println("\t- Month: ");
        int Month = sc.nextInt();


    }

    private static void getStudent() {
        
    }

    private static void modifyStudent() {
        
    }

    private static void deleteStudent() {
      
    }
    
}
