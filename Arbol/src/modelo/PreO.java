/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Stack;

/**
 *
 * @author Oscar
 */
public class PreO {
    public static String PreOrder(String expresion) {
        String expresionP = "";
        Stack<Character> stack = new Stack<>();
        String inversa = new StringBuilder(expresion).reverse().toString();

        for (int i = 0; i < inversa.length(); i++) {
            char caracter = inversa.charAt(i);

            if (detectarSigno(caracter)) {
                while (!stack.isEmpty() && jerarquia(stack.peek()) >= jerarquia(caracter)) {
                    expresionP += stack.pop();
                }
                stack.push(caracter);
            }
            else if (caracter == ')') {
                stack.push(caracter);
            }
            else if (caracter == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    expresionP += stack.pop();
                }
                stack.pop();
            }
            else {
                expresionP += caracter;
            }
        }

        while (!stack.isEmpty()) {
            expresionP += stack.pop();
        }

        String expresionPrefija = new StringBuilder(expresionP).reverse().toString();

        return expresionPrefija;
    }

    public static boolean detectarSigno(char caracter) {
        return (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^');
    }

    public static int jerarquia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
}

