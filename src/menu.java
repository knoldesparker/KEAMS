import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {
    private int selector;
    private boolean isRunning = true;
    private Scanner scanner = new Scanner(System.in);

    public void mainmenu(){
        System.out.println("Kea Systems\n" + "Velkommen til KEA MS v0.1" );
        while (isRunning){
            System.out.println("Main menu\n" +
            "[1] Studerne\n" +
            "[2] Underviser\n" +
            "[3] Kurser\n" +
            "[4] Eksamner\n" +
            "[5] Exit");

            try {
                selector = scanner.nextInt();
            } catch (InputMismatchException iME){
                System.out.println("Forkert indput");
            }
            scanner.nextLine();
            switch (selector){
                case 1:
                    System.out.println("Studerne");
                    break;

                case 2:
                    System.out.println("Underviser");
                    break;

                case 3:
                    System.out.println("Kurser");
                    break;

                case 4:
                    System.out.println("Eksamer");
                    break;

                case 5:
                    System.out.println("Exit");
                    isRunning = false;
                    break;

                    default:
                        System.out.println("forkert indput");
                        break;
            }



        }

    }
}
