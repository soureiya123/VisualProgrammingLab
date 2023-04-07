package com.example.fourthsemester;

import java.math.BigDecimal;

public class ItemSearchModel {

    Integer iditems;
    String name;
    BigDecimal weight;
    BigDecimal price;

    public ItemSearchModel(Integer iditems, String name, BigDecimal weight, BigDecimal price) {
        this.iditems = iditems;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Integer getIditems() {
        return iditems;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setIditems(Integer iditems) {
        this.iditems = iditems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}




/*package com.example.fourthsemester;

import java.math.BigDecimal;

public class ItemSearchModel {

    int itemId;
    int iditems;
    int idCategory;
    String name;
    BigDecimal weight;
    BigDecimal price;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public ItemSearchModel(int itemId, String name, BigDecimal weight, BigDecimal price) {
        this.itemId = itemId;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public ItemSearchModel(int iditems, int idCategory, String name, BigDecimal weight, BigDecimal price) {
        this.iditems = iditems;
        this.idCategory = idCategory;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public ItemSearchModel(String name, BigDecimal weight, BigDecimal price) {
        this.name = name;
        this.weight = weight;
        this.price = price;

    }

    public ItemSearchModel( String name, BigDecimal weight, BigDecimal price,Integer iditems) {

        this.name = name;
        this.weight = weight;
        this.price = price;
        this.iditems=iditems;
    }

    public int getId() {
        return iditems;
    }

    public void setId(int id) {
        this.iditems = iditems;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /*

    String name;
   String weight;
   String price;


  public ItemSearchModel(String name, String weight, String price) {

        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getPrice() {
        return price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPrice(String price) {
        this.price = price;
    }




}
*/