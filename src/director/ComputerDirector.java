package director;

import builder.ComputerBuilder;
import product.Computer;

public class ComputerDirector {
    public Computer buildStandardGamingPC(ComputerBuilder builder) {
        return builder
                .setCpu("Intel i9-14900K")
                .setRamGb(32)
                .setGpu("RTX 4080")
                .setStorageGb(2000)
                .setWifi(true)
                .setBluetooth(true)
                .setWarrantyYears(2)
                .build();
    }

    public Computer buildBudgetOfficePC(ComputerBuilder builder) {
        return builder
                .setCpu("Intel i3-12100")
                .setRamGb(8)
                .setStorageGb(256)
                .setWifi(true)
                .setBluetooth(false)
                .setWarrantyYears(3)
                .build();
    }
}