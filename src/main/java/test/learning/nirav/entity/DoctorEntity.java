package test.learning.nirav.entity;

import org.hibernate.Hibernate;
import test.learning.nirav.enums.Specification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name="doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable=false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Specification specification;

    @Column(nullable=false)
    private Time avilableTo;

    @Column(nullable=false)
    private Time avilableFrom;

    public DoctorEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public Time getAvilableTo() {
        return avilableTo;
    }

    public void setAvilableTo(Time avilableTo) {
        this.avilableTo = avilableTo;
    }

    public Time getAvilableFrom() {
        return avilableFrom;
    }

    public void setAvilableFrom(Time avilableFrom) {
        this.avilableFrom = avilableFrom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DoctorEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", specification=").append(specification);
        sb.append(", avilableTo=").append(avilableTo);
        sb.append(", avilableFrom=").append(avilableFrom);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DoctorEntity that = (DoctorEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public DoctorEntity(Long id) {
        this.id = id;
    }

    public DoctorEntity(String name, Specification specification, LocalTime avilableFrom, LocalTime avilableTo) {
        this.name = name;
        this.specification = specification;
        this.avilableTo = Time.valueOf(avilableTo);
        this.avilableFrom = Time.valueOf(avilableFrom);
    }
}
