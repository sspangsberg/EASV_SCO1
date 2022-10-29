package funwithstrategy;

public class Main {

    public static void main(String[] args) {

        double num1 = 10.5;
        double num2 = 30.3345;

        Context context = new Context(new OperationAdd());
        System.out.println("Add: " + context.executeStrategy(num1, num2));

        context = new Context(new OperationMultiply());
        System.out.println("Multiply:" + context.executeStrategy(num1, num2));

        context = new Context(new OperationDivide());
        System.out.println("Divide:" + context.executeStrategy(num1, num2));

    }
}