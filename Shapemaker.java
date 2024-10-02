import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shapemaker extends JFrame{
    protected static class ShapeInfo{
        private String shape;
        private String colour;
        private String fillColour;
        private String[] dimensions;

        public ShapeInfo(){
            this.shape = "circle";
            this.colour = "red";
            this.fillColour = "no";
            this.dimensions = new String[3];
        }
        public String getShape(){
            return shape;
        }
        public void setShape(String s){
            shape = s;
        }
        public void setColour(String c){
            colour = c;
        }
        public void setFillColour(String fc){
            fillColour = fc;
        }
        public void setDimensions(String[] d){
            dimensions = d;
        }
        public String getColour(){
            return colour;
        }
        public String getFillColour(){
            return fillColour;
        }
        public String[] getDimensions(){
            return dimensions;
        }

    }
    public Shapemaker(String title){
        setTitle(title);
        JButton drawButton = new JButton("Draw!");
        JPanel mainPanel = new JPanel();
        //drawButton.setSize()
        DrawPanel drawPanel;
        ShapeInfo shapeInfo = new ShapeInfo();
        InfoPanel infoPanel = new InfoPanel(shapeInfo);
        //mainPanel.setLayout(new GridLayout(0, 1));
        //mainPanel.add(drawButton);
        drawPanel = new DrawPanel(shapeInfo); 
        //mainPanel.add(drawPanel);
        //drawPanel.setShapeInfo(shapeInfo);
        setLayout(new BorderLayout());
        add(drawPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);
    }
    public static void main(String [] args){
        Shapemaker maker = new Shapemaker("This is the main frame");
        maker.setSize(900, 600);
        maker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maker.setVisible(true);
    }

    protected static class InfoPanel extends JPanel{
        private String shape;
        private String colour;
        private String fillColour;
        private String[] dimensions = new String[3];
        protected ShapeInfo shapeInfo;

        public InfoPanel(ShapeInfo shapeInfo){
            setPreferredSize(new Dimension(300, 600));
            this.shapeInfo = shapeInfo;
            setLayout(new GridLayout(0, 1));
            JPanel shapePanel = createShapePanel();
            JPanel colourPanel = createColourPanel();
            JPanel fillColourPanel = createFillColourPanel();
            JPanel dimensionsPanel = createDimensionsPanel();
            add(new JLabel("Choose shape:"));
            add(shapePanel);
            add(new JLabel("Choose colour:"));
            add(colourPanel);
            add(new JLabel("Fill colour?"));
            add(fillColourPanel);
            add(new JLabel("Enter dimensions"));
            add(dimensionsPanel);
            setSize(200, 600);
            setVisible(true);
            shapeInfo.setShape(shape);//getShape());
            shapeInfo.setColour(colour);//getColour());
            shapeInfo.setFillColour(fillColour);//getFillColour());
            shapeInfo.setDimensions(dimensions);//getDimensions());

        }
        public JPanel createShapePanel(){
            JPanel shapePanel = new JPanel();
            JRadioButton tri = new JRadioButton("Triangle");
            JRadioButton rect = new JRadioButton("Rectangle");
            JRadioButton circ = new JRadioButton("Circle");
            ButtonGroup group = new ButtonGroup();
            group.add(tri);
            group.add(rect);
            group.add(circ);
            JButton setShape = new JButton("Done!");
            setShape.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(tri.isSelected()) shape = "triangle";
                    else if(rect.isSelected()) shape = "rectangle";
                    else if(circ.isSelected()) shape = "circle";
                }
            });
            shapePanel.setLayout(new FlowLayout());
            shapePanel.add(tri);
            shapePanel.add(rect);
            shapePanel.add(circ);
            shapePanel.add(setShape);
            return shapePanel;
        }
        public JPanel createColourPanel(){
            JPanel colourPanel = new JPanel();
            JRadioButton black = new JRadioButton("Black");
            JRadioButton red = new JRadioButton("Red");
            JRadioButton green = new JRadioButton("Green");
            JRadioButton blue = new JRadioButton("Blue");
            ButtonGroup group = new ButtonGroup();
            group.add(black);
            group.add(red);
            group.add(blue);
            group.add(green);
            JButton setColour = new JButton("Done!");
            setColour.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(black.isSelected()) colour = "black";
                    else if(red.isSelected()) colour = "red";
                    else if(blue.isSelected()) colour = "blue";
                    else if(green.isSelected()) colour = "green";
                }
            });
            colourPanel.setLayout(new FlowLayout());
            colourPanel.add(black);
            colourPanel.add(red);
            colourPanel.add(green);
            colourPanel.add(blue);
            colourPanel.add(setColour);
            return colourPanel;
        }
        public JPanel createFillColourPanel(){
            JPanel fillColourPanel = new JPanel();
            JRadioButton yes = new JRadioButton("Yes");
            JRadioButton no = new JRadioButton("No");
            JButton setFill = new JButton("Done!");
            ButtonGroup group = new ButtonGroup();
            group.add(yes);
            group.add(no);
            setFill.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(yes.isSelected()) colour="true";
                    else if(no.isSelected()) colour="false";
                }
            });
            fillColourPanel.setLayout(new FlowLayout());
            fillColourPanel.add(yes);
            fillColourPanel.add(no);
            fillColourPanel.add(setFill);
            return fillColourPanel;
        }
        public JPanel createDimensionsPanel(){
            JPanel dimensionPanel = new JPanel();
            JButton setDimensions = new JButton("Done!");
            JTextField dimension1 = new JTextField(6);
            dimension1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            JTextField dimension2 = new JTextField(6);
            dimension2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            JTextField dimension3 = new JTextField(6);
            dimension3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            setDimensions.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String size1 = dimension1.getText();
                    String size2 = dimension2.getText();
                    String size3 = dimension3.getText();
                    dimensions[0] = size1;
                    dimensions[1] = size2;
                    dimensions[2] = size3;
                }
            });
            dimensionPanel.setLayout(new FlowLayout());
            dimensionPanel.add(dimension1);
            dimensionPanel.add(dimension2);
            dimensionPanel.add(dimension3);
            dimensionPanel.add(setDimensions);
            return dimensionPanel;
        }
        public String getShape(){
            return shape;
        }
        public String getColour(){
            return colour;
        }
        public String getFillColour(){
            return fillColour;
        }
        public String[] getDimensions(){
            return dimensions;
        }
    }
    protected static class DrawPanel extends JPanel{
        private ShapeInfo shapeInfo;
        private JButton drawButton = new JButton("Draw!");
        public DrawPanel(ShapeInfo shapeInfo){
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
            setBorder(border);
            setLayout(new BorderLayout());
            drawButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setShapeInfo(shapeInfo);
                    repaint();
                    revalidate();
                }
            });
            add(drawButton, BorderLayout.SOUTH);
            setPreferredSize(new Dimension(600, 600));
            setEnabled(true);
            setVisible(true);
        }
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            if(shapeInfo != null){
                switch(shapeInfo.getShape().toLowerCase()){
                    case "Rectangle": paintRectangle(g2D); break;
                    case "Triangle": paintTriangle(g2D); break;
                    case "Circle": paintCircle(g2D); break;
                }
            }
        }
        private Color getColorFromString(String colorStr) {
            switch (colorStr.toLowerCase()) {
                case "red":return Color.RED;
                case "green":return Color.GREEN;
                case "blue":return Color.BLUE;
                case "black":return Color.BLACK;
                default:return Color.BLACK;
            }
        }
        public void paintRectangle(Graphics2D g2D){
            String[] dimensions = shapeInfo.getDimensions();
            Double rwidth = Double.parseDouble(dimensions[0]);
            Double rlength = Double.parseDouble(dimensions[1]);
            String colour = shapeInfo.getColour();
            Boolean fillColour = Boolean.parseBoolean(shapeInfo.getFillColour());
            Rectangle r = new Rectangle(rwidth, rlength, colour, fillColour);
            int width = getWidth();
            int height = getHeight();
            int rectX = 300;//width/2 - (int) r.getWidth()/2;
            int rectY = 500;//height/2 - (int) r.getHeight()/2;
            g2D.setColor(getColorFromString(colour));
            g2D.fillRect(rectX, rectY, (int) r.getWidth(), (int) r.getHeight());
            repaint();
            
        }
        public void paintCircle(Graphics2D g2D){
            String[] dimensions = shapeInfo.getDimensions();
            Double radius = Double.parseDouble(dimensions[0]);
            String colour = shapeInfo.getColour();
            Boolean fillColour = Boolean.parseBoolean(shapeInfo.getFillColour());
            Circle c = new Circle(radius, colour, fillColour);
            int width = getWidth();
            int height = getHeight();
            int circX = 150;//width/2 - (int) c.getRadius()/2;
            int circY = 150;//height/2 - (int) c.getRadius()/2;
            g2D.setColor(getColorFromString(colour));
            g2D.fillOval(circX, circY, (int) c.getRadius(), (int) c.getRadius());
            repaint();

        }
        public void paintTriangle(Graphics2D g2D){
            String[] dimensions = shapeInfo.getDimensions();
            Double side1 = Double.parseDouble(dimensions[0]);
            Double side2 = Double.parseDouble(dimensions[1]);
            Double side3 = Double.parseDouble(dimensions[2]);
            String colour = shapeInfo.getColour();
            Boolean fillColour = Boolean.parseBoolean(shapeInfo.getFillColour());
            Triangle t = new Triangle(side1, side2, side3, colour, fillColour);
            double angleA = Math.asin(2*t.getArea()/(t.getSide2()*t.getSide3()));
            double angleB = Math.asin(2*t.getArea()/(t.getSide1()*t.getSide3()));
            double angleC = Math.asin(2*t.getArea()/(t.getSide1()*t.getSide2()));
            int width = getWidth();
            int height = getHeight();
            double x1 = width/2;
            double y1 = height/2;
            double x2 = x1 + t.getSide2() * Math.cos(angleA);
            double y2 = y1 + t.getSide2() * Math.sin(angleA);
            double x3 = x1 + t.getSide3();
            double y3 = y1;
            int[] xPoints = {150, 250, 350};//{(int)x1, (int)x2, (int)x3};
            int[] yPoints = {150, 250, 350};//{(int)y1, (int)y2, (int)y3};
            g2D.setColor(getColorFromString(colour));
            g2D.fillPolygon(xPoints, yPoints, 3);
            repaint();
            
        }
        public void setShapeInfo(ShapeInfo si){
            shapeInfo = si;
        }
    }
    // double angleA = Math.asin(2*t.getArea()/(t.getSide2()*t.getSide3()));
    // double angleB = Math.asin(2*t.getArea()/(t.getSide1()*t.getSide3()));
    // double angleC = Math.asin(2*t.getArea()/(t.getSide1()*t.getSide2()));
    // int width = getWidth();
    // int height = getHeight();
    // int rectX = width/2 - (int) r.getWidth()/2;
    // int rectY = height/2 - (int) r.getHeight()/2;
    // int circX = width/2 - (int) c.getRadius()/2;
    // int circY = height/2 - (int) c.getRadius()/2;
    // double x1 = width/2;
    // double y1 = height/2;
    // double x2 = x1 + t.getSide2() * Math.cos(angleA);
    // double y2 = y1 + t.getSide2() * Math.sin(angleA);
    // double x3 = x1 + t.getSide3();
    // double y3 = y1;
    // int[] xPoints = {(int)x1, (int)x2, (int)x3};
    // int[] yPoints = {(int)y1, (int)y2, (int)y3};
    // g2D.setColor(Color.getColor(r.getColor()));
    // g2D.fillRect(rectX, rectY, (int) r.getWidth(), (int) r.getHeight());
    // g2D.setColor(Color.getColor(c.getColor()));
    // g2D.fillOval(circX, circY, (int) c.getRadius(), (int) c.getRadius());
    // g2D.setColor(Color.getColor(t.getColor()));
    // g2D.fillPolygon(xPoints, yPoints, 3);

}
