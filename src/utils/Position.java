package utils;

import galaxy.SolarSystem;

public class Position {
    //Complete position within the Galaxy
    public int x, y;
    public SolarSystem sys;
    protected int hp, maxHp, shield, maxShield;

    /** Constructor
     * @param x
     * @param y
     * @param sys
     */
    public Position(int x, int y, SolarSystem sys) {
        this.x = x;
        this.y = y;
        this.sys = sys;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public SolarSystem getSys() {
        return sys;
    }

    public void setSys(SolarSystem sys) {
        this.sys = sys;
    }
}
