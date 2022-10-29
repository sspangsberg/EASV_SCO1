package funwithstrategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double num1, double num2) {
        return strategy.doOperation(num1, num2);
    }
}
