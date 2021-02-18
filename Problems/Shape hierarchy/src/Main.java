abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape
{
    private double a, b, c;
    Triangle(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter()
    {
        return a+b+c;
    }

    @Override
    double getArea()
    {
        double s = 0.5 * (a + b + c);
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

class Rectangle extends Shape
{
    private double length, breadth;
    Rectangle(double a, double b)
    {
        length = a;
        breadth = b;
    }

    @Override
    double getPerimeter()
    {
        return 2 * (length + breadth);
    }

    @Override
    double getArea()
    {
        return length * breadth;
    }
}

class Circle extends Shape
{
    private double radius;
    Circle(double r)
    {
        radius = r;
    }

    @Override
    double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    double getArea()
    {
        return Math.PI * radius * radius;
    }
}