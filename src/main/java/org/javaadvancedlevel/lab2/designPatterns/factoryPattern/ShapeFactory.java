package org.javaadvancedlevel.lab2.designPatterns.factoryPattern;

class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else
        {
            throw new IllegalArgumentException("Invalid shape type");
        }
    }

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("CIRCLE");
        shape3.draw();
    }
}
