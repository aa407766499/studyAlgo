package linkedlist.myimplement;

public class Cirque {

    private Node node;
    private Integer size;

    public Cirque() {

    }

    public Cirque(Node node, Integer size) {
        this.node = node;
        this.size = size;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
