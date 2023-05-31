package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {
    public static String[] read(String filename) {

        String strArray = "";
        String line;
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            while ((line = in.readLine()) != null) {
                strArray += line + "\n";

            }
            in.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        String[] temp = strArray.split("\n");

        String array[] = new String[temp.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
        return array;
    }
    public static void writeshahrdar(String file,ArrayList<Shahrdar> arrdataSh){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdataSh.size();
            for (int i=0;i<size;i++){
                String str = arrdataSh.get(i).getName()+"`"+arrdataSh.get(i).getLastname()+"`"+arrdataSh.get(i).getPersonelynumber()+
                        "`"+arrdataSh.get(i).getHire_date()+"`"+arrdataSh.get(i).getSalary()+"`"+arrdataSh.get(i).getSabeghe();
                writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void writeassistant(String file,ArrayList<Assistants> arrdataAssis){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdataAssis.size();
            for (int i=0;i<size;i++){
                String str = arrdataAssis.get(i).getName()+"`"+arrdataAssis.get(i).getLastname()+"`"+arrdataAssis.get(i).getPersonelynumber()+
                        "`"+arrdataAssis.get(i).getHire_date()+"`"+arrdataAssis.get(i).getSalary()+"`"+arrdataAssis.get(i).getSabeghe();
                writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void writeBaz(String file,ArrayList<Bazras> arrdataBaz){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdataBaz.size();
            for (int i=0;i<size;i++){
                String str = arrdataBaz.get(i).getName()+"-"+arrdataBaz.get(i).getLastname()+"-"+arrdataBaz.get(i).getPersonelynumber()+
                        "-"+arrdataBaz.get(i).getHire_date()+"-"+arrdataBaz.get(i).getSalary()+"-"+arrdataBaz.get(i).getSabeghe()+"-"+arrdataBaz.get(i).getWorkhour();
                writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void writeEmp(String file,ArrayList<Employee> arrdataEmp){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdataEmp.size();
            for (int i=0;i<size;i++){
                String str = arrdataEmp.get(i).getName()+"-"+arrdataEmp.get(i).getLastname()+"-"+arrdataEmp.get(i).getPersonelynumber()+
                        "-"+arrdataEmp.get(i).getHire_date()+"-"+arrdataEmp.get(i).getSalary()+"-"+arrdataEmp.get(i).getSabeghe()+"-"+arrdataEmp.get(i).getWorkhour();
                writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void writeHeras(String file,ArrayList<Herasat> arrdataHs){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdataHs.size();
            for (int i=0;i<size;i++){
                String str = arrdataHs.get(i).getName()+"-"+arrdataHs.get(i).getLastname()+"-"+arrdataHs.get(i).getPersonelynumber()+
                        "-"+arrdataHs.get(i).getHire_date()+"-"+arrdataHs.get(i).getSalary()+"-"+arrdataHs.get(i).getSabeghe()+"-"+arrdataHs.get(i).getNumberofshift()+"-"+arrdataHs.get(i).getDatatypeshift();
                writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeuniver(String file,ArrayList<Univercity> arrdatauni){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdatauni.size();
            for (int i=0;i<size;i++){
                String str = arrdatauni.get(i).getNamePlace()+"-"+arrdatauni.get(i).getPhonenumber()
                        +"-"+arrdatauni.get(i).getAddressPlase()+"-"+arrdatauni.get(i).getNamebos()+"-"+arrdatauni.get(i).getNumberofemp();
                     writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void writehost(String file,ArrayList<Hospital> arrdatahos){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdatahos.size();
            for (int i=0;i<size;i++){
                String str = arrdatahos.get(i).getNamePlace()+"-"+arrdatahos.get(i).getPhonenumber()
                        +"-"+arrdatahos.get(i).getAddressPlase()+"-"+arrdatahos.get(i).getNamebos()+"-"+arrdatahos.get(i).getNumberofemp();
                writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void writeair(String file,ArrayList<Airport> arrdataair){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdataair.size();
            for (int i=0;i<size;i++){
                String str = arrdataair.get(i).getNamePlace()+"-"+arrdataair.get(i).getPhonenumber()
                        +"-"+arrdataair.get(i).getAddressPlase()+"-"+arrdataair.get(i).getNamebos()+"-"+arrdataair.get(i).getNumberofemp();
                writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void writelib(String file,ArrayList<Library> arrdatalib){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdatalib.size();
            for (int i=0;i<size;i++){
                String str = arrdatalib.get(i).getNamePlace()+"-"+arrdatalib.get(i).getPhonenumber()
                        +"-"+arrdatalib.get(i).getAddressPlase()+"-"+arrdatalib.get(i).getNamebos()+"-"+arrdatalib.get(i).getNumberofemp();
                writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void writestitute(String file ,ArrayList<LanguageInstitute> arrdatalang){
        try {
            FileWriter writer = new FileWriter(file);
            int size = arrdatalang.size();
            for (int i=0;i<size;i++){
                String str = arrdatalang.get(i).getNamePlace()+"-"+arrdatalang.get(i).getPhonenumber()
                        +"-"+arrdatalang.get(i).getAddressPlase()+"-"+arrdatalang.get(i).getNamebos()+"-"+arrdatalang.get(i).getNumberofemp();
                writer.write(str);
                if (i<size-1){
                    writer.write("\n");
                }
            }
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
