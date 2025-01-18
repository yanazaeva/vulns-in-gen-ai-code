package OnlineStore.online.store.src.main.java.v1.mistral.english.java.online.store;

import com.example.online_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
