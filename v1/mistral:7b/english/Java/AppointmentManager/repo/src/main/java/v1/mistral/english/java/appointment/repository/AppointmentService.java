package AppointmentManager.repo.src.main.java.v1.mistral.english.java.appointment.repository;

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