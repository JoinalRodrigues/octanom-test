package com.octanom.poc.dashboard.repository;

import com.octanom.poc.dashboard.domain.Student;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Repository
@EnableScheduling
public class StudentData {

    private List<Student> students = new ArrayList<>();

    private final String headerString = "name,m1,m2,m3,m4,m5";

    private int studentCount = 2;

    public List<Student> getStudents(){
        return this.students;
    }

    public StudentData(){
        this.loadCsvData("students.csv");
    }

    @Scheduled(fixedRate = 10000L)
    public void loadAndWriteCsvData() {
        this.writeCsvData("students.csv");
        this.loadCsvData("students.csv");
    }

    private void loadCsvData(String filePath){
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            //List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            bufferedReader.readLine();
            String line;
            students.clear();
            this.studentCount = 0;
            while((line = bufferedReader.readLine()) != null){
                String[] row = line.split(",");
                students.add(new Student(row[0]
                        , Double.parseDouble(row[1])
                        , Double.parseDouble(row[2])
                        , Double.parseDouble(row[3])
                        , Double.parseDouble(row[4])
                        , Double.parseDouble(row[5])));
                this.studentCount++;
            }

        } catch (IOException ioException) {
            System.out.println("IOException - Reading");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void writeCsvData(String filePath){
        Random random = new Random();
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
            bufferedWriter.write(headerString);
            for(int i = 0; i < this.studentCount; i++){
                DoubleStream doubleStream = random.doubles(5, 0.0, 100.0);
                Iterator<Double> doubleIterator = doubleStream.iterator();
                bufferedWriter.newLine();
                Student currentStudent = students.get(i);
                currentStudent.setM1(doubleIterator.next());
                currentStudent.setM2(doubleIterator.next());
                currentStudent.setM3(doubleIterator.next());
                currentStudent.setM4(doubleIterator.next());
                currentStudent.setM5(doubleIterator.next());
                bufferedWriter.write(currentStudent.toString());
                doubleStream.close();
            }
            bufferedWriter.flush();

        } catch (IOException ioException) {
            System.out.println("IOException - Writing");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
