package model;

public class BST {

    private Node raiz;

    public void agregar(Citizen citizen) {
        if (this.raiz == null) {
            this.raiz = new Node(citizen);
        } else {
            this.agregar(this.raiz, citizen);
        }
    }

    private void agregar(Node current, Citizen citizen){

        if(citizen.compareTo(current.getValue()) > 0){
            if (current.getDerecha() == null) {
                current.setDerecha(new Node(citizen));
            } else {
                this.agregar(current.getDerecha(), citizen);
            }
        }else {
            if (current.getIzquierda() == null) {
                current.setIzquierda(new Node(citizen));
            } else {
                this.agregar(current.getIzquierda(), citizen);
            }
        }

    }

    public Citizen buscar(String cedula) {
        return buscar(this.raiz, cedula);
    }

    private Citizen buscar(Node current, String cedula){

        if(current == null){
            return  null;
        }

        if(cedula.compareTo(current.getValue().getCedula()) == 0){
            return current.getValue();
        }else if(cedula.compareTo(current.getValue().getCedula()) < 0){
            return buscar(current.getIzquierda(), cedula);
        }else{
            return buscar(current.getDerecha(), cedula);
        }

    }

    private int nivelesBusqueda(Node current, String cedula, int niveles){


        if(current == null){
            return  niveles + 1;
        }

        if(cedula.compareTo(current.getValue().getCedula()) == 0){
            return niveles + 1;
        }else if(cedula.compareTo(current.getValue().getCedula()) < 0){
            return nivelesBusqueda(current.getIzquierda(), cedula , niveles + 1);
        }else{
            return nivelesBusqueda(current.getIzquierda(), cedula , niveles + 1);
        }
    }

    public int nivelesBusqueda(String cedula){
        return nivelesBusqueda(this.raiz, cedula, 0);
    }


    public void borrar(String cedula) {
        borrar(this.raiz, cedula);
    }

    private Node borrar(Node current, String cedula){

        if(current == null){
            return null;
        }

        if(current.getValue().getCedula().compareTo(cedula) == 0){
            //1. Nodo Hoja
            if(current.getIzquierda() == null && current.getDerecha() == null){
                if(current == raiz){
                    raiz = null;
                }
                return null;
            }
            //2. Nodo solo hijo izquierdo
            else if (current.getDerecha() == null){
                return current.getIzquierda();
            }
            //3. Nodo solo hijo derecho
            else if(current.getIzquierda() == null){
                return current.getDerecha();
            }
            //4. Nodo con dos hijos
            else{
                Node sucesor = getSucesor(current.getDerecha());
                //Transferencia de valores, NUNCA de conexiones
                current.setValue(sucesor.getValue());
                //Hacer eliminación a partir de la derecha
                Node subarbolDER = borrar(current.getDerecha(), sucesor.getValue().getCedula());
                current.setDerecha( subarbolDER );
                return current;
            }

            // avanzamos en el arbol buscando el dato
        }else if(cedula.compareTo(current.getValue().getCedula()) < 0){
            Node subArbolIzquierdo = borrar(current.getIzquierda(), cedula);
            current.setIzquierda(subArbolIzquierdo);
            return current;
        }else{
            Node subArbolDerecho = borrar(current.getDerecha(),cedula);
            current.setDerecha(subArbolDerecho);
            return current;
        }

    }


    public Node getSucesor(Node current){
        if(current.getIzquierda() == null){
            return current;
        }
        return getSucesor(current.getIzquierda());
    }
}
