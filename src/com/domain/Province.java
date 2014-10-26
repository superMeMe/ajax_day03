package com.domain;

/**
 * Created by etund on 2014/9/21.
 */
public class Province  {
        private String name;
        private String zipcode;

    public  Province(){

    }

    public Province(String name,String zipcode){
        this.name = name;
        this.zipcode = zipcode;
    }

    public String getName() {
        return name;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
