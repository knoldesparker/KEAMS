import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class students {
    private int selector;
    private boolean isRunning = true;
    private Scanner scanner = new Scanner(System.in);
    private String query;
    private String dbUrl = "jdbc:mysql://localhost:3306/kea";
    private String username = "root";
    private String password = "1234";


    public void studentMenu() {
            System.out.println("Studen Main menu\n" +
                    "[1] Opret Studerne\n" +
                    "[2] Slet studerne\n" +
                    "[3] Print Studerne\n" +
                    "[4] Exit");
            try {
                selector = scanner.nextInt();
            } catch (InputMismatchException iME) {
            }
            scanner.nextLine();
            switch (selector) {
                case 1:
                    System.out.println("Opret Studerne");
                    insertStudent();
                    break;
                case 2:
                    System.out.println("Slet studerne");
                    printStudents();
                    deleteStudent();
                    break;
                case 3:
                    System.out.println("Print students");
                    printStudents();
                    break;
                case 4:
                    System.out.println("Exit");
                    isRunning = false;
                    break;
                default:
                    System.out.println("forkert indput");
                    break;

            }

    }
    public void printStudents() {
        query = "SELECT * FROM students";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            System.out.println("Students");
            while (rs.next()) {
                int idStudent = rs.getInt(1);
                String nameStudent = rs.getString(2);

                System.out.println("id# " + idStudent + "\t" + nameStudent + "\t");

            }
            connection.close();
            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast #id på den studerne der skal slettes");
        Integer id = scanner.nextInt();
        System.out.println();
        String query = "DELETE FROM students WHERE stud_id = ('" + id +"')";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement()) {
            System.out.println(query);
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert name");
        String name = scanner.nextLine();
        System.out.println();

        String query = "INSERT INTO students (stud_name) VALUES ('" + name + "'); ";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement()) {
            System.out.println(query);
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


