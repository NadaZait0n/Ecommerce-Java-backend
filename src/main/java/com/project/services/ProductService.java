package com.project.services;


import com.project.database.Repository.ProductRepository;
import com.project.database.Entities.Image;
import com.project.database.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productDao;

    public List<Product>FindAll(){
        return productDao.findAll();
    }

    public Optional<Product> FindById(int id){
     return productDao.findById(id);
    }

    public Product insert (Product product){
        return productDao.save(product);
    }

//    public void update(Product product){
//        productDao.save(product);
//    }

    public void delete(int id){
        productDao.deleteById(id);
    }

//    public Set<Image> UploadImage(MultipartFile[] multipartFiles)throws IOException {
//        Set<Image> images = new HashSet<>();
//        for (MultipartFile file : multipartFiles){
//            Image image = new Image(
//                    file.getOriginalFilename(),
//                    file.getBytes()
//            );
//            images.add(image);
//        }
//        return images;
//    }
}
