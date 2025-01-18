import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}