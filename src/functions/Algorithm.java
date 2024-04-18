package functions;

import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public abstract class Algorithm {
    private final int h = 20;
    private final int u = 7;
    private final double sigma = 0.25;
    private double xlower;
    private double ylower;
    private double xupper;
    private double yupper;
    private List<Point> population;
    public Point bestPoint;
    public double bestValue;

    protected abstract double function(Point p);

    public Algorithm(double xlower, double xupper, double ylower, double yupper) {
        this.xlower = xlower;
        this.xupper = xupper;
        this.ylower = ylower;
        this.yupper = yupper;
        Random rand = new Random();
        population = new ArrayList<>();
        double x, y;
        for (int i = 0; i < h; i++){
            x = xlower + (xupper - xlower) * rand.nextDouble();
            y = ylower + (yupper - ylower) * rand.nextDouble();
            population.add(new Point(x, y));
        }
        algorithm();
    }

    private void algorithm(){
        for (int times = 0; times < 1000; times++) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < u; j++) {
                    population.add(generateChild(population.get(i)));
                }
            }
            //population.subList(0, h).clear();
            population.sort(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    double value = function(o1) - function(o2);
                    if (value < 0) return -1;
                    else if (value > 0) return 1;
                    else return 0;
                }
            });
            population.subList(h, population.size() - 1).clear();
            bestPoint = population.get(0);
            bestValue = function(bestPoint);
        }

    }

    private Point generateChild(Point p){
        NormalDistribution distribution = new NormalDistribution(0, sigma*sigma);
        double x = p.x + distribution.sample();
        double y = p.y + distribution.sample();
        return new Point(x, y);
    }

}
