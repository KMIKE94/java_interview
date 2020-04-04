package graphs;

import java.util.Arrays;

/**
 * 50 x 50 grid
 * Input will be 2 or more inputs -> source to destination
 * Create a Mark those 2 points
 *  be able to pretty print the graph at a given point
 *
 *
 *
 * Node needs an id, a position too
 *
 *
 */
public class GraphApplication {

    private static class Point{
        int x,y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }
    }

    private static int arrSize = 50;
    private static double startingDist;
    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        int[][] grid = new int[arrSize][arrSize];

        grid[10][2] = -1;
        grid[42][32] = -2;
        prettyPrint(grid);

        Point source = new Point(10, 2);
        Point destination = new Point(42, 32);

        /*
        can move in 4 directions
        keep track of moves taken
        choose the one that's closest to the destination
         */

        // difference between locations
        startingDist = calculateDistance(source, destination);

        // create 4 different graphs in 4 directions
//        while(destination != source) {
//
//            // this will create a graph in 4 directions
//            // and return the shortestGraph thus far
//            Graph graph = createGraph(source, destination);
//
//        }
    }

//    private static Graph createGraph(Point s, Point d, Graph graph) {
//        double currentDisance;
//
//        if(s == d) {
//            return graph;
//        }
//
//        // plus/minus x
//        if(s.x > 0) {
//            Point p1 = new Point(s.x-1, s.y);
//            double d1 = calculateDistance(p1, d);
//        }
//
//        if(s.x < arrSize-1) {
//            Point p2 = new Point(s.x+1, s.y);
//            double d2 = calculateDistance(p2, d);
//        }
//
//        if(s.y > 0) {
//            Point p3 = new Point(s.x, s.y - 1);
//            double d3 = calculateDistance(p3, d);
//        }
//
//        if(s.y < arrSize-1) {
//            Point p4 = new Point(s.x, s.y + 1);
//            double d4 = calculateDistance(p4, d);
//        }
//
//
//    }

    private static double calculateDistance(Point s, Point d) {
        // basically pythagoras
        int x = s.x < d.x ? (d.x - s.x) : (s.x - d.x);
        int y = s.y < d.y ? (d.y - s.y) : (s.y - d.y);
        return Math.sqrt(x + y);
    }

    private static void prettyPrint(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[1].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}


