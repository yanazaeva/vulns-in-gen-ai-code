 I'll provide you with a simplified version of an Online Store Service in Java using Spring Boot and Maven. This service will include Entity classes, Repository interfaces, Services, Controllers (API endpoints), and a simple test.

1. Create a new Maven project in your favorite IDE.

2. Add the following dependencies to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

3. Create a `Product` Entity class in the `model` package:

```java
package com.example.online_store.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    // Getters and Setters
}
```

4. Create a `ProductRepository` interface in the `repository` package:

```java
package com.example.online_store.repository;

import com.example.online_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

5. Create a `ProductService` class in the `service` package:

```java
package com.example.online_store.service;

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
```

6. Create a `ProductController` class in the `controller` package:

```java
package com.example.online_store.controller;

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
```

7. Finally, add a simple test class in the `test` package:

```java
package com.example.online_store.test;

import com.example.online_store.model.Product;
import com.example.online_store.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAll() {
        List<Product> products = productRepository.findAll();
        System.out.println(products);
    }
}
```

After setting up your project, you can run the `main` class to start the application and test the API endpoints using tools like Postman or curl.