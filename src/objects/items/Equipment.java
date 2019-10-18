package objects.items;

import enums.EQUIPSLOT;
import enums.ITEMTYPE;

public class Equipment extends Item{
    EQUIPSLOT slot;
    boolean enabled = true;

    public Equipment(String name, String descr, long defaultPrice, EQUIPSLOT slot, ITEMTYPE type) {
        super(name, descr, defaultPrice, type);
        this.slot = slot;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
