package com.example.ratanakpek.volleytest.recyclervs;

/**
 * Created by RatanakPek on 11/20/2016.
 */

public class Product {
    private String name;
    private String processor;
    private String companyName;
    private String ram;

    public Product(String name, String processor, String companyName, String ram) {
        this.name = name;
        this.processor = processor;
        this.companyName = companyName;
        this.ram = ram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
