package org.example.Model.Services.Interfaces;

import org.example.Model.Student;
import org.example.Model.StudyGroup;
import org.example.Model.Teacher;

import java.util.List;
//Interface Segregation Principle
public interface StudyGroupInterface {
    StudyGroup createGroup(List<Teacher> teacherList, List<Student> studentList);
}
