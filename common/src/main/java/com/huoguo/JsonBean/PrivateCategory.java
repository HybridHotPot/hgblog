package com.huoguo.JsonBean;

import java.util.ArrayList;

public class PrivateCategory {
    private String name;
    private int number;
    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public PrivateCategory(){}

    public PrivateCategory(String name,int number,int categoryId){
        this.name=name;
        this.number=number;
        this.categoryId=categoryId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static ArrayList<PrivateCategory> creatList(ArrayList<Integer> categoryIds,ArrayList<String> names, ArrayList<Integer> numbers) {
        ArrayList<PrivateCategory> list=new ArrayList<>();
        for(int i=0;i<names.size();i++){
            list.add(new PrivateCategory(names.get(i),numbers.get(i),categoryIds.get(i)));
        }
        return list;
    }
}
