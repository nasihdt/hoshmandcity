package Model;

public class Student extends UserStitute{
    private String codeStudent;
    private String codeRgcode;
    private String numberofcourse;
    private String codenowcourse;
    private String highestsection;
    public Student(String name, String lastname, String nationalnumber, String age, String gender, String phonenumber, String address
    ,String codeStudent,String codeRgcode,String numberofcourse,String codenowcourse,String highestsection) {
        super(name, lastname, nationalnumber, age, gender, phonenumber, address);
        this.codeStudent = codeStudent;
        this.codeRgcode=codeRgcode;
        this.numberofcourse = numberofcourse;
        this.codenowcourse = codenowcourse;
        this.highestsection = highestsection;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodenowcourse(String codenowcourse) {
        this.codenowcourse = codenowcourse;
    }

    public String getCodenowcourse() {
        return codenowcourse;
    }

    public void setCodeRgcode(String codeRgcode) {
        this.codeRgcode = codeRgcode;
    }

    public String getCodeRgcode() {
        return codeRgcode;
    }

    public void setNumberofcourse(String numberofcourse) {
        this.numberofcourse = numberofcourse;
    }

    public String getNumberofcourse() {
        return numberofcourse;
    }

    public void setHighestsection(String highestsection) {
        this.highestsection = highestsection;
    }

    public String getHighestsection() {
        return highestsection;
    }
}
