package functions;

public class Bukin extends Algorithm{

    public Bukin(){
        super(-15, -5 ,-3, 3);

    }
    @Override
    public double function(Point p){
        double number1 = p.y - 0.01 * Math.pow(p.x, 2);
        double number2 = p.x + 10;
        number1 = (number1 < 0) ? -number1 : number1;
        number2 = (number2 < 0) ? -number2 : number2;
        return 100 * Math.sqrt(number1) + 0.01 * number2;
    }
}
