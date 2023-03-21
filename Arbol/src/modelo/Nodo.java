package modelo;

 public class Nodo {
    //Atributos
    private String valor;
    private Nodo left;
    private Nodo rigth;

    /**
     * Constructor de la clase Nodo
     * @param valor Es lo que contendra el Nodo
     */
    public Nodo(String valor) {
        this.valor=valor;
        this.left=null;
        this.rigth=null;
    }

    //Getters y Setters
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public Nodo getRigth() {
        return rigth;
    }

    public void setRigth(Nodo rigth) {
        this.rigth = rigth;
    }

}



