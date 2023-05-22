//package Model;
//
//import javafx.collections.ObservableList;
//import util.DBUtil;
//
//import java.sql.SQLException;
//
//public class ShahrdarDAO {
//    public static void insertsh(String name,String lastname,String personely,String hiredate,String salary,String sabeghe) {
//        String updateStmt =
//                "BEGIN\n" +
//                        "INSERT INTO shahrdar\n" +
//                        "(FIRST_NAME, LAST_NAME, PERSONELY, HIRE_DATE, SALARY,SABEGHE)\n" +
//                        "VALUES\n" +
//                        "( " + name + "', '" + lastname + "','" + personely + "','" + hiredate + "','" + salary + "','" + sabeghe + ");\n" +
//                        "END;";
//        String updateStmt1 = "ENSERT INTO information_table"+"(First_name,Last_name,Personely,Hire_date,Salary,Sabeghe"+"VALUES(?,?,?,?,?,?)";
//        //Execute DELETE operation
//        try {
//            try {
//                DBUtil.dbExecuteUpdate(updateStmt);
//            }
//            catch (SQLException e) {
//                e.printStackTrace();
//                System.out.print("Error occurred while DELETE Operation: " + e);
//
//
//            }
//            catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    public static void deleteshwithprs (String prs) throws SQLException, ClassNotFoundException {
//        //Declare a DELETE statement
//        String updateStmt =
//                "BEGIN\n" +
//                        "   DELETE FROM shahrdar\n" +
//                        "         WHERE shahrdar_prs ="+ prs +";\n" +
//                        "   COMMIT;\n" +
//                        "END;";
//        //Execute UPDATE operation
//        try {
//            DBUtil.dbExecuteUpdate(updateStmt);
//        } catch (SQLException e) {
//            System.out.print("Error occurred while DELETE Operation: " + e);
//            throw e;
//        }
//    }
//    public static void updateShinfo (String prs, String name,String lastname,String salary,String sabeghe) throws SQLException, ClassNotFoundException {
//        //Declare a UPDATE statement
//        String updateStmt =
//                "BEGIN\n" +
//                        "   UPDATE employees\n" +
//                        "      SET INFO = '" + name + lastname+salary+sabeghe+ "'\n" +
//                        "    WHERE SHAHRDAR_PRS = " + prs + ";\n" +
//                        "   COMMIT;\n" +
//                        "END;";
//        //Execute UPDATE operation
//        try {
//            DBUtil.dbExecuteUpdate(updateStmt);
//        } catch (SQLException e) {
//            System.out.print("Error occurred while UPDATE Operation: " + e);
//            throw e;
//        }
//    }
//}
