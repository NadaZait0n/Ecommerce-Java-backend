package com.project.api;


import com.project.database.Entities.Product;
import com.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product>FindAll(){
        return productService.FindAll();
    }
    @GetMapping("/{id}")
    public Optional <Product>FindById(@PathVariable int id){
       return productService.FindById(id);
    }


    @PostMapping
    public void insert(@RequestBody Product product ){
        productService.insert(product);
    }


//    @PostMapping( consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public Product insert(@RequestPart("product") Product product ,
//                       @RequestPart("imageFile")MultipartFile [] file){
//        try {
//            Set<Image> images = productService.UploadImage(file);
//            product.setProductImage(images);
//            return  productService.insert(product);
//        }catch (Exception e){
//            System.out.println( e.getMessage());
//            return  null;
//        }
//    }



//    @PutMapping
//    public void update(@RequestBody Product product){
//        productService.update(product);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }

}
