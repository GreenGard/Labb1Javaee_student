package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {
    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {
        Subject subject1 = new Subject("Javaprogrammering");
        Subject subject2 = new Subject("Databaser");
        Subject subject3 = new Subject("Javaverktyg");
        Subject subject4 = new Subject("JavaEnterpise");

        Student student1 = new Student("Anna","Andersson","anna.andersson@gmail.com","0707884488");
        Student student2 = new Student("Nils","Nilsson","nils.nilsson@gmail.com","0707995599");
        Student student3 = new Student("Kim","Kimsson","kim.kimsson@gmail.com","0707773366");
        Student student4 = new Student("Bo","Ek","bo.ek@gmail.com","0707773366");
        Student student5 = new Student("Lennart","Andersson","lennart.andersson@gmail.com","0707773366");
        Student student6 = new Student("Agda","Andersson","agda.andersson@gmail.com","0707773366");


        Teacher teacher1=new Teacher("Martin","Blomberg","martin.blomberg@gmail.com","0707070707");
        Teacher teacher2=new Teacher("Eddie","Nuemann","eddie.nuemann@gmail.com","07080080808");
        Teacher teacher3=new Teacher("Pontus","REdig","pontus.redig@gmail.com","07070780808");


        subject1.addTeacher(teacher1);
        subject1.addStudent(student1);
        subject1.addStudent(student2);
        subject1.addStudent(student3);
        subject1.addStudent(student4);
        subject1.addStudent(student5);
        subject1.addStudent(student6);
        subject2.addTeacher(teacher2);
        subject2.addStudent(student1);
        subject2.addStudent(student2);
        subject2.addStudent(student3);
        subject3.addTeacher(teacher1);
        subject3.addStudent(student1);
        subject3.addStudent(student2);
        subject4.addTeacher(teacher3);
        subject4.addTeacher(teacher1);
        subject4.addStudent(student1);
        subject4.addStudent(student2);

        entityManager.persist(subject1);
        entityManager.persist(subject2);
        entityManager.persist(subject3);
        entityManager.persist(subject4);

    }
}
