package model;

public class Node {

    private Citizen value;
    private Node izquierda;
    private Node derecha;

    public Node(Citizen value){
        this.value = value;
    }

    public void setValue(Citizen value) {
        this.value = value;
    }

    public Citizen getValue(){
        return this.value;
    }

    public Node getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Node izquierda) {
        this.izquierda = izquierda;
    }

    public Node getDerecha() {
        return derecha;
    }

    public void setDerecha(Node derecha) {
        this.derecha = derecha;
    }
}
