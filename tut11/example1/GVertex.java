package DSA.tut11.example1;

public class GVertex {
    private char label;
    private char color;
    public GVertex(char label) {
        this.label=label;
        color='B';
    }

    public char getLabel() {
        return this.label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public char getColor() {
        return this.color;
    }

    public void setColor(char color) {
        this.color = color;
    }
}