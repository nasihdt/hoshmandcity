package Model;

public class Registrar extends UserStitute{

    private String registrarcode;
    private String username;
    private String password;

    public Registrar(String name, String lastname, String nationalnumber, String age, String gender, String phonenumber, String address, String registrarcode,String username,String password) {
        super(name, lastname, nationalnumber, age, gender, phonenumber, address);
        this.registrarcode = registrarcode;
        this.username = username;
        this.password = password;
    }

    public void setRegistrarcode(String registrarcode) {
        this.registrarcode = registrarcode;
    }

    public String getRegistrarcode() {
        return registrarcode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
