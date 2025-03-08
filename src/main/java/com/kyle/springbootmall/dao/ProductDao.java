package com.kyle.springbootmall.dao;

import com.kyle.springbootmall.constant.ProductCategory;
import com.kyle.springbootmall.dto.ProductRequest;
import com.kyle.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
