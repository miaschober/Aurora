package objects.items;

import enums.ITEMTYPE;

public class Item {
    protected String name;
    protected String descr;
    protected long defaultPrice;
    protected ITEMTYPE type;

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public long getDefaultPrice() {
        return defaultPrice;
    }

    public Item(String name, String descr, long defaultPrice, ITEMTYPE type) {
        this.name = name;
        this.descr = descr;
        this.defaultPrice = defaultPrice;
        this.type = type;
    }
}
