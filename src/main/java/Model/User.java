package Model;

public class User {
     private String Adminusername;
     private String Adminuserpassword;

     public User(){
         this.Adminusername = "User_1402";
         this.Adminuserpassword = "user1402!";
     }

    public void setAdminusername(String adminusernamme) {
        Adminusername = adminusernamme;
    }

    public String getAdminusername() {
        return Adminusername;
    }

    public void setAdminuserpassword(String adminuserpassword) {
        Adminuserpassword = adminuserpassword;
    }

    public String getAdminuserpassword() {
        return Adminuserpassword;
    }
}
