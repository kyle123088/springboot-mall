package com.kyle.springbootmall.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

// 這個 class 對應到前端傳過來的 json object
public class CreateOrderRequest {

    @NotEmpty
    private List<BuyItem> buyItemList;

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
