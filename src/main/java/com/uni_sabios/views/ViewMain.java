package com.uni_sabios.views;

import java.sql.SQLException;
import java.util.Scanner;

import com.uni_sabios.exceptions.buildingexceptions.BuildingNullException;
import com.uni_sabios.exceptions.fareexceptions.FareNullException;
import com.uni_sabios.exceptions.periodexceptions.PeriodNullException;
import com.uni_sabios.exceptions.personexceptions.PersonException;
import com.uni_sabios.exceptions.programexceptions.ProgramNullException;
import com.uni_sabios.exceptions.subjectexceptions.SubjectNullException;
import com.uni_sabios.repository.impl.RepositoryAddressMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryCityMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryClassroomMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryCourseMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryDepartmentMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryFareMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryPeriodMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryPersonMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryProgramMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryReportsMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryScheduleMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryStudentMysqlImpl;
import com.uni_sabios.repository.impl.RepositorySubjectMysqlImpl;
import com.uni_sabios.repository.impl.RepositoryTeacherMysqlImpl;
import com.uni_sabios.repository.impl.implregisters.RepositoryRegisterMysqlImpl;
import com.uni_sabios.services.ServiceAddress;
import com.uni_sabios.services.ServiceCity;
import com.uni_sabios.services.ServiceClassroom;
import com.uni_sabios.services.ServiceCourse;
import com.uni_sabios.services.ServiceDepartment;
import com.uni_sabios.services.ServiceFare;
import com.uni_sabios.services.ServicePeriod;
import com.uni_sabios.services.ServicePerson;
import com.uni_sabios.services.ServiceProgram;
import com.uni_sabios.services.ServiceRegister;
import com.uni_sabios.services.ServiceReport;
import com.uni_sabios.services.ServiceSchedule;
import com.uni_sabios.services.ServiceStudent;
import com.uni_sabios.services.ServiceSubject;
import com.uni_sabios.services.ServiceTeacher;
import com.uni_sabios.services.impl.ServiceAddressImpl;
import com.uni_sabios.services.impl.ServiceCityImpl;
import com.uni_sabios.services.impl.ServiceClassroomImpl;
import com.uni_sabios.services.impl.ServiceCourseImpl;
import com.uni_sabios.services.impl.ServiceDepartmentImpl;
import com.uni_sabios.services.impl.ServiceFareImpl;
import com.uni_sabios.services.impl.ServicePeriodImpl;
import com.uni_sabios.services.impl.ServicePersonImpl;
import com.uni_sabios.services.impl.ServiceProgramImpl;
import com.uni_sabios.services.impl.ServiceRegisterImpl;
import com.uni_sabios.services.impl.ServiceReportImpl;
import com.uni_sabios.services.impl.ServiceScheduleImpl;
import com.uni_sabios.services.impl.ServiceStudentImpl;
import com.uni_sabios.services.impl.ServiceSubjectImpl;
import com.uni_sabios.services.impl.ServiceTeacherImpl;

public class ViewMain {

    public static final ServiceAddress serviceAddress = new ServiceAddressImpl(new RepositoryAddressMysqlImpl());
    public static final ServiceCity serviceCity = new ServiceCityImpl(new RepositoryCityMysqlImpl());
    public static final ServiceClassroom serviceClassroom = new ServiceClassroomImpl(new RepositoryClassroomMysqlImpl());
    public static final ServiceCourse serviceCourse = new ServiceCourseImpl(new RepositoryCourseMysqlImpl());
    public static final ServiceDepartment serviceDepartment = new ServiceDepartmentImpl(new RepositoryDepartmentMysqlImpl());
    public static final ServiceFare serviceFare = new ServiceFareImpl(new RepositoryFareMysqlImpl());
    public static final ServicePeriod servicePeriod = new ServicePeriodImpl(new RepositoryPeriodMysqlImpl());
    public static final ServicePerson servicePerson = new ServicePersonImpl(new RepositoryPersonMysqlImpl());
    public static final ServiceProgram serviceProgram = new ServiceProgramImpl(new RepositoryProgramMysqlImpl());
    public static final ServiceReport serviceReport = new ServiceReportImpl(new RepositoryReportsMysqlImpl());
    public static final ServiceRegister serviceRegister = new ServiceRegisterImpl(new RepositoryRegisterMysqlImpl());
    public static final ServiceSchedule serviceSchedule = new ServiceScheduleImpl(new RepositoryScheduleMysqlImpl());
    public static final ServiceStudent serviceStudent = new ServiceStudentImpl(new RepositoryStudentMysqlImpl());
    public static final ServiceSubject serviceSubject = new ServiceSubjectImpl(new RepositorySubjectMysqlImpl());
    public static final ServiceTeacher serviceTeacher = new ServiceTeacherImpl(new RepositoryTeacherMysqlImpl());
        
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ProgramNullException, SubjectNullException, FareNullException, PersonException, PeriodNullException, BuildingNullException {
        
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
                    ViewRegister.startMenu();
                    break;
                case 12:
                    ViewReports.startMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Not Available Choice");
                    sc.next();
            }
        }while(opc>0);
    }

    public static int mainMenu() {
        clear();
        System.out.println("*".repeat(10) + " SABIO'S UNIVERSITY SYSTEM " + "*".repeat(10));
        System.out.println("\t 1) Students Management");
        System.out.println("\t 2) Teachers Management");
        System.out.println("\t 3) Programs Management");
        System.out.println("\t 4) Courses Management");
        System.out.println("\t 5) Subjects Management");
        System.out.println("\t 6) Periods Management");
        System.out.println("\t 7) Fares Management");
        System.out.println("\t 8) Departments Management");
        System.out.println("\t 9) Classroom Management");
        System.out.println("\t10) Schedules Management");
        System.out.println("\t11) Registers Management");
        System.out.println("\t12) Reports");
        System.out.println("\t 0) Exit");
        System.out.println("*".repeat(47));
        System.out.print("Choose an Option: ");
        return sc.nextInt();
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}