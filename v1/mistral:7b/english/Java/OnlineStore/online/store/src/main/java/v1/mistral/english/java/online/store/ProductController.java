package OnlineStore.online.store.src.main.java.v1.mistral.english.java.online.store;

import com.example.online_store.model.Product;
import com.example.online_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    // Add additional methods like create, update, delete etc. if needed.
}