package com.uni_sabios.views;

import java.util.List;

import com.uni_sabios.exceptions.personexceptions.PersonException;
import com.uni_sabios.exceptions.personexceptions.PersonExceptionInsertDataBase;
import com.uni_sabios.exceptions.personexceptions.PersonNullException;
import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.exceptions.studentexceptions.StudentNullException;
import com.uni_sabios.repository.models.Address;
import com.uni_sabios.repository.models.City;
import com.uni_sabios.repository.models.Department;
import com.uni_sabios.repository.models.Person;
import com.uni_sabios.repository.models.Teacher;

public class ViewTeacher extends ViewMain{
    public static void startMenu() throws PersonException, ProgramNullException, StudentNullException {

        int opc = 0;

        do {
            clear();
            opc = showMenu();
            switch (opc) {
                case 1:
                    createTeacher();
                    break;
                case 2:
                    getTeacher();
                    break;
                case 3:
                    modifyTeacher();
                    break;
                case 4:
                    deleteTeacher();
                    break;
                case 5:
                    listTeachers();
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
        System.out.println("\t 1) Create a new Teacher");
        System.out.println("\t 2) Get Teacher by ID");
        System.out.println("\t 3) Edit Teacher");
        System.out.println("\t 4) Delete Teacher");
        System.out.println("\t 5) List Teachers");
        System.out.println("\t 0) Return to Main Menu");
        System.out.println("*".repeat(35));
        System.out.print("Choose an Option: ");
        return sc.nextInt();
    } 

    private static void createTeacher() {
        sc.nextLine();
        System.out.println("*".repeat(40));
        System.out.println("Create a new Student");
        int typeId = 0;
        do{
            System.out.println("- ID Type");
            System.out.println("\t- 1) CC");
            System.out.println("\t- 2) TI");
            System.out.print("- Choose: ");
            typeId = sc.nextInt();
        }while(typeId < 1 || typeId > 2);
        sc.nextLine();
        String type = (typeId == 1) ? "C.C" : "T.I";
        System.out.print("- Id Number: ");
        String id = sc.nextLine();
        System.out.print("- Name: ");
        String name = sc.nextLine();
        System.out.print("- LastName: ");
        String lastName = sc.nextLine();
        System.out.println("- Phone Number: ");
        String phone = sc.nextLine();
        System.out.println("- Date of Birth");
        System.out.print("\t- Year: ");
        int age = sc.nextInt();
        System.out.print("\t- Month: ");
        int month = sc.nextInt();
        System.out.print("\t- Day: "); 
        int day = sc.nextInt();
        String date = age + "-" + month + "-" + day;
        int gender = 0;
        do{
            System.out.println("- Gender");
            System.out.println("\t- 1) Male");
            System.out.println("\t- 2) Female");
            System.out.print("- Choose: ");
            gender = sc.nextInt();
        }while(gender < 1 || gender > 2);
        String gender_s = (gender == 1) ? "M" : "F";

        List<City> cities = serviceCity.toList();
        System.out.println("Cities List");
        for (int i=0; i<cities.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + cities.get(i).getName());
        }
        int cityOp = 0;
        do{
            System.out.print("\t Choose a City: ");
            cityOp = sc.nextInt();
        }while(cityOp < 1 || cityOp > cities.size());
        int city = cities.get(cityOp-1).getId();
        List<Address> addresses = serviceAddress.list();
        System.out.println("Address List");
        int adressOp = 0;
        for (int i=0; i<addresses.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + addresses.get(i).getAddress());
        }
        do{
            System.out.print("\t Choose an Address: ");
            adressOp = sc.nextInt();
        }while(adressOp < 1 || adressOp > addresses.size());
        int address = addresses.get(adressOp-1).getId();
        System.out.println("Departments List");
        List<Department> departments = serviceDepartment.list();
        for (int i=0; i<departments.size(); i++) {
            System.out.println("\t" + (i+1) + ") " + departments.get(i).getName());
        }
        int departmentOp = 0;
        do{
            System.out.print("\t Choose a Department: ");
            departmentOp = sc.nextInt();
        }while(departmentOp < 1 || departmentOp > departments.size());
        int department = departments.get(departmentOp-1).getId();
        Person person = new Person(type, id, name, lastName, phone, date, gender_s, city, address);
        try {
            serviceTeacher.create(person, department);
            System.out.println("Teacher created successfully!");
        } catch (PersonExceptionInsertDataBase e) {
            System.out.println(e.getMessage());
        }
        sc.next();
    }

    private static void getTeacher() {
        System.out.println("Searching a Teacher...");
        sc.nextLine();
        System.out.print("\t Teacher's Document: ");
        String document = sc.nextLine();
        try {
            Person teacher = serviceTeacher.getPerson(document);
            teacher.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.next();
    }

    private static void modifyTeacher() throws PersonException, ProgramNullException, StudentNullException {
        sc.nextLine();
        System.out.println("Modifying a Teacher...");
        System.out.print("\t Teacher's Document: ");
        String document = sc.nextLine();
        try {
            Person teacher = serviceTeacher.getPerson(document);

            System.out.println("Modifying Teacher: ");
            System.out.println("Name: ");
            String name = sc.nextLine();
            teacher.setName((name.length()>0) ? name : teacher.getName());
            System.out.println("Last Name: ");
            String lastName = sc.nextLine();
            teacher.setLastName((lastName.length()>0) ? lastName : teacher.getLastName());
            System.out.println("Phone: ");
            String phone = sc.nextLine();
            teacher.setPhoneNumber((phone.length()>0) ? phone : teacher.getPhoneNumber());
            List<Address> addresses = serviceAddress.list();
            System.out.println("Address List");
            int addressOp = 0;
            for (int i=0; i<addresses.size(); i++) {
                System.out.println("\t" + (i+1) + ") " + addresses.get(i).getAddress());
            }
            do{
                System.out.print("\t Choose an Address: ");
                addressOp = sc.nextInt();
            }while(addressOp < 1 || addressOp > addresses.size());
            int address = addresses.get(addressOp - 1).getId();
            teacher.setAddressId(address);
            List<City> cities = serviceCity.toList();
            System.out.println("Cities List");
            for (int i=0; i<cities.size(); i++) {
                System.out.println("\t" + (i+1) + ") " + cities.get(i).getName());
            }
            int cityOp = 0;
            do{
                System.out.print("\t Choose a City: ");
                cityOp = sc.nextInt();
            }while(cityOp < 1 || cityOp > cities.size());
            int city = cities.get(cityOp-1).getId();
            teacher.setCityResidence(city);

            teacher.print();
            servicePerson.update(teacher);
            List<Department> departments = serviceDepartment.list();
            System.out.println("Departments List");
            for (int i=0; i<departments.size(); i++) {
                System.out.println("\t" + (i+1) + ") " + departments.get(i).getName());
            }
            int departmentOp = 0;
            do{
                System.out.print("\t Choose a Department: ");
                departmentOp = sc.nextInt();
            }while(departmentOp < 1 || departmentOp > departments.size());
            int department = departments.get(departmentOp-1).getId();
            serviceTeacher.modify(new Teacher(teacher.getId(), department));

        } catch (PersonNullException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteTeacher() {
        System.out.println("Deleting a Teacher...");
        sc.nextLine();
        System.out.print("\t Teacher's Document: ");
        String document = sc.nextLine();
        try {
            serviceTeacher.delete(document);
            System.out.println("Teacher deleted successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listTeachers() throws ProgramNullException, StudentNullException {
        clear();
        System.out.println("Teachers List");
        for (Person teacher : serviceTeacher.list()){
            teacher.print();
        }
        sc.next();
    }
}

