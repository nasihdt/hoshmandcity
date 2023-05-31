package Model;

import java.util.ArrayList;

public class Course {
    private String coursecode;
    private String coursename;
    private String coursesection;
    private ArrayList<Meetings> meetlist;
    private String coursefee;


    public Course(String coursecode,String coursename,String coursesection,String coursefee,ArrayList<Meetings> meetlist){
        this.coursecode = coursecode;
        this.coursename = coursename;
        this.coursesection = coursesection;
        this.coursefee = coursefee;

        this.meetlist = new ArrayList<>();
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursefee(String coursefee) {
        this.coursefee = coursefee;
    }

    public String getCoursefee() {
        return coursefee;
    }

    public void setCoursesection(String coursesection) {
        this.coursesection = coursesection;
    }

    public String getCoursesection() {
        return coursesection;
    }

//    public void setCourseteach(String courseteach) {
//        this.courseteach = courseteach;
//    }
//
//    public String getCourseteach() {
//        return courseteach;
//    }

    public void setMeetlist(ArrayList<Meetings> meetlist) {
        this.meetlist = meetlist;
    }

    public ArrayList<Meetings> getMeetlist() {
        return meetlist;
    }
}
