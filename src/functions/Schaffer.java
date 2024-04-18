package functions;

public class Schaffer extends Algorithm{
    public Schaffer(){
        super(-100, 100, -100, 100);
    }
    @Override
    public double function(Point p){
        double number1 = p.x * p.x - p.y * p.y;
        number1 = Math.pow(Math.sin(number1), 2);
        double number2 = p.x * p.x + p.y * p.y;
        number2 = Math.pow(1 + 0.001 * number2, 2);
        return 0.5 + (number1 - 0.5)/number2;
    }
}