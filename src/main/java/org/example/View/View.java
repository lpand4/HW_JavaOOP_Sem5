package org.example.View;

import org.example.Model.Student;
import org.example.Model.StudyGroup;
import org.example.Model.Teacher;
import org.example.Model.User;

import java.util.List;

public class View <T extends User> {

    public String userView(List<T> userList){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (User user:userList) {
            sb.append(count)
                    .append(". ")
                    .append(user.toString())
                    .append("\n");
            count++;
        }
        return sb.toString();
    }
    //Заменил повторяющийся код, используя обобщение
//    public String teacherView(List<Teacher> teachers){
//        StringBuilder sb = new StringBuilder();
//        int count = 1;
//        for (User ts:teachers) {
//            sb.append(count)
//                    .append(". ")
//                    .append(ts.toString())
//                    .append("\n");
//            count++;
//        }
//        return sb.toString();
//    }
    public String groupView(StudyGroup group){
        StringBuilder sb = new StringBuilder();
        sb.append("Группа ")
                .append(group.getGroupId())
                .append("\nПреподаватель \n")
                .append(group.currentTeacher)
                .append("\nСтуденты: \n");
        //заменил повторяющийся код на имеюшийся
        sb.append(userView((List<T>) group.studentList));
        return sb.toString();
    }

    public String listOfGroupView(List<StudyGroup> groups){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (StudyGroup sg:groups) {
            sb.append(count)
                    .append(". ")
                    .append(sg.toString())
                    .append("\n");
            count++;
        }
        return sb.toString();
    }
    public String startMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Меню: \n")
                .append("1 - Создать студента\n")
                .append("2 - Создать преподавателя\n")
                .append("3 - Создать группу\n")
                .append("4 - Посмотреть список групп\n")
                .append("5 - Посмотреть группу\n")
                .append("6 - Посмотреть студентов без группы и преподавателей\n")
                .append("0 - Завершить работу\n");
        return sb.toString();
    }


}

