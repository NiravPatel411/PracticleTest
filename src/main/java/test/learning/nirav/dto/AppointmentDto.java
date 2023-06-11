package test.learning.nirav.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

public class AppointmentDto {

    private Long id;

    @NotNull(message = "doctor is not selected")
    private Long doctor;

    @Size(min = 2, message = "user name should have at least 2 characters")
    private String patientName;

    @Email(message = "Invalid Email")
    private String emailId;

    @Size(min = 10, max = 12,message = "Invalid Mobile NO")
    private String mobileNo;

    @NotNull(message = "Date of birth is mandatory")
    private Date dateOfBirth;

    @NotNull(message = "Appointment date can not be blank")
    private LocalDateTime appointmentDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctor() {
        return doctor;
    }

    public void setDoctor(Long doctor) {
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

    public AppointmentDto() {
    }

    public AppointmentDto(Long id, Long doctor, String patientName, String emailId, String mobileNo, Date dateOfBirth, LocalDateTime appointmentDate) {
        this.id = id;
        this.doctor = doctor;
        this.patientName = patientName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.dateOfBirth = dateOfBirth;
        this.appointmentDate = appointmentDate;
    }
}
