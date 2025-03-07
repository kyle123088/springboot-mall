package com.kyle.springbootmall.service.impl;

import com.kyle.springbootmall.dao.ProductDao;
import com.kyle.springbootmall.dto.ProductRequest;
import com.kyle.springbootmall.model.Product;
import com.kyle.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
