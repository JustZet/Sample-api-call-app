package com.example.displayuser.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {
    int page;

    @SerializedName("per_page")
    int perPage;

    int total;

    @SerializedName("total_pages")
    int totalPages;

    List<User> data;

    Support support;

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<User> getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }
}
