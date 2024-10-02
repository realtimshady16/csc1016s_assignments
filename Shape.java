public class Shape {
    private boolean filled;
    private String colour;

    public Shape(String colour, boolean filled){
        this.filled = filled;
        this.colour = colour;
    }
    public Shape(){
        this.filled = false;
        this.colour = "white";
    }
    public String getColor(){
        return this.colour;
    }
    public void setColor(String colour){
        this.colour = colour;
    }
    public double getArea(){
        return 0.00;
    }
    public double getPerimeter(){
        return 0.00;
    }
    public void setFilled(boolean b){
        this.filled = b;
    }
    public boolean isFilled(){
        return this.filled;
    }
    public boolean equals(Shape s){
        return this.colour == s.getColor() && this.filled == s.isFilled();
    }
    public String toString(){
        return "Shape";
    }
    // public String toString(){
    //     return this.name + " " + this.colour;
    // }
}
