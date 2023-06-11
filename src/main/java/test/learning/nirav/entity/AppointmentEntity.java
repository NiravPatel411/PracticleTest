package test.learning.nirav.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private DoctorEntity doctor;

    @Column(length=50, nullable=false)
    private String patientName;

    @Column
    private String emailId;

    @Column(nullable = false)
    private String mobileNo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;

    public AppointmentEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppointmentEntity{");
        sb.append("id=").append(id);
        sb.append(", doctor=").append(doctor);
        sb.append(", patientName='").append(patientName).append('\'');
        sb.append(", emailId='").append(emailId).append('\'');
        sb.append(", mobileNo='").append(mobileNo).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", appointmentDate=").append(appointmentDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppointmentEntity that = (AppointmentEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
