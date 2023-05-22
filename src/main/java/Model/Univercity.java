package Model;

public class Univercity extends Department{

    public Univercity(String namePlace,String phonenumber,String addressPlace,String namebos,String numberofemp){
        super(namePlace,phonenumber,addressPlace,namebos,numberofemp);

    }

    @Override
    public void setAddressPlase(String addressPlase) {
        super.setAddressPlase(addressPlase);
    }

    @Override
    public String getAddressPlase() {
        return super.getAddressPlase();
    }

}
