package galaxy;

import objects.Entity;
import objects.Ship;
import utils.Tools;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Galaxy {
    /*  Contains lists of all the objects within the galaxy
        Ships, Stations, Stargates, Factions, etc.
     */
    private static ArrayList<Ship> ships = new ArrayList<Ship>();
    private static ArrayList<Entity> entities = new ArrayList<Entity>();


    //Ship List
    public static ArrayList<Ship> getShips() { return ships; }
    public static void addShip(Ship ship) { ships.add(ship); }
    public static void removeShip(Ship ship) { ships.remove(ship); }
    public static ArrayList<Ship> getShipsInSys(SolarSystem sys) {
        ArrayList<Ship> getShips = new ArrayList<Ship>();
        for(Ship current : ships) {
            if(current.getLocation().sys.equals(sys)) {
                getShips.add(current);
            }
        }
        return getShips;
    }
    public static ArrayList<Ship> getShipsInRange(Entity destination, int range) {
        ArrayList<Ship> getShips = new ArrayList<Ship>();
        for(Ship current : ships) {
            if(current.getLocation().sys.equals(destination.getLocation().sys)) {
                if(Tools.distance(destination.getLocation(), current.getLocation()) <= range) {
                    getShips.add(current);
                }
            }
        }
        return getShips;
    }

    //Object List
    public ArrayList<Entity> getEntites() { return entities; };
    public static void addEntity(Entity ent) { entities.add(ent); }
    public static void removeEntity(Entity ent) { entities.remove(ent); }
    public static ArrayList<Entity> getEntitiesInSys(SolarSystem sys) {
        ArrayList<Entity> entitiesInSys = new ArrayList<Entity>();
        for(Entity current : entities) {
            if(current.getLocation().sys.equals(sys)) {
                entitiesInSys.add(current);
            }
        }
        return entitiesInSys;
    }
    public static ArrayList<Entity> getEntitiesInRange(Entity destination, int range) {
        ArrayList<Entity> getEntities = new ArrayList<Entity>();
        for(Entity current : entities) {
            if(current.getLocation().sys.equals(destination.getLocation().sys)) {
                if(Tools.distance(destination.getLocation(), current.getLocation()) <= range) {
                    getEntities.add(current);
                }
            }
        }
        return getEntities;
    }
}
