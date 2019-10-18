import enums.EQUIPSLOT;
import galaxy.SolarSystem;
import objects.Ship;
import objects.items.Weapon;
import utils.Position;
import utils.Tools;

public class StartGame {
    static long lastTick;
    static long tickRate = 800;

    public static void main(String[] args){
        lastTick = System.currentTimeMillis();
        SolarSystem sys = new SolarSystem("Test", "Testbedingte beschreibung", 0, 0, 0);
        Ship ship1 = new Ship("Aura", "peng", 20, 20, 5);
        Ship ship2 = new Ship("Neda", "pop", 20, 20, 5);

        Weapon testGun = new Weapon("Testgun", "", 10, EQUIPSLOT.WEAPON_LIGHT, 5,5, 100, 10);

        ship1.setLocation(new Position(0,20,sys));
        ship2.setLocation(new Position(2,2,sys));

        ship1.setWeaponSlots(4);
        ship1.equipWeapon(1, testGun);

        ship1.attackTarget(ship2);

        ship1.flyToPos(2, 3);
        ship1.setSpeed(5);
        int i = 0;
        while(i < 100) {
            if(tick()) {
                ship1.update();
                i++;
                System.out.println(i + " x " + ship1.getLocation().x + " - y " + ship1.getLocation().y + "-> x " + ship1.getDestination().x + " - y " + ship1.getDestination().y);
            }
        }
    }

    private static boolean tick() {
        if(lastTick + tickRate <= System.currentTimeMillis()) {
            lastTick = System.currentTimeMillis();
            return true;
        }
        else return false;
    }
}
