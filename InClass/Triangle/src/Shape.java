public class Shape {
    protected int code;
    protected String description;
    protected int offset;

    public Shape(int code, String description){
        this.code = code;
        this.description = description;
    }

    public Shape(){
        this.code = -1;
        this.description = "Just a shape";
    }

    public String toString(){
        return code + " " + description;
    }

}

