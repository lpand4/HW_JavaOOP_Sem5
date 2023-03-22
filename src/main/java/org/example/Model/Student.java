package org.example.Model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Student extends User{
    int groupId;
    List<Integer> grades;
    static int count = 0;

//    public Student(Date dateBirth, String fio, int id, int groupId, List<Integer> grades) {
//        super(dateBirth, fio, count++);
//        this.groupId = groupId;
//        this.grades = grades;
//    }

    public Student(Date dateBirth, String fio) {
        super(dateBirth, fio, count++);
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student\n" +
                "    fio= " + fio +
                ",\n    id= " + id +
                ",\n    groupId= " + groupId;
    }

    @Override
    public boolean equals(Object o) {
        Student student = (Student) o;
        return this.id == student.id;
    }


    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
