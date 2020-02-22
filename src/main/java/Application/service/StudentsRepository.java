package Application.service;

import Application.entitys.Groups;
import Application.entitys.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends CrudRepository<Students, Long> {


        @Query("select st from Students st where st.first_name = :first_Name")
        Students getByFirstName(@Param("first_Name") String first_Name);

        Iterable<Students> getAllByGroup(Groups group);

        @Query("select st from  Students as st " +
                "join Groups as gp on st.group = gp "+
                "where gp.institute.id = :instId")
        Iterable<Students> getAllByInst(@Param("instId") int instId);
}
