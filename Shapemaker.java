import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shapemaker extends JFrame{
    protected class ShapeInfo{
        private String shape;
        private String colour;
        private String fillColour;
        private String[] dimensions = new String[3];

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
        ShapeInfo shapeInfo = new ShapeInfo();
        InfoPanel infoPanel = new InfoPanel(shapeInfo);
        DrawPanel drawPanel = new DrawPanel(shapeInfo); //the drawPanel has information that infoPanel needs to get and return to be passed into the drawPanel. how do I structure this code so that the user can interact with infoPanel and said user-info can be passed into DrawPanel
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

    protected class InfoPanel extends JPanel{
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
            shapeInfo.setShape(getShape());
            shapeInfo.setColour(getColour());
            shapeInfo.setFillColour(getFillColour());
            shapeInfo.setDimensions(getDimensions());

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
                    if(yes.isSelected()) colour = "yes";
                    else if(no.isSelected()) colour = "no";
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
    protected class DrawPanel extends JPanel{
        private ShapeInfo shapeInfo;
        private JButton drawButton;
        public DrawPanel(ShapeInfo si){
            shapeInfo = si;
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
            setBorder(border);
            add(drawButton, BorderLayout.SOUTH);
            setPreferredSize(new Dimension(600, 600));
            setVisible(true);
        }
        public void paintRectangle(Graphics g){

        }
        public void paintCircle(Graphics g){

        }
        public void paintTriangle(Graphics g){
            super.paintComponent(g);

        }
    }

}
