package AppointmentManager.repo.src.main.java.v1.mistral.english.java.appointment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private LocalDateTime appointmentDate;
    private String description;

    // Getters and setters for all fields, equals(), hashCode() and toString() methods
}