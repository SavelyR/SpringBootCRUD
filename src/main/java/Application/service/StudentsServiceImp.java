package Application.service;

import Application.entitys.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsServiceImp implements StudentsService {

    @Autowired
    private final StudentsRepository studentsRepository;

    public StudentsServiceImp(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public void save(Students students) {
        Students savedStudents = studentsRepository.save(students);
    }

    @Override
    public void delete(long id) {
        studentsRepository.delete(studentsRepository.findById(id).get());
    }

    @Override
    public Students getByFirstName(String firstName) {
        return studentsRepository.getByFirstName(firstName);
    }
    @Override
    public Iterable<Students> getAllByInst(int instId){
        return studentsRepository.getAllByInst(instId);
    }
//
//    @Override
//    @Transactional
//    public Students getByLastName(String lastName) {
//        return new Students();
//        // studentEntityRepository.getByLastName(lastName);
//    }
//
//    @Override
//    @Transactional
//    public Students editStudentEntity(Students students) {
//        return studentsService.saveAndFlush(students);
//    }
//
//    @Override
//    @Transactional
//    public List<Students> getAll() {
//        return studentsService.findAll();
//    }
//
//    @Override
//    @Transactional
//    public Students saveAndFlush(Students students) {
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public long getOne(long id) {
//        return 0;
//    }
//
//    @Override
//    @Transactional
//    public Students findByFirstName(String firstName) {
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public List<Students> findAll() {
//        return null;
//    }
}