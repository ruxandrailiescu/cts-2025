import java.util.*;

interface Shape2D {
    Double calculateArea();
}

interface Shape3D extends Shape2D {
    Double calculateVolume();
}

class Sphere implements Shape3D {
    Double radius;

    public Sphere(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return 4 * Math.PI * this.radius * this.radius;
    }

    @Override
    public Double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
    }
}

class SquarePyramid implements Shape3D {
    Double baseLength;
    Double height;

    public SquarePyramid(Double baseLength, Double height) {
        this.height = height;
        this.baseLength = baseLength;
    }

    @Override
    public Double calculateArea() {
        Double inner = Math.pow(this.baseLength / 2, 2) + Math.pow(this.height, 2);
        return this.baseLength * this.baseLength + 2 * this.baseLength * Math.sqrt(inner);
    }

    @Override
    public Double calculateVolume() {
        return (this.baseLength * this.baseLength * this.height) / 3;
    }


}

class Square implements Shape2D {
    Double length;

    public Square(Double length) {
        this.length = length;
    }

    @Override
    public Double calculateArea() {
        return this.length * this.length;
    }
}

class Circle implements Shape2D {
    Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }
}

public class LSP {
    public void showcaseAreas(List<Shape2D> shapes) {
        for (Shape2D s : shapes)
            System.out.println("Area: " + s.calculateArea());
    }

    public void showcaseVolumes(List<Shape3D> shapes) {
        for (Shape3D s : shapes)
            System.out.println("Volume: " + s.calculateVolume());
    }
}

