package objects;

import objects.items.Weapon;
import utils.Confg;
import utils.Position;
import utils.Tools;

import java.util.ArrayList;

public class Ship extends Entity{
    //BASIC VARIABLES
    private Station docked;
    private Position destination;
    private Weapon[] weapons;
    private Entity attackTarget;

    //TODO locatedStation;
    // TODO Color ShieldColor, HullColor, WindowColor
    // TODO Weapon[] slots
    // TODO MediumEquiment[] slots
    // TODO HeavyEquipment[] slots

    //CONSTRUCTOR
    public Ship(String name, String descr, int maxHp, int maxShield, int speed) {
        //given variable
        super(name, descr, maxHp, maxShield);
        //Make sure the ship is not more fast than the maximum.
    }


    //Methods

    public void attackTarget(Entity entity) {
        attackTarget = entity;
    }

    public void update() {
        fly();
        attack();
    }

    public void equipWeapon(int slot, Weapon weapon) {
        weapons[slot] = weapon;
        System.out.println("equipping " + weapons[slot].getName());
    }

    /** Fly the ship to the position within the current Solar System.
     * @param x
     * @param y
     */
    public void flyToPos(int x, int y) {
        destination = new Position(x, y, location.sys);
    }

    private void attack() {
        if(weapons == null) return;
        if(attackTarget == null) return;
        //Attack target
        for(int i = 0; i < weapons.length; i++) {
            if(weapons[i] != null && getDistance(attackTarget) <= weapons[i].getRange()) {
                if(weapons[i].isEnabled()) {
                    weapons[i].shootAt(attackTarget);
                }
            }
        }
    }

    /*  If the destination is not the current position,
        the ship will fly towards the destination every
        game tick in its own speed */
    private void fly() {
        if(destination == null) return;
        if(location.sys.equals(destination.sys)) {
            location = Tools.moveToDirection(location, destination, speed);
        }
    }

    //--------------------Getter & Setter------------------

    public Position getDestination() {
        return destination;
    }

    public void setWeaponSlots(int amount) {
        if(weapons != null) {
            for(int i = 0; i < weapons.length; i++) {
                //Check if all weapons are removed from the ship.
                if( weapons[i] != null ) {
                    //If there are weapons equipped, tell the player to remove all wepaons.
                    Tools.msg("Please remove all weapons before upgrading your weapon slots.");
                    return;
                }
            }
        }
        weapons = new Weapon[amount];
    }
}
