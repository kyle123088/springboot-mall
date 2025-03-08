package com.kyle.springbootmall.service;

import com.kyle.springbootmall.dto.ProductQueryParams;
import com.kyle.springbootmall.dto.ProductRequest;
import com.kyle.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
