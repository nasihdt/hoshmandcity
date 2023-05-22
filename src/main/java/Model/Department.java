package Model;

public class Department {
      private String namePlace;
      private String addressPlace;
      private String phonenumber;
      private String namebos;
      private String numberofemp;

      public Department(String namePlace,String phonenumber,String addressPlace,String namebos,String numberofemp){
            this.namePlace = namePlace;
            this.phonenumber = phonenumber;
            this.addressPlace = addressPlace;
            this.namebos = namebos;
            this.numberofemp = numberofemp;
      }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setAddressPlase(String addressPlase) {
        this.addressPlace = addressPlase;
    }

    public String getAddressPlase() {
        return addressPlace;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setNamebos(String namebos) {
        this.namebos = namebos;
    }

    public String getNamebos() {
        return namebos;
    }

    public void setNumberofemp(String numberofemp) {
        this.numberofemp = numberofemp;
    }

    public String getNumberofemp() {
        return numberofemp;
    }

    public String getAddressPlace() {
        return addressPlace;
    }
}
