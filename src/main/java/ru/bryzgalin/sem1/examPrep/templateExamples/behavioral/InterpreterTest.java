package ru.bryzgalin.sem1.examPrep.templateExamples.behavioral;

/*
Interpreter — это поведенческий паттерн,
 который позволяет интерпретировать предложения языка или выражения.
  Он определяет грамматику языка и создает интерпретатор для её обработки.
   Паттерн используется, когда нужно выполнять операции над структурами,
    которые можно представить в виде языка (например, математические выражения, SQL-запросы).
 */
// Интерфейс выражения
interface Expression {
    int interpret();
}
// Конкретное выражение: число
class Number implements Expression {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}

// Конкретное выражение: сложение
class Add implements Expression {
    private Expression left;
    private Expression right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

public class InterpreterTest {
    public static void main(String[] args) {
        Expression expression = new Add(new Number(2), new Number(3));
        System.out.println(expression.interpret()); // Вывод: 5
    }
}
