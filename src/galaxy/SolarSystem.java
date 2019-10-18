package galaxy;

import objects.Ship;

import java.util.ArrayList;

public class SolarSystem {
    private String name;
    private String descr;
    int posX,posY;              //Position within the galaxy
    private int lod;            //Level of danger

    //Constructor

    /**
     * Creates a new named Solar System
     * @param name
     * @param descr
     * @param x
     * @param y
     * @param lod
     */
    public SolarSystem(String name, String descr, int x, int y, int lod ) {
        this.name = name;
        this.descr = descr;
        this.posX = x;
        this.posY = y;
        this.lod = lod;
    }

    /**
     * Creates a new unknown Solar System.
     * @param x
     * @param y
     * @param lod
     */
    public SolarSystem(int x, int y, int lod) {
        this.name = "System " + x + "-" + y;
        this.descr = "Unknown System";
        this.posX = x;
        this.posY = y;
        this.lod = lod;

    }


    //Getter & Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getLod() {
        return lod;
    }

    public void setLod(int lod) {
        this.lod = lod;
    }
}
