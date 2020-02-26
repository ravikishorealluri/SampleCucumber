package com.ravi.personal.utils;

import java.util.ArrayList;
import java.util.List;

public class Processing {
    StudentObject student = new StudentObject();
    List<StudentObject>  students = new ArrayList<>();

    List<StudentObject> methodFillStudents() {
            for (StudentObject singleStudent : students) {
                singleStudent.setBranch("fsdfs");
                singleStudent.setName("sdfsdfds");


                students.add(singleStudent);

            }

            return students;
    }

    void methodFetchStudents(List<StudentObject> students) {
        for (StudentObject singleStudent : students) {
            singleStudent.getBranch();
            singleStudent.getName();

        }
        }
}
