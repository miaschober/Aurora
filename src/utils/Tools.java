package utils;

import java.util.Random;

public class Tools {

    //Message to the player.
    public static void msg(String msg) {
        System.out.println(msg);
    }

    /** Calculates the distance between pos1 & pos2 if it is within the same system.
     * @param pos1
     * @param pos2
     * @return
     */
    public static double distance(Position pos1, Position pos2) {
        //Is it in the same System?
        if(pos1.sys.equals(pos2.sys)) {
            double dist = (int) Math.hypot(pos2.x - pos1.x, pos2.y - pos1.y);
            return dist;
        }
        return 999999;
    }

    private static double distanceAlpha(Position start, Position dest) {
        double dist = distance(start, dest);
        int xLength, yLength;
        xLength = dest.x - start.x;
        yLength = dest.y - start.y;
        double alpha = Math.atan2(xLength, yLength);
        alpha = Math.toDegrees(alpha);
        return alpha;
    }

    private static int calcXLength(Position pos1, Position pos2, double dist) {
        double alpha = distanceAlpha(pos1, pos2);
        double beta = 90 - alpha;
        double xLength = dist * Math.cos(Math.toRadians(beta));
        return (int) Math.round(xLength);
    }

    private static int calcYLength(double xLength, double dist, boolean negate) {
        double yLength = Math.sqrt(dist * dist - xLength * xLength);
        if(negate) yLength = yLength* -1;
        return (int) Math.round(yLength);
    }

    public static Position moveToDirection(Position start, Position dest, int speed) {
        System.out.println(start + " " + dest );
        if(start.sys.equals(dest.sys)) {
            double dist = distance(start, dest);

            if (dist <= speed) return dest;                      //Arrives within next tick? negate trouble... TODO

            dist -= speed;                                      //Otherwise fly more close
            //Calculate new Position with Pythagoras.
            int xLength = calcXLength(start, dest, dist);
            boolean negateY = start.y > dest.y;                     //Fixing always-positive value
            int yLength = calcYLength(xLength, dist, negateY);
            int x, y;
            x = dest.x - xLength;                                   //New X Position
            y = dest.y - yLength;                                   //New Y Position

            return new Position(x, y, start.sys);
        } else {
            System.out.println("Can only move within the same Solar System.");
            return start;
        }
    }

    //Get a random number from 1 to 100
    public static int getRandom100() {
        Random r = new Random();
        //return r.nextInt(max);
        return r.nextInt(100 + 1);
    }
}
