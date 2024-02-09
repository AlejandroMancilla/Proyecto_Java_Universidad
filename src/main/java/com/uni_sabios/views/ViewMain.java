package com.uni_sabios.views;

import com.uni_sabios.repository.impl.RepositoryClassroomMysqlImpl;
import com.uni_sabios.services.ServiceClassroom;
import com.uni_sabios.services.ServiceCourse;
import com.uni_sabios.services.impl.ServiceClassroomImpl;
import com.uni_sabios.services.impl.ServiceCourseImpl;

public class ViewMain {

    public static final ServiceClassroom serviceClassroom = new ServiceClassroomImpl(new RepositoryClassroomMysqlImpl());
    public static final ServiceCourse serviceCourse = new ServiceCourseImpl(new RepositoryCourseMysqlImpl());
    public static void main(String[] args) {
        
        int opc = 0;

        do {
            opc = menuMain();
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
                    ViewStudent.startMenu();
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
        }
        
    }
}