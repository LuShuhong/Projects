package wk02;

public abstract class RectangleShape implements Shape{
        private String shape = "Rectangle";
        private double length;
        private double width;

        public RectangleShape(double length, double width){
            this.length = length;
            this.width = width;
        }

        public String getShape() {
            return shape;
        }

        public double getArea(){
            return length*width;
        }
    }


