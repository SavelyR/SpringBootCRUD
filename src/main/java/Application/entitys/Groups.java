package Application.entitys;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "groups", schema = "public", catalog = "bstu")
public class Groups {
    private int id;
    private String name;
    private Institutes institute;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_id_seq")
    @SequenceGenerator(name = "groups_id_seq", sequenceName = "groups_id", allocationSize = 1)
    @Column(name = "id", nullable = false, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    public Institutes getInstitute() {
        return institute;
    }

    public void setInstitute(Institutes institute) {
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "Groups{" + "\n" +
                " id=" + id + ",\n" +
                " name='" + name + '\'' + ",\n" +
                " institute=" + institute + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groups that = (Groups) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
