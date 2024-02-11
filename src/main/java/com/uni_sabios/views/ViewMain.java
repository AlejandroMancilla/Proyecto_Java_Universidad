package com.uni_sabios.views;

import java.util.Scanner;

import com.uni_sabios.repository.impl.RepositoryClassroomMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryCourseMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryStudentMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryTeacherMysqlImpl;
import com.uni_sabios.services.ServiceClassroom;
import com.uni_sabios.services.ServiceCourse;
import com.uni_sabios.services.ServiceStudent;
import com.uni_sabios.services.ServiceTeacher;
import com.uni_sabios.services.impl.ServiceClassroomImpl;
import com.uni_sabios.services.impl.ServiceCourseImpl;
import com.uni_sabios.services.impl.ServiceStudentImpl;
import com.uni_sabios.services.impl.ServiceTeacherImpl;

public class ViewMain {

    public static final ServiceClassroom serviceClassroom = new ServiceClassroomImpl(new RepositoryClassroomMysqlImpl());
    public static final ServiceCourse serviceCourse = new ServiceCourseImpl(new RepositoryCourseMysqlImpl());
    public static final ServiceStudent serviceStudent = new ServiceStudentImpl(new RepositoryStudentMysqlImpl());
    public static final ServiceTeacher serviceTeacher = new ServiceTeacherImpl(new RepositoryTeacherMysqlImpl());
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        int opc = 0;

        do {
            opc = mainMenu();
            switch (opc) {
                case 1:
                    ViewStudent.startMenu();
                    break;
                case 2:
                    ViewTeacher.startMenu();
                    break;
                case 3:
                    ViewProgram.startMenu();
                    break;
                case 4:
                    ViewCourse.startMenu();
                    break;
                case 5:
                    ViewSubject.startMenu();
                    break;
                case 6:
                    ViewPeriod.startMenu();
                    break;
                case 7:
                    ViewFare.startMenu();
                    break;
                case 8:
                    ViewDepartment.startMenu();
                    break;
                case 9:
                    ViewClassroom.startMenu();
                    break;
                case 10:
                    ViewSchedule.startMenu();    
                    break;
                case 11:
                    ViewReports.startMenu();
                    break;
                default:
                    break;
            }
        }while(opc>0 && opc<12);
    }

    public static int mainMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        System.out.println("*".repeat(10) + " SABIO'S UNIVERSITY SYSTEM " + "*".repeat(10));
        System.out.println("\t1- Students Management");
        System.out.println("\t2- Teachers Management");
        System.out.println("\t3- Programs Management");
        System.out.println("\t4- Courses Management");
        System.out.println("\t5- Subjects Management");
        System.out.println("\t6- Periods Management");
        System.out.println("\t7- Fares Management");
        System.out.println("\t8- Departments Management");
        System.out.println("\t9- Classroom Management");
        System.out.println("\t10- Schedules Management");
        System.out.println("\t11- Reports");
        System.out.println("\t0- Exit");
        return sc.nextInt();
    }
}