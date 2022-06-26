package com.arash.Structural.Adapter;

import com.arash.Structural.Adapter.arashFilters.Caramel;

public class CaramelFilter implements Filter {
    private Caramel caramel;
    public CaramelFilter(Caramel caramel) {
        this.caramel = caramel;
    }
    public void apply(Image image) {
        caramel.init();
        caramel.render(image);
    }
}
