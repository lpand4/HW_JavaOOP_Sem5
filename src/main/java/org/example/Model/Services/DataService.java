package org.example.Model.Services;

import org.example.Model.Student;
import org.example.Model.Teacher;
import org.example.Model.User;

import java.util.List;

public interface DataService {
    User createStudent();
    User createTeacher();
    List<User> read(List<User> users);
}
