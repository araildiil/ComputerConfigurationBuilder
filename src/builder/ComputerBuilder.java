package builder;

import product.Computer;

public interface ComputerBuilder {
    ComputerBuilder setCpu(String cpu);
    ComputerBuilder setRamGb(int ramGb);
    ComputerBuilder setGpu(String gpu);
    ComputerBuilder setStorageGb(int storageGb);
    ComputerBuilder setWifi(boolean hasWifi);
    ComputerBuilder setBluetooth(boolean hasBluetooth);
    ComputerBuilder setWarrantyYears(int warrantyYears);

    Computer build();
}
