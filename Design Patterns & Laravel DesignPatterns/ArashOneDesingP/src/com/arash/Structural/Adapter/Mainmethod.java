package com.arash.Structural.Adapter;

import com.arash.Structural.Adapter.arashFilters.Caramel;

public class Mainmethod {
    public static void main(String[] args) {
        var imageView = new ImageView(new Image());
        imageView.apply(new CaramelFilter(new Caramel()));
    }
}
