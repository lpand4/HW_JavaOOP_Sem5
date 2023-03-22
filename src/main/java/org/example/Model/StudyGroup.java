package org.example.Model;

import org.example.Model.Student;
import org.example.Model.Teacher;

import java.util.List;

public class StudyGroup {
    int groupId;
    public Teacher currentTeacher;
    public List<Student> studentList;

    public static int getCount() {
        return count;
    }

    private static int count = 1;

    public StudyGroup(Teacher currentTeacher, List<Student> studentList) {
        this.groupId = count;
        this.currentTeacher = currentTeacher;
        this.studentList = studentList;
        count++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Группа ")
                .append(groupId);
        return sb.toString();
    }

    public int getGroupId() {
        return groupId;
    }

    public void changeGroup(StudyGroup group){
        for (Student st: group.studentList){
            st.setGroupId(groupId);
        }
        group.currentTeacher.setGroups(groupId);
    }
}
