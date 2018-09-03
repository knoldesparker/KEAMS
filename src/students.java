import java.util.InputMismatchException;
import java.util.Scanner;

public class students {
    private int selector;
    private boolean isRunning = true;
    private Scanner scanner = new Scanner(System.in);
    db db = new db();


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
                    db.insertStudent();
                    break;
                case 2:
                    System.out.println("Slet studerne");
                    db.printStudents();
                    db.deleteStudent();
                    break;
                case 3:
                    System.out.println("Print students");
                    db.printStudents();
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
}


