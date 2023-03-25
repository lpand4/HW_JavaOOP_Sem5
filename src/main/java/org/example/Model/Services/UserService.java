package org.example.Model.Services;

import org.example.Model.Services.Interfaces.CreateStudentInterface;
import org.example.Model.Services.Interfaces.CreateTeacherInterface;
import org.example.Model.Student;
import org.example.Model.Teacher;

import java.util.Date;
import java.util.Scanner;

public class UserService implements CreateStudentInterface, CreateTeacherInterface {
    Scanner in = new Scanner(System.in);
    @Override
    public Student createStudent() {
        System.out.println("Введите ФИО студента");
        String fio = in.nextLine();
        return new Student(new Date(), fio);
    }

    @Override
    public Teacher createTeacher() {
        System.out.println("Введите ФИО преподавателя");
        String fio = in.nextLine();
        return new Teacher(new Date(), fio);
    }
}
