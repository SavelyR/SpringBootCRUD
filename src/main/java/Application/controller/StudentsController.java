package Application.controller;

import Application.HibernateSessionConf;
import Application.entitys.Students;
import Application.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
public class StudentsController {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateSessionConf.class);

    @Autowired
    private final StudentsService service;

    public StudentsController(StudentsService service) {
        this.service = service;
    }

    @RequestMapping("student/{id}")
    public String getStudentById(@PathVariable("id")  Integer id) {
       EntityManager em = ((EntityManager) context.getBean("entityManager"));
       Students student = em.find(Students.class, id);
       em.detach(student);
       return student.toString();
    }

    @RequestMapping("student/em/add/")
    public String addStudentEm(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName,
                             @RequestParam(name = "groupId") int groupId ) {

        Students student = new Students();
        student.setFirst_name(firstName);
        student.setLastName(lastName);
        student.setGroup(groupId);

        EntityManager em = ((EntityManager) context.getBean("entityManager"));
        em.persist(student);
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.getTransaction().commit();

        return student.toString();
    }


    @RequestMapping("student/add/")
    public String addStudent(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName,
                             @RequestParam(name = "groupId") int groupId ) {
        Students student = new Students();
        student.setFirst_name(firstName);
        student.setLastName(lastName);
        student.setGroup(groupId);

        service.save(student);

        return student.toString();
    }

    @RequestMapping("student/byInstitute")
    public String getStudentsByInstitute(@RequestParam(name = "instId") int instId){
        Iterable<Students> studentsIterable = service.getAllByInst(instId);
        StringBuilder stringBuffer = new StringBuilder();
        studentsIterable.forEach(students -> stringBuffer.append(students.toString()));
        return stringBuffer.toString();
    }

    @RequestMapping("student/byFirstName")
    public String getStudentsFromGroup(@RequestParam(name = "name") String name) {
        Students student = service.getByFirstName(name);
        return student.toString();
    }

}