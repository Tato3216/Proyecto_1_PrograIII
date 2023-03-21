package modelo;
import java.util.Stack;
public class Solucion {
    public static Double resolucion(String expresion) {
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            char car = expresion.charAt(i);
            if (Conversor.jerarquia(car) > 0) {
                double op1 = stack.pop();
                double op2 = stack.pop();
                double aux = operacion(op2, op1, car);
                stack.push(aux);
            } else {
                stack.push((double) (car - '0'));
            }
        }
        double resultado = stack.pop();
        return resultado;
    }

    public static Double operacion(double op1, double op2, char operador) {
        switch (operador) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            case '^':
                return Math.pow(op1, op2);
        }
        return 0.0;
    }
}