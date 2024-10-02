public class Circle extends Shape{
    private double radius;
    
    public Circle(double radius, String colour, boolean filled){
        super(colour, filled);
        this.radius = radius;
    }

    public Circle(){
        super("white", false);
        this.radius = 0.00;
    }
    public Circle(double radius){
        super("white", false);
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public boolean equals(Circle c){
        return this.radius == c.getRadius() && super.equals(c);
    }
    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public String toString(){
        return super.toString() + " " + "Radius" + " " + Double.toString(radius);
    }
}
