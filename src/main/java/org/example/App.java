package org.example;


import org.example.service.ConnectionService;
import org.example.service.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class App
{
    public static final ConnectionService connectionService = new ConnectionService();

    public static void main(String[] args) throws IOException {
        StudentService studentService = new StudentService();

        Scanner Scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("***Student MANAGEMENT System***");
            System.out.println("-------------------------------");
            System.out.println("Select Opration");
            System.out.println("1, Registration Form");
            System.out.println("0, Exit");
            System.out.println("Enter your Choice:");
            choice = Integer.parseInt(Scanner.nextLine());

            switch (choice){
                case 1:
                    System.out.println("Performing CREATE Operation on Student");
                    studentService.insertStudent();
                    break;

                case 0:
                    System.out.println("Exiting Program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice !=0);
        Scanner.close();
    }
}
