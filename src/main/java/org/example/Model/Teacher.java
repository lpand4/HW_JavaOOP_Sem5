package org.example.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teacher extends User{
    int exp;
    List<Integer> groups = new ArrayList<>();
    static int count = 0;

    public Teacher(Date dateBirth, String fio) {
        super(dateBirth, fio, count++);
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher\n" +
                "    fio= " + fio +
                ",\n    teacher id=" + id +
                ",\n    groups=" + groups;
    }

    public void setGroups(Integer group) {
        this.groups.add(group);
    }
}
