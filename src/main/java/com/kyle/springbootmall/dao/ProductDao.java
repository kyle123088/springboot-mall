package com.kyle.springbootmall.dao;

import com.kyle.springbootmall.dto.ProductRequest;
import com.kyle.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
