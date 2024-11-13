package DSA.tut11.example2;

public class GALVertex
{
    private char label;
    private char color;
    private SLList adjList;
    /**
     * Constructor for objects of class GVertex
     */
    public GALVertex(char label)
    {
        this.label=label;
        color='B';
        adjList=new SLList();
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

    public void addToAdjList(int vertex)
    {
        SLNode newAdjVertex=new SLNode(vertex);
        adjList.add(newAdjVertex);
    }

    public SLList getAdjList() {
        return this.adjList;
    }
}

