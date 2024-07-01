package cse2010.hw3;

/*
 * © 2024 CSE2010 HW #3
 *
 * DO NOT MODIFY THIS CLASS!
 */
public class Node<T> {
    private T info;
    private Node<T> next;
    private Node<T> prev;

    Node(T info) {
        this(info, null, null);
    }

    Node(T info, Node<T> prev, Node<T> next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    T getInfo() {
        return info;
    }

    void setInfo(T info) {
        this.info = info;
    }

    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> n) {
        next = n;
    }

    Node<T> getPrev() {
        return prev;
    }

    void setPrev(Node<T> p) {
        prev = p;
    }

    @Override public String toString() {
        return "Node{" +
                "info=" + info +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
