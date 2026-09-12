package product;

public class Computer {
    private final String cpu;
    private final int ramGb;
    private final String gpu;
    private final int storageGb;
    private final boolean hasWifi;
    private final boolean hasBluetooth;
    private final int warrantyYears;

    private Computer(String cpu, int ramGb, String gpu, int storageGb,
                     boolean hasWifi, boolean hasBluetooth, int warrantyYears) {
        this.cpu = cpu;
        this.ramGb = ramGb;
        this.gpu = gpu;
        this.storageGb = storageGb;
        this.hasWifi = hasWifi;
        this.hasBluetooth = hasBluetooth;
        this.warrantyYears = warrantyYears;
    }
    public static Computer create(String cpu, int ramGb, String gpu, int storageGb,
                                  boolean hasWifi, boolean hasBluetooth, int warrantyYears) {
        return new Computer(cpu, ramGb, gpu, storageGb, hasWifi, hasBluetooth, warrantyYears);
    }

    public String toString() {
        return "Computer{cpu='" + cpu + "', ramGb=" + ramGb +
                ", gpu='" + gpu + "', storageGb=" + storageGb +
                ", hasWifi=" + hasWifi + ", hasBluetooth=" + hasBluetooth +
                ", warrantyYears=" + warrantyYears + '}';
    }
}