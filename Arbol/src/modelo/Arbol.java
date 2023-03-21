package modelo;

import java.util.Stack;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Nodo haciendArbol(String expresion) {
        Stack<Nodo> pila;
        pila = new Stack<>();

        String elements[] = expresion.split("");

        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            Nodo actNodo = new Nodo(element);
            if (esOperando(element)) {
                Nodo derecho = pila.pop();
                Nodo izquierdo = pila.pop();
                actNodo.setLeft(izquierdo);
                actNodo.setRigth(derecho);

            }
            pila.push(actNodo);
        }
        this.raiz = pila.peek();
        return this.raiz;
    }

    private boolean esOperando(String element) {
        return element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/") || element.equals("^");
    }

    public void PreOrden(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            recorrido.append(nodo.getValor()).append(" ");
            PreOrden(nodo.getLeft(), recorrido);
            PreOrden(nodo.getRigth(), recorrido);
        }
    }

    public void InOrden(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            InOrden(nodo.getLeft(), recorrido);
            recorrido.append(nodo.getValor()).append(" ");
            InOrden(nodo.getRigth(), recorrido);
        }
    }

    public void PostOrden(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            PostOrden(nodo.getLeft(), recorrido);
            PostOrden(nodo.getRigth(), recorrido);
            recorrido.append(nodo.getValor()).append(" ");

        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    

}
