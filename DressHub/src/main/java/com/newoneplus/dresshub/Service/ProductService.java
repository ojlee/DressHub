package com.newoneplus.dresshub.Service;


import com.newoneplus.dresshub.Dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;



}
