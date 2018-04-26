package com.newoneplus.dresshub.Controller;


import com.newoneplus.dresshub.Model.Product;
import com.newoneplus.dresshub.Model.ProductImage;
import com.newoneplus.dresshub.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String insert(Product product){
        String filename = "";
        // 첨부파일(상품사진)이 있으면
        if(!product.getImage().isEmpty()){
            for(int i =0; i<product.getImage().size(); i++){
                filename = product.getImage().get(i).getOriginalFilename();
                // 개발디렉토리 - 파일 업로드 경로
                //String path = "C:\\Users\\doubles\\Desktop\\workspace\\gitSpring\\"
                //                + "spring02\\src\\main\\webapp\\WEB-INF\\views\\images";
                // 배포디렉토리 - 파일 업로드 경로
                String path = "C:\\workspace\\project\\DressHub\\DressHub\\src\\main\\resources\\static\\image\\";
                try {
                    new File(path).mkdirs(); // 디렉토리 생성
                    // 임시디렉토리(서버)에 저장된 파일을 지정된 디렉토리로 전송
                    product.getImage().get(i).transferTo(new File(path+filename));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                ProductImage productImage = new ProductImage();
                productImage.setProductId(product.getId());
                if(i==0){
                    product.setThumbnailImage(filename);
                }
                productImage.setImage(filename);
                productImage.setImageSize("null");//size는 아직 결정안됨
                productService.insertProductImage(productImage);
            }
            productService.insertProduct(product);
        }
        return "redirect:/shop/product/list.do";
    }
}