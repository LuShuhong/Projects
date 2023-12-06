package wk02;

public abstract class RectangleShape implements Shape{
        private String shape = "Rectangle";
        private double length=40;
        private double width=30;


        public String getShape() {
            return shape;
        }

        public double getArea(){
            return length*width;
        }
    }


