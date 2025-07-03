import java.sql.*;
import java.util.Scanner;

public class Employee {

    static String url = "jdbc:mysql://localhost:3306/student";
    static String username = "root";
    static String password = "Macbook7.";

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            int choice;
            do{
                System.out.println("\nEmployee Management System");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employee");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.println("Choose an option: ");
                choice = sc.nextInt();

                switch (choice){
                    case 1: addEmployee();break;
                    case 2: viewEmployee();break;
                    case 3: updateEmployee();break;
                    case 4: deleteEmployee();break;
                    case 5:
                        System.out.println("Exiting...");;break;
                    default:
                        System.out.println("Invalid choice!");

                }
            }while(choice!=0);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void addEmployee() throws SQLException {
        System.out.println("Enter Id: ");
        int id = sc.nextInt();
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();
        System.out.println("Enter salary:");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO demo(id,name, email, salary)VALUES(?,?,?,?)";
           try{

               PreparedStatement pst = con.prepareStatement(sql);
               pst.setInt(1,id);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setDouble(4, salary);
           int count =  pst.executeUpdate();

        System.out.println("Employee added successfully.");
           }
        catch(SQLException e){
                   System.out.println(e);
               }

    }


    static void viewEmployee() throws SQLException
    {
        String sql = "SELECT * FROM demo";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n---Employee List---");
        while(rs.next())
        {
            System.out.println("ID:" +rs.getInt("id")+",Name: " +rs.getString("name") + ",Email: " +rs.getString("email") +",Salary: "+ rs.getDouble("salary"));
        }
    }

    static void updateEmployee() throws SQLException {
        System.out.println("Enter the employee ID to update: ");
        int id = sc.nextInt();
        System.out.println("Enter new name: ");
        String name = sc.next();
        System.out.println("Enter new email: ");
        String email = sc.next();
        System.out.println("Enter new salary: ");
        double salary = sc.nextDouble();


        String sql = "UPDATE demo SET name = ?, email = ?, salary = ? WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,name);
        pst.setString(2,email);
        pst.setDouble(3,salary);
        pst.setInt(4,id);

        int rows = pst.executeUpdate();
        if(rows>0)
            System.out.println("Employee updated successfully.");
        else System.out.println("Employee not found!");
    }

static void deleteEmployee() throws SQLException {
    System.out.println("Enter the employee ID to delete: ");
    int id = sc.nextInt();

    String sql = "DELETE FROM demo WHERE id = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1,id);

    int rows = pst.executeUpdate();
    if(rows>0)
        System.out.println("Employee deleted successfully.");
else System.out.println("Employee not found!!");
}}

