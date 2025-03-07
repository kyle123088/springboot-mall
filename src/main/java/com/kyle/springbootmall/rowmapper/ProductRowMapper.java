package com.kyle.springbootmall.rowmapper;

import com.kyle.springbootmall.constant.ProductCategory;
import com.kyle.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

        // 取得資料庫 category 欄位的值，並儲存在 categoryStr
        String categoryStr = resultSet.getString("category");
        // 字串轉換為 Enum 類型
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        // 傳入方法裡面
        product.setCategory(category);
        // product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));

        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreateDate(resultSet.getTimestamp("created_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return product;
    }
}
