//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    class Rectangle{
        private double width;
        private double height;

        public Rectangle(double x, double y) {
            width = x;
            height = y;
        }

        public double area() {
            return width * height;
        }
    }

    class Car{
        public double miles;
        public String model;
        public int year;
        public String color;

        double getTotalMiles(){
            return miles;
        }

        double milesToKm(){
            return (miles*1.609);
        }
    }



    Rectangle rect1 = new Rectangle(3.0,5.0);
    System.out.println("Rectangle area: " + rect1.area());
}
