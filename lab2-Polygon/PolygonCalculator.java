import java.util.Scanner;

interface Polygon 
{
    double area();
    double perimeter();
}


class Triangle implements Polygon 
{
    protected double a, b, c;

    public Triangle(double a, double b, double c) 
  {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double perimeter() 
  {
        return a + b + c;
    }

    public double area() 
  {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

class IsoscelesTriangle extends Triangle 
{
    public IsoscelesTriangle(double equalSide, double base) 
  {
        super(equalSide, equalSide, base);
    }
}

class EquilateralTriangle extends IsoscelesTriangle 
{
    public EquilateralTriangle(double side) 
  {
        super(side, side);
    }

    @Override
    public double area() 
  {
        return (Math.sqrt(3) / 4) * a * a;
    }
}


class Quadrilateral implements Polygon 
{
    public double area() 
    { 
      return 0; 
    }
    public double perimeter() 
    { 
      return 0; 
    }
}

class Rectangle extends Quadrilateral 
{
    protected double length, width;

    public Rectangle(double l, double w) 
  {
        length = l;
        width = w;
    }

    public double area() 
  {
        return length * width;
    }

    public double perimeter() 
  {
        return 2 * (length + width);
    }
}

class Square extends Rectangle
  {
    public Square(double side) 
    {
        super(side, side);
    }
}


class RegularPolygon implements Polygon {
    private int sides;
    private double side;

    public RegularPolygon(int sides, double side) 
  {
        this.sides = sides;
        this.side = side;
    }

    public double perimeter() 
  {
        return sides * side;
    }

    public double area() 
  {
        return (sides * side * side) / (4 * Math.tan(Math.PI / sides));
    }
}

class Pentagon extends RegularPolygon 
{
    public Pentagon(double s) 
    { 
      super(5, s); 
    }
}

class Hexagon extends RegularPolygon 
{
    public Hexagon(double s) 
    { 
      super(6, s);
    }
}

class Octagon extends RegularPolygon 
{
    public Octagon(double s) 
    { 
      super(8, s);
    }
}


public class PolygonCalculator 
{
    public static void main(String[] args) 
  {
        Scanner sc = new Scanner(System.in);
        Polygon p;

        System.out.println("Choose a shape:");
        System.out.println("1 Triangle");
        System.out.println("2 Isosceles Triangle");
        System.out.println("3 Equilateral Triangle");
        System.out.println("4 Rectangle");
        System.out.println("5 Square");
        System.out.println("6 Pentagon");
        System.out.println("7 Hexagon");
        System.out.println("8 Octagon");

        int choice = sc.nextInt();

        if (choice == 1) 
        {
            System.out.print("Enter 3 sides: ");
            p = new Triangle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        
        } 
        else if (choice == 2) 
        {
            System.out.print("Enter equal side and base: ");
            p = new IsoscelesTriangle(sc.nextDouble(), sc.nextDouble());
        
        } 
        else if (choice == 3) 
        {
            System.out.print("Enter side: ");
            p = new EquilateralTriangle(sc.nextDouble());
        
        } 
        else if (choice == 4) 
        {
            System.out.print("Enter length and width: ");
            p = new Rectangle(sc.nextDouble(), sc.nextDouble());
        
        } 
        else if (choice == 5) 
        {
            System.out.print("Enter side: ");
            p = new Square(sc.nextDouble());
        
        } 
        else if (choice == 6) 
        {
            System.out.print("Enter side: ");
            p = new Pentagon(sc.nextDouble());
        
        } 
        else if (choice == 7) 
        {
            System.out.print("Enter side: ");
            p = new Hexagon(sc.nextDouble());
        
        } 
        else if (choice == 8) 
        {
            System.out.print("Enter side: ");
            p = new Octagon(sc.nextDouble());
        
        } 
        else 
        {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }


        System.out.println("Perimeter: " + p.perimeter());
        System.out.println("Area: " + p.area());

        sc.close();
    }
}
