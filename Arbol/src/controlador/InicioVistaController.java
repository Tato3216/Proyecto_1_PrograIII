package controlador;

import modelo.Conversor;
import modelo.Solucion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import modelo.Arbol;
import modelo.PreO;

public class InicioVistaController implements Initializable {

    @FXML
    private Button btnAceptar;
    @FXML
    private TextField txtExpresion;
    @FXML
    private TextField txtResultado;
    @FXML
    private TextField txtNotacionPostFija;
    @FXML
    private TextField txtInorden;
    @FXML
    private TextField txtPreorden;
    @FXML
    private TextField txtPostorden;

    @FXML
    private Button bntLimpiar;
    Arbol arbol = new Arbol();
    StringBuilder recorrido = new StringBuilder();
    @FXML
    private TextField txtVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
    }

    @FXML
    private void click(ActionEvent event) {
        String expresion = txtExpresion.getText();
        for (int i = 0; i < expresion.length(); i++) {
            char letra = expresion.charAt(i);
            if (Character.isLetter(letra)) {
                int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el valor de la variable: " + letra));
                expresion = expresion.substring(0, i) + numero + expresion.substring(i + 1);
            }
        }
        String resultadoPF = Conversor.conversorPFija(expresion);
        String preOrder = PreO.PreOrder(expresion);
        double resultadoDouble = Solucion.resolucion(resultadoPF);
        String resultado = String.valueOf(resultadoDouble);
        txtNotacionPostFija.setText(resultadoPF);
        txtResultado.setText(resultado);
        txtInorden.setText(expresion);
        txtPostorden.setText(resultadoPF);
        txtPreorden.setText(preOrder);

        String inversa = "\n";
        for (int i = resultadoPF.length() - 1; i >= 0; i--) {
            inversa += "\n "+resultadoPF.charAt(i)+"\n ";
        }
        txtVista.setText(inversa);
    }
        @FXML
        private void limpiar
        (ActionEvent event
        
            ) {
        this.txtExpresion.setText("");
            this.txtResultado.setText("");
            this.txtNotacionPostFija.setText("");
            this.txtPostorden.setText("");
            this.txtPreorden.setText("");
            this.txtInorden.setText("");
            this.txtVista.setText("");

        }

    }


