import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storageFacility;

    public StorageFacility() {
        this.storageFacility = new HashMap<>();
    }

    public void add(String unit, String item) {
        if (this.storageFacility.containsKey(unit)) {
            this.storageFacility.get(unit).add(item);
        } else {
            this.storageFacility.put(unit, new ArrayList<>());
            this.storageFacility.get(unit).add(item);
        }
    }

    public ArrayList<String> contents(String storageUnit) {
        if (this.storageFacility.containsKey(storageUnit)) {
            return this.storageFacility.get(storageUnit);
        }
        return new ArrayList<>();
    }

    public void remove(String storageUnit, String item) {

        if (this.storageFacility.containsKey(storageUnit)) {
            this.storageFacility.get(storageUnit).remove(item);
            if (this.storageFacility.get(storageUnit).isEmpty()) {
                this.storageFacility.remove(storageUnit);
            }
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();

        for (String unit : this.storageFacility.keySet()) {
            if (!(this.storageFacility.get(unit).isEmpty())) {
                units.add(unit);
            }
        }

        return units;
    }

}
