package DSA.tut10;

class ETNode {
    String value;
    ETNode left;
    ETNode right;

    public ETNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ETNode getRight() {
        return this.right;
    }

    public void setRight(ETNode right) {
        this.right = right;
    }

    public ETNode getLeft() {
        return this.left;
    }

    public void setLeft(ETNode left) {
        this.left = left;
    }
}
