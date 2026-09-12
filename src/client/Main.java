package client;

import builder.ComputerBuilder;
import builder.GamingComputerBuilder;
import builder.OfficeComputerBuilder;
import director.ComputerDirector;
import product.Computer;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        Computer gamingPc = gamingBuilder
                .setCpu("Intel i9-14900K")
                .setRamGb(32)
                .setGpu("RTX 4080")
                .setStorageGb(2000)
                .setWifi(true)
                .setBluetooth(true)
                .setWarrantyYears(2)
                .build();

        System.out.println("Gaming PC: " + gamingPc);
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        Computer officePc = officeBuilder
                .setCpu("Intel i5-13400")
                .setRamGb(16)
                .setStorageGb(512)
                .setWifi(true)
                .setBluetooth(false)
                .setWarrantyYears(3)
                .build();

        System.out.println("Office PC: " + officePc);
        try {
            new GamingComputerBuilder()
                    .setCpu("Intel i7")
                    .setRamGb(16)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation caught an error: " + e.getMessage());
        }

        ComputerDirector director = new ComputerDirector();

        Computer standardGamingPc = director.buildStandardGamingPC(new GamingComputerBuilder());
        System.out.println("Director-built Standard Gaming PC: " + standardGamingPc);

        Computer budgetOfficePc = director.buildBudgetOfficePC(new OfficeComputerBuilder());
        System.out.println("Director-built Budget Office PC: " + budgetOfficePc);
    }
}