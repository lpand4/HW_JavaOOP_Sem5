package org.example.Model.Services;

import org.example.Model.Student;
import org.example.Model.StudyGroup;
import org.example.Model.Teacher;
import org.example.View.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudyGroupService {
    Scanner in = new Scanner(System.in);
    public StudyGroup createGroup(List<Teacher> teacherList, List<Student> studentList){
        List<Student> studentGroup = new ArrayList<>();
        View v = new View();
        System.out.println(v.teacherView(teacherList));
        System.out.println("Выберите преподавателя группы");
        int choiseTeacher = in.nextInt();
        int choiseStudent;
        Teacher groupTeacher = teacherList.get(choiseTeacher - 1);
        System.out.println(v.studentView(studentList));
        System.out.println("Выберите студентов, которые относятся к группе, вводя их номера\n" +
                " Когда закончите набор, наберите -1");
        do {
            choiseStudent = in.nextInt();
            if (choiseStudent != -1) {
                studentGroup.add(studentList.get(choiseStudent - 1));
            }
        }while (choiseStudent != -1);

        StudyGroup group = new StudyGroup(groupTeacher, studentGroup);
        return group;
    }


}
