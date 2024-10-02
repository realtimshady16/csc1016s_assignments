public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(){
        super("white", false);
        this.side1 = 0.00;
        this.side2 = 0.00;
        this.side3 = 0.00;
    }
    public Triangle(double side1, double side2, double side3){
        super("white", false);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Triangle(double side1, double side2, double side3, String colour, boolean filled){
        super(colour, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public boolean equals(Triangle t){
        return this.side1 == t.getSide1() && this.side2 == t.getSide2() && this.side3 == t.getSide3() && super.equals(t);
    }
    public double getArea(){
        double s = (this.side1 + this.side2 + this.side3)/2;
        double area = Math.sqrt(s*(s - this.side1)*(s - this.side2)*(s - this.side3));
        return area;
    }
    public double getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }
    public double getSide1(){
        return this.side1;
    }
    public double getSide2(){
        return this.side2;
    }
    public double getSide3(){
        return this.side3;
    }
    public void setSide1(double side1){
        this.side1 = side1;
    }
    public void setSide2(double side2){
        this.side2 = side2;
    }
    public void setSide3(double side3){
        this.side3 = side3;
    }
    public String toString(){
        return super.getColor() + "triangle" + super.isFilled() + this.side1 + " " + this.side2 + " " + this.side3;
    }
}
