package com.kyle.springbootmall.service;

import com.kyle.springbootmall.dto.ProductRequest;
import com.kyle.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
}
