package com.arash.Structural.FlyWehight;

public class MainMethod {
    public static void main(String[] args) {
        var service = new PointService(new PointIconFactory());

        for(var point : service.getPoints()) {
            point.draw();
        }
    }
}
