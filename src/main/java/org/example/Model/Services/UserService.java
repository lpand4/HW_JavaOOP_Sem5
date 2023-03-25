package org.example.Model.Services;

import org.example.Model.Services.DataService;
import org.example.Model.Student;
import org.example.Model.Teacher;
import org.example.Model.User;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserService implements DataService {
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
