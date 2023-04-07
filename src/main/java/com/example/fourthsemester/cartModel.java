package com.example.fourthsemester;

import java.math.BigDecimal;

public class cartModel {

    String name;
    BigDecimal weight;
    BigDecimal price;

    public cartModel(String name, BigDecimal weight, BigDecimal price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
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
//String username;


    /*  public cartModel(String name, String weight, String price) {
          this.name = name;
          this.weight = weight;
          this.price = price;
         // this.username=username;
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

      public String getUsername() {
          return username;
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

      public void setUsername(String username) {
          this.username = username;
      }



*/

  }
