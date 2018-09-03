import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class course {
    private int selector;
    private boolean isRunning = true;
    private Scanner scanner = new Scanner(System.in);
    private String query;
    private String dbUrl = "jdbc:mysql://localhost:3306/kea";
    private String username = "root";
    private String password = "1234";

    public void courseMenu() {
        System.out.println("Kursus Main menu\n" +
                "[1] Opret Kursus\n" +
                "[2] Slet Kursus\n" +
                "[3] Print Kursuser\n" +
                "[4] Exit");
        try {
            selector = scanner.nextInt();
        } catch (InputMismatchException iME) {
        }
        scanner.nextLine();
        switch (selector) {
            case 1:
                System.out.println("Opret Kursus");
                insertCourse();
                break;
            case 2:
                System.out.println("Slet studerne");
                printCourse();
                deleteCourse();
                break;
            case 3:
                System.out.println("Print students");
                printCourse();
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
    public void insertCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast Kursus Navn");
        String name = scanner.nextLine();
        System.out.println();

        String query = "INSERT INTO courses (course_name) VALUES ('" + name + "'); ";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement()) {
            System.out.println(query);
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast #id på det kursus der skal slettes");
        Integer id = scanner.nextInt();
        System.out.println();
        String query = "DELETE FROM courses WHERE course_id = ('" + id +"')";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement()) {
            System.out.println(query);
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void printCourse() {
        query = "SELECT * FROM courses";

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            System.out.println("Kursus");
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


}
