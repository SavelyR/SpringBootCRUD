package Application.entitys;

import Application.HibernateSessionConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "public")
public class Students {

    private String first_name;
    private String lastName;
    private Groups group;
    private int id;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_id_seq")
    @SequenceGenerator(name = "students_id_seq", sequenceName = "students_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 30)
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToOne()
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }
    public void setGroup(int id){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateSessionConf.class);
        EntityManager em = ((EntityManager) context.getBean("entityManager"));
        Groups group = em.find(Groups.class, id);
     //   em.detach(group);
        this.group = group;
    }

    @Override
    public String toString() {
        return "Students{" + "\n" +
                " id=" + id + ",\n"+
                " firstName='" + first_name + '\'' + ",\n" +
                " lastName='" + lastName + '\'' + ",\n" +
                " group=" + group + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students that = (Students) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
