package com.uni_sabios.views;

import com.uni_sabios.repository.models.Student;

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

    private static String showTypes() {
        int opc = 0;
        String TypeId = "";
        do{
            System.out.println("- ID Type");
            System.out.println("\t- 1) CC");
            System.out.println("\t- 2) TI");
            System.out.println("\t- 3) Passport");
            System.out.println("\t- 4) CE");
            System.out.println("- Choose: ");
            opc = sc.nextInt();
        }while(opc < 1 || opc > 4);
        switch (opc) {
            case 1:
                TypeId = "C.C.";
                break;
            case 2: 
                TypeId = "T.I.";
                break;
            case 3:
                TypeId = "Passport";
                break;
            case 4:
                TypeId = "C.E.";
                break;
            default:
                break;
        }
        return TypeId;
    }

    private static void createStudent() {
        sc.nextLine();
        System.out.println("*".repeat(40));
        System.out.println("Create a new Student");
        String typeId = showTypes();
        System.out.print("- Id Number: ");
        String id = sc.nextLine();
        System.out.print("- Name: ");
        String name = sc.nextLine();
        System.out.print("- LastName: ");
        String lastName = sc.nextLine();
        System.out.println("- Phone Number: ");
        String phone = sc.nextLine();
        System.out.println("- Date of Birth");
        System.out.println("\t- Year: ");
        int year = sc.nextInt();
        System.out.println("\t- Month: ");
        int month = sc.nextInt();
        System.out.println("\t- Day: "); 
        int day = sc.nextInt();
        String date = year + "-" + month + "-" + day;
        int gender = 0;
        do{
            System.out.println("- Gender");
            System.out.println("\t- 1) Male");
            System.out.println("\t- 2) Female");
            System.out.println("- Choose: ");
            gender = sc.nextInt();
        }while(gender < 1 || gender > 2);
        int city = 0;
        do{
            System.out.println("- City of Residence");
            
            city = sc.nextInt();
        }while(city < 1 || city > 5);
        System.out.println("- Address: ");
        String address = sc.nextLine();
        int program = 0;
        do{
            System.out.println("- Program");
            
            program = sc.nextInt();
        }while(program < 1 || program > 5);
        //Student student = new Student(typeId, id, name, lastName, phone, date, gender, city, address, program);
        //serviceStudent.create(student);
    }

    private static void getStudent() {
        
    }

    private static void modifyStudent() {
        
    }

    private static void deleteStudent() {
      
    }
    
}
