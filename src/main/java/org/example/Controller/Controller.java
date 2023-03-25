package org.example.Controller;

import org.example.Model.Services.StudyGroupService;
import org.example.Model.Student;
import org.example.Model.StudyGroup;
import org.example.Model.Teacher;
import org.example.Model.User;
import org.example.Model.Services.UserService;
import org.example.View.View;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Controller {
    View v = new View();
    UserService us = new UserService();
    StudyGroupService sgs = new StudyGroupService();
    List<Student> studentList;
    List<Teacher> teacherList;
    List<StudyGroup> studyGroups;
    Scanner in = new Scanner(System.in);


    public Controller() {
        this.studentList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
        this.studyGroups = new ArrayList<>();

    }


    public void start() throws InterruptedException {
        int choise;
            try {
                do {
                    System.out.println(v.startMenu());
                    choise = in.nextInt();
                    switch (choise) {
                        case 1:
                            System.out.println("Создаем студента: ");
                            addStudent();
                            break;
                        case 2:
                            System.out.println("Создаем преподавателя: ");
                            addTeacher();
                            break;
                        case 3:
                            if (teacherList.size() == 0)
                                System.out.println("Сначала необходимо создать преподавателей");
                            else if (studentList.size() == 0)
                                System.out.println("Сначала необходимо создать студентов");
                            else
                                addGroup(teacherList, studentList);
                            break;
                        case 4:
                            System.out.println("Список групп: ");
                            showListGroups();
                            TimeUnit.SECONDS.sleep(3);
                            break;
                        case 5:
                            showListGroups();
                            showUsersInGroup();
                            TimeUnit.SECONDS.sleep(5);
                            break;
                        case 6:
                            System.out.println("Студенты без группы и учителя: ");
                            showUsersWithoutGroups();
                            TimeUnit.SECONDS.sleep(5);
                            break;
                        case 0:
                            System.out.println("Всего доброго");
                            break;
                        default:
                            System.out.println("Введенное значение не подходит.");
                            break;
                    }
                } while (choise != 0);
            } catch (InputMismatchException a) {
                System.out.println("Введено неверное значение!");
            }
    }

    private void addStudent() {
        Student student = us.createStudent();
        studentList.add(student);
    }

    private void addTeacher() {
        Teacher teacher = us.createTeacher();
        teacherList.add(teacher);
    }

    private void addGroup(List<Teacher> teacherList, List<Student> studentList) {
        StudyGroup group = sgs.createGroup(teacherList, studentList);
        for (Student st : group.studentList) {
            studentList.remove(st);
        }
        studyGroups.add(group);
        group.changeGroup(group);
    }

    private void showListGroups() {
        System.out.println(v.listOfGroupView(studyGroups));
    }

    private void showUsersInGroup() {
        System.out.println("Введите номер группы, которую хотите посмотреть \n");
        int index = in.nextInt();
        System.out.println(v.groupView(studyGroups.get(index - 1)));
    }

    private void showUsersWithoutGroups() {
        System.out.println(v.userView(studentList));
        System.out.println(v.userView(teacherList));
    }


//    public static void wait(int ms)
//    {
//        try
//        {
//            Thread.sleep(ms);
//        }
//        catch(InterruptedException ex)
//        {
//            Thread.currentThread().interrupt();
//        }
//    }

}
