package OnlineStore.online.store.src.main.java.v1.mistral.english.java.online.store;

import com.example.online_store.model.Product;
import com.example.online_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    // Add additional methods like create, update, delete etc. if needed.
}
