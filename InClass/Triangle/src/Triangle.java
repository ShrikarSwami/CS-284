public class triangle extends Shape implements ShapeInterface{
    public String name;
    public  triangle(int code, String description){
        super(code, description);
        this.name = "Triangle";
    }
    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public int getOffset() {
        return 0;
    }

    @Override
    public void colorShape(String color) {

    }

    public String toString(){
        return name;
    }
}

