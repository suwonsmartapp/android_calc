package com.suwonsmartapp.calc.util;

/**
 * Created by junsuk on 2015. 10. 6..
 */
public class Node {
    private String data;
    private Node nextNode;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }
}
