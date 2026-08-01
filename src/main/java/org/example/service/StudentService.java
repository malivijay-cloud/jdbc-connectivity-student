package org.example.service;

import org.example.Repository.StudentRepository;
import org.example.model.Student;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentService {
    private static final StudentRepository studentRepository = new StudentRepository();
    public void insertStudent(){
        Scanner Scanner = new Scanner(System .in);
        System.out.println("pls enter stuent id:");
        int studentId = Integer.parseInt(Scanner.nextLine());

        System.out.println("pls enter student name:");
        String studentName = Scanner.nextLine();

        System.out.println("pls enter student Address:");
        String studentAddress = Scanner.nextLine();

        Student student = new Student(studentId,studentName,studentAddress);

        try{
            if (studentRepository.insertStudent(student)){
                System.out.println("Student inserted successfully!");
            }else{
                System.out.println("Failed to insert employee");
            }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
