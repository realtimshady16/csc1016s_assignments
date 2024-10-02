public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double length, double width, String colour, boolean filled){
        super(colour, filled);
        this.height = length;
        this.width = width;
    }

    public Rectangle(){
        super("white", false);
        this.height = 0.00;
        this.width = 0.00;
    }
    public Rectangle(double height, double width){
        super("white", false);
        this.height = height;
        this.width = width;
    }
    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getHeight(){
        return this.height;
    }
    public double getArea(){
        return this.height * this.width;
    }
    public double getPerimeter(){
        return this.height * 2 + this.width * 2;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public boolean equals(Rectangle rectangle){
        return this.height == rectangle.getHeight() && this.width == rectangle.getWidth() && super.equals(rectangle);
    }
    @Override
    public String toString(){
        return super.toString() + " Height " + Double.toString(this.height) + " " + "Width" + " " + Double.toString(this.width);
    }
}
