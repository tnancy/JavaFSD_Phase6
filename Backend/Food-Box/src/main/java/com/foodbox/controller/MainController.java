package com.foodbox.controller;

import com.foodbox.model.Product;
import com.foodbox.model.User;
import com.foodbox.service.AuthService;
import com.foodbox.service.ProductService;
import com.foodbox.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MainController {
    private final ProductService productService;
    private final AuthService authService;
    private final UserService userService;

    public MainController(@Autowired ProductService productService, AuthService authService, UserService userService) {
        this.productService = productService;
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("")
    public String healthCheck() {
        return "Food Box Application is running !!";
    }

    @GetMapping("/menu")
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @PostMapping("/addMenu")
    public Product addProduct(@RequestHeader String Authorization, @RequestBody Product product) {
        authService.authenticate(Authorization);
        return productService.add(product);
    }
    
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
    	System.out.println("reached");
        return userService.add(user);
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<?> deleteProduct(@RequestHeader String Authorization, @PathVariable int id) {
        authService.authenticate(Authorization);
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
//	@GetMapping("/menu/{cuisine}")
//	public List<Product> findByCuisine(@PathVariable String cuisine)
//	{
//		return (List<Product>) productService.getProductByCuisine(cuisine);
//	}
    
    @GetMapping("/login")
    public User handleLogin(@RequestHeader String Authorization) {
        return authService.authenticate(Authorization);
    }

    @PostMapping("/changepass")
    public ResponseEntity<?> changePassword(@RequestHeader String Authorization, @RequestBody Map<String, String> rMap) {
        authService.authenticate(Authorization);
        this.userService.changePassword(rMap.get("username"), rMap.get("password"));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
