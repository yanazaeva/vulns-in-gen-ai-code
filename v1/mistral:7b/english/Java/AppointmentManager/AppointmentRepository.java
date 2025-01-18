
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

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(String customerName, LocalDateTime appointmentDate, String description) {
        Appointment appointment = new Appointment();
        appointment.setCustomerName(customerName);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setDescription(description);
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public Appointment updateAppointment(Long id, String customerName, LocalDateTime appointmentDate, String description) {
        Appointment existingAppointment = getAppointmentById(id);
        existingAppointment.setCustomerName(customerName != null ? customerName : existingAppointment.getCustomerName());
        existingAppointment.setAppointmentDate(appointmentDate != null ? appointmentDate : existingAppointment.getAppointmentDate());
        existingAppointment.setDescription(description != null ? description : existingAppointment.getDescription());
        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.createAppointment(appointment.getCustomerName(), appointment.getAppointmentDate(), appointment.getDescription()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(id, updatedAppointment.getCustomerName(), updatedAppointment.getAppointmentDate(), updatedAppointment.getDescription()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.findAll());
    }
}