package org.example.Model.Services;

import org.example.Model.Services.Interfaces.StudyGroupInterface;
import org.example.Model.Student;
import org.example.Model.StudyGroup;
import org.example.Model.Teacher;
import org.example.View.View;

import java.util.*;

public class StudyGroupService implements StudyGroupInterface{
    Scanner in = new Scanner(System.in);

    public StudyGroup createGroup(List<Teacher> teacherList, List<Student> studentList) {
        List<Student> studentGroup = new ArrayList<>();
        View v = new View();
        System.out.println(v.userView(teacherList));
        System.out.println("Выберите преподавателя группы");
        int choiseTeacher = in.nextInt();
        int choiseStudent;
        Teacher groupTeacher = teacherList.get(choiseTeacher - 1);
        System.out.println(v.userView(studentList));
        System.out.println("Выберите студентов, которые относятся к группе, вводя их номера\n" +
                " Когда закончите набор, наберите 0");
        HashSet<Integer> choises = new HashSet<>();
        do {
            choiseStudent = in.nextInt();

            if(!choises.contains(choiseStudent)){
                if (choiseStudent <= studentList.size() && choiseStudent >= 0) {
                    if (choiseStudent != 0) {
                        studentGroup.add(studentList.get(choiseStudent - 1));
                    }
                } else {
                    System.out.println("Введено некорректное значение!");
                }
            }else {
                System.out.println("Данный студент уже выбран");
            }
            choises.add(choiseStudent);
        } while (choiseStudent != 0);

        StudyGroup group = new StudyGroup(groupTeacher, studentGroup);
        return group;
    }
}
