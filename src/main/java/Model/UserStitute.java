package Model;

public class UserStitute {
    private String name;
    private String lastname;
    private String nationalnumber;
    private String age;
    private String gender;
    private String phonenumber;
    private String address;

    public UserStitute(String name,String lastname,String nationalnumber,String age, String gender,String phonenumber,String address){
           this.name = name;
           this.lastname = lastname;
           this.nationalnumber = nationalnumber;
           this.age = age;
           this.gender = gender;
           this.phonenumber = phonenumber;
           this.address = address;
     }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setNationalnumber(String nationalnumber) {
        this.nationalnumber = nationalnumber;
    }

    public String getNationalnumber() {
        return nationalnumber;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
