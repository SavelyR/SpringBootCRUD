package Application.entitys;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "institutes", schema = "public", catalog = "bstu")
public class Institutes {
    private int id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "institutes_id_seq")
    @SequenceGenerator(name = "institutes_id_seq", sequenceName = "institutes_id", allocationSize = 1)
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

    @Override
    public String toString() {
        return "Institutes{" + "\n" +
                " id=" + id + ",\n" +
                " name='" + name + '\'' + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institutes that = (Institutes) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
