package builder;

import product.Computer;

public class GamingComputerBuilder implements ComputerBuilder {
    private static final int MIN_GAMING_RAM_GB = 16;

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
        if (gpu == null) {
            throw new IllegalStateException("Gaming PC requires a discrete GPU");
        }
        if (ramGb < MIN_GAMING_RAM_GB) {
            throw new IllegalStateException("Gaming PC requires at least " + MIN_GAMING_RAM_GB + "GB RAM");
        }
        return Computer.create(cpu, ramGb, gpu, storageGb, hasWifi, hasBluetooth, warrantyYears);
    }
}