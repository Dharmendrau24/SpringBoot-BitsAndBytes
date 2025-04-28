package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    @GetMapping
    //getProduct
    public List<ProductDTO> getAllProducts(){
       return productService.getAllProducts();
    }
    //createProduct
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
     ProductDTO createdProduct = productService.createProduct(productDTO);
     return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    //update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id ,@RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }
    // get product by id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    // delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
       return productService.deleteProduct(id);
    }
}
