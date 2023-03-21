
package modelo;

import java.util.Stack;

public class Conversor {
    public static String conversorPFija(String expresion) {
        String ePostFija = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            char car = expresion.charAt(i);
            if (jerarquia(car) > 0) {
                while (!stack.isEmpty() && jerarquia(stack.peek()) >= jerarquia(car)) {
                    ePostFija += stack.pop();
                }
                stack.push(car);
            } else if (car == ')') {
                char aux = stack.pop();
                while (aux != '(') {
                    ePostFija += aux;
                    aux = stack.pop();
                }
            } else if (car == '(') {
                stack.push(car);
            } else {
                ePostFija += car;
            }
        }
        while (!stack.isEmpty()) {
            ePostFija += stack.pop();
        }
        return ePostFija;
    }

    static int jerarquia(char car) {
        switch (car) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}