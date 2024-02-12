package com.uni_sabios.views;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.exceptions.personexceptions.PersonNullException;
import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.exceptions.studentexceptions.StudentNullException;
import com.uni_sabios.repository.impl.RepositoryAddressMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryCityMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryPersonMysqlImpl;
import com.uni_sabios.repository.models.Address;
import com.uni_sabios.repository.models.City;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Program;
import com.uni_sabios.repository.models.Student;
import com.uni_sabios.services.ServiceAddress;
import com.uni_sabios.services.ServiceCity;
import com.uni_sabios.services.ServicePerson;
import com.uni_sabios.services.impl.ServiceAddressImpl;
import com.uni_sabios.services.impl.ServiceCityImpl;
import com.uni_sabios.services.impl.ServicePersonImpl;

public class ViewStudent extends ViewMain{

private static final ServiceAddress serviceAddress = new ServiceAddressImpl(new RepositoryAddressMysqlImpl());
    private static final ServiceCity serviceCity = new ServiceCityImpl(new RepositoryCityMysqlImpl());
    private static final ServicePerson servicePerson = new ServicePersonImpl(new RepositoryPersonMysqlImpl());

    public static void startMenu() throws ProgramNullException, StudentNullException {

        int opc = 0;

        do {
            clear();
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
                case 5:
                    listStudents();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Not Available Choice");
                    sc.next();
            }
            
        }while(opc>0);
    }

    private static int showMenu() {
        System.out.println("*".repeat(10) + " Student's Menu " + "*".repeat(10));
        System.out.println("\t 1) Create a new Student");
        System.out.println("\t 2) Get Student by ID");
        System.out.println("\t 3) Edit Student");
        System.out.println("\t 4) Delete Student");
        System.out.println("\t 5) List Students");
        System.out.println("\t 0) Return to Main Menu");
        System.out.println("*".repeat(35));
        System.out.print("Choose an Option: ");
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
         String gender_s = (gender == 1) ? "M" : "F";

        List<City> cities = serviceCity.toList();
        System.out.println("Cities List");
        for (int i=0; i<cities.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + cities.get(i).getName());
        }
        int op_city = 0;
        do{
            System.out.print("\t Choose a City: ");
            op_city = sc.nextInt();
        }while(op_city < 1 || op_city > cities.size());
        int city = cities.get(op_city-1).getId();
        List<Address> addresses = serviceAddress.list();
        System.out.println("Address List");
        int op_address = 0;
        for (int i=0; i<addresses.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + addresses.get(i).getAddress());
        }
        do{
            System.out.print("\t Choose an Address: ");
            op_address = sc.nextInt();
        }while(op_address < 1 || op_address > addresses.size());
        int address = addresses.get(op_address-1).getId();
        List<Program> programs = serviceProgram.list();
        int op_program = 0;
        System.out.println("Program List");
        for (int i=0; i<programs.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + programs.get(i).getName());
        }
        do{
            System.out.print("\t Choose a Program: ");
            op_program = sc.nextInt();
        }while(op_program < 1 || op_program > programs.size());
        int program = programs.get(op_program-1).getId();
        Person person = new Person(typeId, id, name, lastName, phone, date, gender_s, city, address);
        try {
            serviceStudent.create(person, program);
            System.out.println(person.getId());
            System.out.println("Student created successfully!");
        } catch (PersonExceptionInsertDataBase e) {
            e.printStackTrace();
        }
        sc.next();
    }

    private static void getStudent() throws ProgramNullException, StudentNullException {
         System.out.println("Searching a Student...");
        sc.nextLine();
        System.out.print("\t Student's Document: ");
        String document = sc.nextLine();
        try {
            Person student = serviceStudent.findByDocument(document);
            System.out.println();
            student.print();
        } catch (PersonNullException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
        sc.next();
    }

    private static void modifyStudent() throws ProgramNullException, StudentNullException {
        sc.nextLine();
        System.out.println("Editing a Student...");
        System.out.print("\t Student's Document: ");
        String document = sc.nextLine();
        try {
            Person student = serviceStudent.findByDocument(document);

            System.out.println("Editing Student: ");
            System.out.print("Name: ");
            String newName = sc.nextLine();
            student.setName((newName.length() > 0) ? newName : student.getName());
            System.out.print("Last Name: ");
            String newLastName = sc.nextLine();
            student.setLastName((newLastName.length() > 0) ? newLastName : student.getLastName());
            System.out.print("Phone: ");
            String newPhone = sc.nextLine();
            student.setPhoneNumber((newPhone.length() > 0) ? newPhone : student.getPhoneNumber());
            List<Address> addresses = serviceAddress.list();
            System.out.println("Address List");
            int op_address = 0;
            for (int i=0; i<addresses.size(); i++) {
                System.out.println("\t" + (i+1) + ") " + addresses.get(i).getAddress());
            }
            do{
                System.out.print("\t Choose an Address: ");
                op_address = sc.nextInt();
            }while(op_address < 1 || op_address > addresses.size());
            int address = addresses.get(op_address-1).getId();
            student.setAddressId(address);
            List<City> cities = serviceCity.toList();
            System.out.println("Cities List");
            for (int i=0; i<cities.size(); i++) {
                System.out.println("\t" + (i+1) + ") " + cities.get(i).getName());
            }
            int op_city = 0;
            do{
                System.out.print("\t Choose a City: ");
                op_city = sc.nextInt();
            }while(op_city < 1 || op_city > cities.size());
            int city = cities.get(op_city-1).getId();
            student.setCityResidence(city);

            student.print();

            servicePerson.update(student);
            List<Program> programs = serviceProgram.list();
            int op_program = 0;
            System.out.println("Program List");
            for (int i=0; i<programs.size(); i++) {
                System.out.println("\t" + (i+1) + ") " + programs.get(i).getName());
            }
            do{
                System.out.print("\t Choose a Program: ");
                op_program = sc.nextInt();
            }while(op_program < 1 || op_program > programs.size());
            int program = programs.get(op_program-1).getId();
            serviceStudent.update(new Student(program, student.getId()));

        }catch (PersonNullException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deleteStudent() {
        System.out.println("Deleting a Student...");
        sc.nextLine();
        System.out.print("\t Student's Document: ");
        String document = sc.nextLine();
        try {
            serviceStudent.delete(document);
            System.out.println("Student deleted successfully!");
        } catch (PersonNullException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
      
    }

    private static void listStudents() throws ProgramNullException, StudentNullException {
        clear();
        System.out.println("*".repeat(35) + " STUDENT'S LIST " + "*".repeat(35));
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(15) + "+" + "-".repeat(30) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(30) + "+");
        System.out.printf("|%-5s|%-15s|%-30s|%-15s|%-15s|%-30s|\n", "DOC", "ID", "FULL NAME", "PHONE NUMBER", "BIRTHDATE", "PROGRAM");
        System.out.println("+" + "-".repeat(5) + "+" + "-".repeat(15) + "+" + "-".repeat(30) + "+" + "-".repeat(15) + "+" + "-".repeat(15) + "+" + "-".repeat(30) + "+");
        for (Person student : serviceStudent.list()) {
            student.print();
        }
        sc.next();
    }
    
}
