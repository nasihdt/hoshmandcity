package Model;

public class Teacher extends UserStitute {

    private String codeTeacher;
    private String dgeducation;
    private String Rgcode;
    private String courses;

    public Teacher(String name, String lastname, String nationalnumber, String age, String gender, String phonenumber, String address,String codeTeacher,String dgeducation,String Rgcode,String courses) {
        super(name, lastname, nationalnumber, age, gender, phonenumber, address);
        this.codeTeacher = codeTeacher;
        this.dgeducation = dgeducation;
        this.Rgcode = Rgcode;
        this.courses = courses;
    }

    public void setCodeTeacher(String codeTeacher) {
        this.codeTeacher = codeTeacher;
    }

    public String getCodeTeacher() {
        return codeTeacher;
    }

    public void setDgeducation(String dgeducation) {
        this.dgeducation = dgeducation;
    }

    public String getDgeducation() {
        return dgeducation;
    }

    public void setRgcode(String rgcode) {
        Rgcode = rgcode;
    }

    public String getRgcode() {
        return Rgcode;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getCourses() {
        return courses;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
