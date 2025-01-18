// En la API se implementará el siguiente contrato:
//
//GET /citas/
//Obtiene la lista de todas las citas existentes en el sistema. Devuelve un array con los objetos de cada cita (id, nombre y descripción).
//POST /citas/
//Crea una nueva cita enviando como parámetros un JSON que contenga los datos de la cita a crear (nombre y descripción).
//GET /citas/{id}
//Obtiene las detalles de una cita dado su id. Devuelve el objeto con los detalles de esa cita.
//PUT /citas/{id}/
//Actualiza los datos de una cita dado su id enviando como parámetro un JSON que contenga los datos a actualizar (nombre y descripción). El método debe validar si existe dicha cita y si no es así lanzar una excepción.
//DELETE /citas/{id}/
//Elimina una cita dado su id, devolviendo un 204 en caso de éxito. El método debe validar si existe dicha cita y si no es así lanzar una excepción.
//
//La API debe ser implementada en JAVA usando Spring Boot y se le dará la opción de usar cualquier librería externa (como Lombok) que te permita el desarrollo más sencillo. También se puede usar Postman para probar las llamadas a la API y los parámetros enviados.
//
//El código debe ser entregado en formato zip con el nombre citas-api.zip, incluyendo el código fuente de tu aplicación (el package main debes llamarlo citas-api) más un archivo README.md que explique cómo se ejecuta la aplicación y su funcionamiento.
//
//¡Buena suerte!
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import java.util.*;

@SpringBootApplication
public class CitasApiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CitasApiApplication.class, args);

        // Print the message with Spring Boot Logo to show that we're ready :)
        LoggerFactory.getLogger(ctx.getClass()).info("⚡️⚡️ CITAS API Ready! ⚡️⚡️");
    }
}

@Controller
class RestApi {
    private final List<Cita> citas;
    @Autowired
    public RestApi(List<Cita> citas) {
        this.citas = citas;
    }

    @GetMapping("/citas")
    ResponseEntity<Object> listarCitas() {
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @PostMapping("/citas")
    ResponseEntity<String> crearCita(@RequestBody Cita cita) {
        citas.add(cita);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @GetMapping("/citas/{id}")
    public ResponseEntity<Object> obtenerCita(@PathVariable Integer id) {
        Optional<Cita> cita = citas.stream().filter(cita1 -> cita1.getId() == id).findFirst();
        if (cita.isPresent()) {
            return new ResponseEntity<>(cita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la cita", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/citas/{id}")
    public ResponseEntity<Object> actualizarCita(@PathVariable Integer id, @RequestBody Cita cita) {
        Optional<Cita> citaActual = citas.stream().filter(cita1 -> cita1.getId() == id).findFirst();
        if (citaActual.isPresent()) {
            cita.setId(id);
            citas.remove(citaActual.get());
            citas.add(cita);
            return new ResponseEntity<>(citas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la cita", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/citas/{id}")
    public ResponseEntity<Object> eliminarCita(@PathVariable Integer id) {
        Optional<Cita> cita = citas.stream().filter(cita1 -> cita1.getId() == id).findFirst();
        if (cita.isPresent()) {
            citas.remove(cita.get());
            return new ResponseEntity<>("{}", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe la cita", HttpStatus.NOT_FOUND);
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"id"})
class Cita {
    private Integer id;
    private String nombre;
    private String descripcion;

    public Cita() {}

    public Cita(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

@JsonIgnoreProperties({"id"})
class CitaDTO {
    private Integer id;
    private String nombre;
    private String descripcion;

    public CitaDTO() {}

    public CitaDTO(Cita c) {
        this.nombre = c.getNombre();
        this.descripcion = c.getDescripcion();
    }
}
@JsonIgnoreProperties({"id"})
class CitaDTOComplete {
    private Integer id;
    private String nombre;
    private String descripcion;

    public CitaDTOComplete() {}

    public CitaDTOComplete(Cita c) {
        this.nombre = c.getNombre();
        this.descripcion = c.getDescripcion();
    }
}

@JsonIgnoreProperties({"id"})
class CitaUpdate {
    private String nombre;
    private String descripcion;

    public CitaUpdate() {}

    public CitaUpdate(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

class CitaComplete implements CommandLineRunner {
    private final List<Cita> citas;
    @Autowired
    public CitaComplete(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<3; i++) {
            citas.add(new Cita("Cita "+i, "Descripcion "+i));
        }
    }
}

class CitaDTOCompleteImpl implements CommandLineRunner {
    private final List<Cita> citas;
    @Autowired
    public CitaDTOCompleteImpl(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<3; i++) {
            CitaDTOComplete cdc = new CitaDTOComplete();
            cdc.setNombre("Cita "+i);
            cdc.setDescripcion("Descripcion " + i);
            System.out.println(cdc.getNombre());
        }
    }
}

class CitaDTOImpl implements CommandLineRunner {
    private final List<Cita> citas;
    @Autowired
    public CitaDTOImpl(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<3; i++) {
            CitaDTO cdc = new CitaDTO();
            cdc.setNombre("Cita "+i);
            cdc.setDescripcion("Descripcion " + i);
            System.out.println(cdc.getNombre());
        }
    }
}

class CitaUpdateImpl implements CommandLineRunner {
    private final List<Cita> citas;
    @Autowired
    public CitaUpdateImpl(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<3; i++) {
            CitaUpdate cdc = new CitaUpdate();
            cdc.setNombre("Cita "+i);
            cdc.setDescripcion("Descripcion " + i);
            System.out.println(cdc.getNombre());
        }
    }
}

class CitaDTOCompleteImpl2 implements CommandLineRunner {
    private final List<Cita> citas;
    @Autowired
    public CitaDTOCompleteImpl2(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<3; i++) {
            CitaDTOComplete cdc = new CitaDTOComplete();
            cdc.setNombre("Cita "+i);
            cdc.setDescripcion("Descripcion " + i);
            System.out.println(cdc.getNombre());
        }
    }
}

class CitaDTOImpl2 implements CommandLineRunner {
    private final List<Cita> citas;
    @Autowired
    public CitaDTOImpl2(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<3; i++) {
            CitaDTO cdc = new CitaDTO();
            cdc.setNombre("Cita "+i);
            cdc.setDescripcion("Descripcion " + i);
            System.out.println(cdc.getNombre());
        }
    }
}

class CitaUpdateImpl2 implements CommandLineRunner {
    private final List<Cita> citas;
    @Autowired
    public CitaUpdateImpl2(List<Cita> citas) {
        this.citas = citas;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<3; i++) {
            CitaUpdate cdc = new C