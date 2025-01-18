¡Claro! Aquí está un ejemplo básico de cómo podría verse una aplicación Java de tienda online con una API REST propia:

1. **Modelos (Entidades):**

```java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;

    // Getters y Setters
}

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String contraseña;

    // Getters y Setters
}
```

2. **Repositorios (DAOs):**

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
```

3. **Servicios:**

```java
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Métodos para crear, obtener, actualizar y eliminar productos
}
```

4. **Controladores (APIs):**

```java
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Definir métodos para las operaciones CRUD a través de la API REST
}
```

5. **Aplicación principal:**

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
```

Para completar la aplicación, es necesario agregar las dependencias correspondientes al proyecto Maven o Gradle y configurar la base de datos que se utilizará para almacenar los productos.