import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection con;
        Statement stmt;
        ResultSet rs;
        //String createtable = "CREATE TABLE tbProduct(id int, name varchar(100), price_per_unit double, active_for_sell boolean)";
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/testDB","root","");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM tbProduct";
            rs = stmt.executeQuery(query);


            while(rs.next()) {
                System.out.println("============================================================");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Price per unit: " + rs.getString("price_per_unit"));
                if (rs.getString("active_for_sell").equals("1")) {
                    System.out.println("Active for sell: true");
                } else {
                    System.out.println("Active for sell: false");
                }
                System.out.println("============================================================");
            }

            /*
            rs.moveToInsertRow();
            rs.updateInt("id",3);
            rs.updateString("name","Carabao");
            rs.updateDouble("price_per_unit",7.8);
            rs.updateInt("active_for_sell",0);
            rs.insertRow();
            rs.moveToCurrentRow();
            System.out.println("Insert success");
             */

            //stmt.execute(createtable);
            //System.out.println("Connection success");
            con.close();
        }catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }

    }
}