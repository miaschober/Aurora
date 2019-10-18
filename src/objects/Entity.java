package objects;

import galaxy.SolarSystem;
import utils.Confg;
import utils.Position;
import utils.Tools;

public class Entity {
    //Entity Information
    String name, descr;
    protected int speed = 0;                        // Values from 1 - 45 max

    protected Position location;
    protected int hp, maxHp, shield, maxShield;

    public Position getLocation() {
        return location;
    }

    public void setLocation(Position location) {
        this.location = location;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    //METHODS
    public void setLocation(int x, int y, SolarSystem sys) {
        location.x = x;
        location.y = y;
        location.sys = sys;
    }


    //CONSTRUCTOR
    public Entity(String name, String descr, int maxHp, int maxShield, int hp, int shield) {
        this.name = name;
        this.descr = descr;
        this.hp = hp;
        this.shield = shield;
        this.maxHp = maxHp;
        this.maxShield = maxShield;
        //Set default
        this.hp = hp;
        this.shield = shield;
    }

    public Entity(String name, String descr, int maxHp, int maxShield) {
        this.name = name;
        this.descr = descr;
        this.hp = hp;
        this.shield = shield;
        this.maxHp = maxHp;
        this.maxShield = maxShield;
        //Set default
        this.hp = maxHp;
        this.shield = maxShield;
        checkLegal();
    }

    //Check if variables are in legal range.
    private void checkLegal() {
        if(speed > Confg.MAXSPEED) speed = Confg.MAXSPEED;  //Check Speed
    }

    /** Returns the distance to another Entity
     * @return
     */
    public long getDistance(Entity entity) {
        return (long) Math.round(Tools.distance(this.location, entity.location));
    }

    //Hit the entity by a weapon
    public void hit(long hpDmg, long shieldDmg) {
        shield -= shieldDmg;
        if(shield <= 0) {
            hp -= hpDmg;
            if (shield < 0) shield = 0;
            if (hp <= 0) explode();
        }
    }

    //Explode the entity
    public void explode() {
        //TODO Create wreck with inventory in cargo
        
    }

    //GETTER & SETTER
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

    public long getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public long getMaxShield() {
        return maxShield;
    }

    public void setMaxShield(int maxShield) {
        this.maxShield = maxShield;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        checkLegal();
    }
}
