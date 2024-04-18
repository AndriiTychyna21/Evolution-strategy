package functions;

public class Matyasa extends Algorithm{
    public Matyasa(){
        super(-10, 10, -10, 10);
    }

    @Override
    public double function(Point p) {
        return 0.26 * (p.x * p.x + p.y * p.y) - 0.48 * p.x * p.y;
    }
}
