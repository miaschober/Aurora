package objects.items;

import enums.EQUIPSLOT;
import enums.ITEMTYPE;
import objects.Entity;
import utils.Tools;

import java.util.Random;

public class Weapon extends Equipment {
    //Weapon Informations
    long hpDamage, shieldDamage;
    int aimSpeed, range;
    //Constructor
    public Weapon (String name, String descr, long defaultPrice, EQUIPSLOT slot, long hpDamage, long shieldDamage, int aimSpeed, int range) {
        super(name, descr, defaultPrice, slot, ITEMTYPE.WEAPON);
        this.hpDamage = hpDamage;
        this.shieldDamage = shieldDamage;
        this.aimSpeed = aimSpeed;
        this.range = range;
    }

    //Methods
    public void shootAt(Entity entity) {
        int rnd = Tools.getRandom100();
        int hitChance = aimSpeed - entity.getSpeed() / 5;
        if(hitChance >= rnd) {
            entity.hit(hpDamage, shieldDamage);
        }
        System.out.println("Random " + rnd + " - hitchance " + hitChance);
        System.out.println("Attacking: shield " + entity.getShield() + "- hp " + entity.getHp());
    }

    //Getter & Setter
    public long getHpDamage() {
        return hpDamage;
    }

    public void setHpDamage(long hpDamage) {
        this.hpDamage = hpDamage;
    }

    public long getShieldDamage() {
        return shieldDamage;
    }

    public void setShieldDamage(long shieldDamage) {
        this.shieldDamage = shieldDamage;
    }

    public int getAimSpeed() {
        return aimSpeed;
    }

    public void setAimSpeed(int aimSpeed) {
        this.aimSpeed = aimSpeed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
