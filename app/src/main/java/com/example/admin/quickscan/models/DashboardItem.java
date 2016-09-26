package com.example.admin.quickscan.models;

/**
 * Created by ADMIN on 24-01-2016.
 */
public class DashboardItem {
    private String ItemName;
    private int ItemImageUrl,ResortId;

    public DashboardItem(String itemName, int itemImageUrl, int resortId) {
        ItemName = itemName;
        ItemImageUrl = itemImageUrl;
        ResortId = resortId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemImageUrl() {
        return ItemImageUrl;
    }

    public void setItemImageUrl(int itemImageUrl) {
        ItemImageUrl = itemImageUrl;
    }

    public int getResortId() {
        return ResortId;
    }

    public void setResortId(int resortId) {
        ResortId = resortId;
    }
}
