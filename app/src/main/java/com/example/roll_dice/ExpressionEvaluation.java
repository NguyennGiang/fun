package com.example.roll_dice;

import java.util.Stack;

public class ExpressionEvaluation {
    public static int evaluate(String expression) {
        Stack<Integer> operands = new Stack<Integer>();

        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                i--;
                operands.push(num);
            }

            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.empty() && hasPrecedence(ch, operators.peek())) {
                    operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.empty()) {
            operands.push(applyOperation(operators.pop(), operands.pop(), operands.pop()));
        }

        return operands.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        else {
            return true;
        }
    }

    public static int applyOperation(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

}