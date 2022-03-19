package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String creator;

    public Smartphone(int id, String name, int price, String creator) {
        super(id, name, price);
        this.creator = creator;
    }

    public Smartphone() {
        super();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return creator == that.creator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creator);
    }
}
