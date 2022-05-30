package by.itac.mylibrary.start;

import by.itac.mylibrary.controller.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        System.out.println("Select next action:");

        while (!exit) {
            int i = 4;
            System.out.println("----------------------------");
            System.out.println("1 - add new book");
            System.out.println("2 - delete book by id");
            System.out.println("3 - find book by id");
            System.out.println("4 - exit");
            System.out.println("----------------------------");

            try {
                System.out.print(">");
                i = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input!");
            }

            switch (i) {
                case 1:
                    try {
                        StringBuilder sb = new StringBuilder();

                        sb.append("save");
                        sb.append(" ");

                        System.out.print("Enter the author of the book to be saved>");
                        Scanner scannerAuthor = new Scanner(System.in);

                        sb.append("[");
                        sb.append(scannerAuthor.nextLine());
                        sb.append("]");

                        System.out.print("Enter the name of the book to be saved>");
                        Scanner scannerTitleBook = new Scanner(System.in);

                        sb.append("{");
                        sb.append(scannerTitleBook.nextLine());
                        sb.append("}");

                        System.out.print("Enter the year of the book to be saved>");
                        Scanner scannerYear = new Scanner(System.in);

                        sb.append("- ");
                        sb.append(scannerYear.nextLine());

                        String newBook = String.valueOf(sb);

                        System.out.println(controller.executeTask(newBook));

                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input!");
                    }
                    exit = true;
                    break;

                case 2:
                    try {
                        StringBuilder sb = new StringBuilder();

                        sb.append("delete");
                        sb.append(" ");

                        System.out.print("Enter the id of the book to be deleted>");
                        Scanner scannerID = new Scanner(System.in);
                        sb.append(scannerID.nextLine());

                        String delBook = String.valueOf(sb);

                        System.out.println(controller.executeTask(delBook));

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid book deletion data!");
                    }
                    exit = true;
                    break;

                case 3:
                    try {
                        StringBuilder sb = new StringBuilder();

                        sb.append("findById");
                        sb.append(" ");

                        System.out.print("Enter book id>");
                        Scanner scannerID = new Scanner(System.in);
                        sb.append(scannerID.nextLine());

                        String findBook = String.valueOf(sb);

                        System.out.println(controller.executeTask(findBook));

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid book search options!");
                    }
                    exit = true;
                    break;

                case 4:
                    System.out.println("The application has been exited!");
                    exit = true;
                    break;
            }

        }

    }
}
