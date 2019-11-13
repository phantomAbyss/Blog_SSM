package com.wy.blog.domain;

public class Category {
    private int categoryId;
    private int categoryPid;
    private String categoryName;
    private String categoryDesc;
    private int categoryOrder;
    private String categoryIcon;
    private Integer childCategoryCount;
    private Integer blogCount;

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public Integer getChildCategoryCount() {
        return childCategoryCount;
    }

    public void setChildCategoryCount(Integer childCategoryCount) {
        this.childCategoryCount = childCategoryCount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryPid() {
        return categoryPid;
    }

    public void setCategoryPid(int categoryPid) {
        this.categoryPid = categoryPid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public int getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(int categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryPid=" + categoryPid +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDesc='" + categoryDesc + '\'' +
                ", categoryOrder=" + categoryOrder +
                ", categoryIcon='" + categoryIcon + '\'' +
                ", childCategoryCount=" + childCategoryCount +
                '}';
    }
}
