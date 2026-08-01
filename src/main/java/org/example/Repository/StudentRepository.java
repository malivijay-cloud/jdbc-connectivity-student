package org.example.Repository;
import org.example.model.Student;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class StudentRepository {
    private static Connection Connection = null;
    private void initConnection() throws SQLException{
        if (Connection == null || Connection.isClosed()){
            Connection = new org.example.service.ConnectionService().getConnection();
        }
    }
    public List<Student> retrieveStudent() throws SQLException{
        this.initConnection();
        List<Student> students = new ArrayList<>();

        try{
                    this.initConnection();
                    Statement Statement = Connection.createStatement();
                    ResultSet resultSet = Statement.executeQuery("SELECT * FROM student");

                    while (resultSet.next()){
                        int stuentId = resultSet.getInt("studentId");
                        String studentName =resultSet.getString("studentName");
                        String studentAddress =resultSet.getString("studentAddress");

                        Student student = new Student(stuentId, studentName, studentAddress);
                        students.add(student);
                    }
                }catch (SQLException e){
                    System.err.println("SQL error: "+e.getMessage());
                }finally {
                    if (Connection != null){
                        try{
                            Connection.close();
                        }catch (SQLException e){
                            System.err.println("Error closing Connection: "+e.getMessage());
                        }
                    }
                }
                return students;
    }
    public boolean insertStudent(Student Student)throws SQLException{
        this.initConnection();
        String query = "INSERT INTO student VALUES(?, ?, ?)";
        try (PreparedStatement PreparedStatement = Connection.prepareStatement(query)){
            PreparedStatement.setInt(1, Student.getStudentId());
            PreparedStatement.setString(2, Student.getStudentName());
            PreparedStatement.setString(3, Student.getStudentAddress());
            System.out.println("Inserting student data to table:"+ Student);

            int rowsInserted = PreparedStatement.executeUpdate();
            return rowsInserted > 0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
