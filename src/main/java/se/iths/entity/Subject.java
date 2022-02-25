package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List <Student> students=new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setSubject(this);
    }

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List <Teacher> teachers=new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.setSubject(this);
    }

    public Long getId() {
        return id;
    }

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}


