package Application.service;

import Application.entitys.Students;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentsService {
    void save(Students students);
    Iterable<Students> getAllByInst(int inst_id);
    void delete(long id);
    Students getByFirstName(String firstName);

//    Students getByLastName(String firstName);
//    Students editStudentEntity(Students students);
//    List<Students> getAll();
//
//    Students saveAndFlush(Students students);
//    long getOne(long id);
//    Students findByFirstName(String firstName);
//    List<Students> findAll();
}
