package builder;

import product.Computer;

public class OfficeComputerBuilder implements ComputerBuilder {
    private String cpu;
    private int ramGb;
    private String gpu;
    private int storageGb;
    private boolean hasWifi;
    private boolean hasBluetooth;
    private int warrantyYears;

    @Override
    public ComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder setRamGb(int ramGb) {
        this.ramGb = ramGb;
        return this;
    }

    @Override
    public ComputerBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    @Override
    public ComputerBuilder setStorageGb(int storageGb) {
        this.storageGb = storageGb;
        return this;
    }

    @Override
    public ComputerBuilder setWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
        return this;
    }

    @Override
    public ComputerBuilder setBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
        return this;
    }

    @Override
    public ComputerBuilder setWarrantyYears(int warrantyYears) {
        this.warrantyYears = warrantyYears;
        return this;
    }

    @Override
    public Computer build() {
        if (warrantyYears <= 0) {
            throw new IllegalStateException("Office PC must have a warranty period specified");
        }
        return Computer.create(cpu, ramGb, gpu, storageGb, hasWifi, hasBluetooth, warrantyYears);
    }
}