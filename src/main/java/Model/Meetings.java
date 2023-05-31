package Model;

public class Meetings {
    private String datehold;
    private String clockhold;
    private String educationalcontent;
    public Meetings(String datehold,String clockhold,String educationalcontent){
        this.datehold = datehold;
        this.clockhold=clockhold;
        this.educationalcontent=educationalcontent;
    }

    public void setDatehold(String datehold) {
        this.datehold = datehold;
    }

    public String getDatehold() {
        return datehold;
    }

    public void setClockhold(String clockhold) {
        this.clockhold = clockhold;
    }

    public String getClockhold() {
        return clockhold;
    }

    public void setEducationalcontent(String educationalcontent) {
        this.educationalcontent = educationalcontent;
    }

    public String getEducationalcontent() {
        return educationalcontent;
    }
}
