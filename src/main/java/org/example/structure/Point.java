package org.example.structure;

public record Point(int x, int y) {

    public double dist() {
        return Math.sqrt(x*x + y*y);
    }

}
