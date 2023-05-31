package com.example.hoshmandcity;

import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Main extends Application {


    static FileHandler handler;

    static {
        try {
            handler = new FileHandler("logger.log",true);
        } catch (IOException e) {
            Logger logger = Logger.getLogger("com.javacodesgeeks.snippets.core");
            logger.addHandler(handler);
            logger.warning("warning message");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        String [] arrdatash = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\1.Shahrdar");
        String [] arrdataassis = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\2.Assistant");
        String [] arrdatabaz = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\3.Bazrass");
        String [] arrdataEmp = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\4.Employee");
        String [] arrdataHs = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Heras");
        String [] arrdatauni = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\1.Univercity");
        String [] arrdataair = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\2.Airport");
        String [] arrdatalib = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\3.Library");
        String [] arrdatahos = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\4.Hospital");
        String [] arrdatastitute = File.read("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Language");
           readfilesh(arrdatash);
           readfileAssis(arrdataassis);
         readfileBaz(arrdatabaz);
         readfileEmp(arrdataEmp);
         readfileHs(arrdataHs);
         readfileuniver(arrdatauni);
         readfilehos(arrdatahos);
         readfileair(arrdataair);
         readfilelib(arrdatalib);
         readfilelang(arrdatastitute);


    //   File.writeshahrdar("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\1.Shahrdar",Data.shlist);
//        File.writeassistant("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\2.Assistant",Data.assislist);
//        File.writeBaz("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\3.Bazrass",Data.bazraslist);
//        File.writeEmp("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\4.Employee",Data.emplist);
//        File.writeHeras("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Heras",Data.herasatlist);
//        File.writeuniver("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\1.Univercity",Data.unilist);
//        File.writeair("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\2.Airport",Data.airportslist);
//        File.writelib("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\3.Library",Data.liblist);
//        File.writehost("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\4.Hospital",Data.hoslist);
//        File.writestitute("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Language",Data.languagelist);
        FirstPage();
    }

    public static void FirstPage(){
        try {
           Stage Firstpage = new Stage();
           FXMLLoader loader = new FXMLLoader();
           Pane root = loader.load(Paths.get("src/main/java/View/Saple.fxml").toUri().toURL());
           Firstpage.setTitle("City Hol");
           Firstpage.setScene(new Scene(root,500,500));

           Firstpage.setResizable(false);
           Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }

    public static void readfilesh(String [] arrdatash){
        String newarrdatash []= new String[6];
        Data.shahrdar = new Shahrdar();
        for (int i=0;i<newarrdatash.length;i++){
            newarrdatash = arrdatash[i].split("`");

            //Data.shahrdar = new Shahrdar(newarrdatash[0],newarrdatash[1],newarrdatash[2],newarrdatash[3],newarrdatash[4],newarrdatash[5]);

        }
    }
    public static void readfileAssis(String [] arrdataassis){
        String newarrdataassis []= new String[6];
        for (int i=0;i<newarrdataassis.length;i++){
            //newarrdataassis = arrdataassis[i].split("`");
            Data.assislist.add(new Assistants(newarrdataassis[0],newarrdataassis[1],newarrdataassis[2],newarrdataassis[3],newarrdataassis[4],newarrdataassis[5]));
//          Data.assistants = new Assistants(newarrdataassis[0],newarrdataassis[1],newarrdataassis[2],newarrdataassis[3],newarrdataassis[4],newarrdataassis[5]);
//          Data.assislist.add(Data.assistants);
        }
    }
    public static void readfileBaz(String [] arrdatabz) {
        String newarrdatabz[] = new String[7];
        for (int i = 0; i < newarrdatabz.length; i++) {
            newarrdatabz = arrdatabz[i].split("`");
           // Data.bazraslist.add(new Bazras(newarrdatabz[0],newarrdatabz[1],newarrdatabz[2],newarrdatabz[3],newarrdatabz[4],newarrdatabz[5],newarrdatabz[6]));

        }
    }
    public static void readfileEmp(String [] arrdataemp){
        String newarrdataemp[] = new String[7];
        for (int i = 0; i < newarrdataemp.length; i++){
            newarrdataemp = arrdataemp[i].split("`");
           // Data.emplist.add(new Employee(newarrdataemp[0],newarrdataemp[1],newarrdataemp[2],newarrdataemp[3],newarrdataemp[4],newarrdataemp[5],newarrdataemp[6]));
        }
    }
    public static void readfileHs(String [] arrdatahs){
        String newarrdatahs[] = new String[8];
        for (int i = 0; i < newarrdatahs.length; i++){
            newarrdatahs = arrdatahs[i].split("`");
            //Data.herasatlist.add(new Herasat(newarrdatahs[0],newarrdatahs[1],newarrdatahs[2],newarrdatahs[3],newarrdatahs[4],newarrdatahs[5],newarrdatahs[6],newarrdatahs[7]));
        }
    }


    public static void readfileuniver(String [] arrdatauni){
        String newarrdatauni[] = new String[5];
        for (int i = 0; i < newarrdatauni.length; i++) {
            newarrdatauni = arrdatauni[i].split("`");
            //Data.unilist.add(new Univercity(newarrdatauni[0],newarrdatauni[1],newarrdatauni[2],newarrdatauni[3],newarrdatauni[4]));
        }
    }
    public static void readfilelib(String [] arrdatalib){
        String newarrdatalib[] = new String[5];
        for (int i = 0; i < newarrdatalib.length; i++) {
            newarrdatalib = arrdatalib[i].split("`");
           // Data.unilist.add(new Univercity(newarrdatalib[0],newarrdatalib[1],newarrdatalib[2],newarrdatalib[3],newarrdatalib[4]));
        }
    }
    public static void readfileair(String [] arrdataair){
        String newarrdataair[] = new String[5];
        for (int i = 0; i < newarrdataair.length; i++) {
            newarrdataair = arrdataair[i].split("`");
            //Data.unilist.add(new Univercity(newarrdataair[0],newarrdataair[1],newarrdataair[2],newarrdataair[3],newarrdataair[4]));
        }
    }
    public static void readfilehos(String [] arrdatahs){
        String newarrdatahs[] = new String[5];
        for (int i = 0; i < newarrdatahs.length; i++) {
            newarrdatahs = arrdatahs[i].split("`");
            //Data.unilist.add(new Univercity(newarrdatahs[0],newarrdatahs[1],newarrdatahs[2],newarrdatahs[3],newarrdatahs[4]));
        }
    }
    public static void readfilelang(String [] arrdatalang){
        String newarrdatalang[] = new String[5];
        for (int i = 0; i < newarrdatalang.length; i++) {
            newarrdatalang = arrdatalang[i].split("`");
           // Data.unilist.add(new Univercity(newarrdatalang[0],newarrdatalang[1],newarrdatalang[2],newarrdatalang[3],newarrdatalang[4]));
        }
    }
}
