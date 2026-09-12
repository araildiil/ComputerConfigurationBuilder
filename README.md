# Computer Configuration Builder

A Java implementation of the **Builder** design pattern, applied to assembling
`Computer` objects with multiple configurable components (CPU, RAM, GPU,
storage, and optional features).

## Overview

The `Computer` class represents a fully assembled computer. It is immutable
and has a private constructor — the only way to create a valid `Computer`
is through one of its builders.

Two concrete builders produce meaningfully different configurations:

- **GamingComputerBuilder** — requires a discrete GPU and at least 16GB of RAM;
  `build()` throws an exception if these conditions are not met.
- **OfficeComputerBuilder** — does not require a GPU, but requires a warranty
  period to be specified; `build()` throws an exception otherwise.

A `ComputerDirector` class provides preset, reusable configurations
(e.g. a standard gaming setup or a budget office setup), showing how the
Director role simplifies repeated construction scenarios.

## Project Structure

```
src/
├── product/
│   └── Computer.java              # The product being built
├── builder/
│   ├── ComputerBuilder.java       # Builder interface
│   ├── GamingComputerBuilder.java # Concrete builder #1
│   └── OfficeComputerBuilder.java # Concrete builder #2
├── director/
│   └── ComputerDirector.java      # Orchestrates preset build sequences
└── client/
    └── Main.java                  # Demo entry point
```


## How to Build Each Representation

**Gaming PC (manual, via fluent API):**
```java
Computer gamingPc = new GamingComputerBuilder()
        .setCpu("Intel i9-14900K")
        .setRamGb(32)
        .setGpu("RTX 4080")
        .setStorageGb(2000)
        .setWifi(true)
        .setBluetooth(true)
        .setWarrantyYears(2)
        .build();
```

**Office PC (manual, via fluent API):**
```java
Computer officePc = new OfficeComputerBuilder()
        .setCpu("Intel i5-13400")
        .setRamGb(16)
        .setStorageGb(512)
        .setWifi(true)
        .setBluetooth(false)
        .setWarrantyYears(3)
        .build();
```

**Using the Director (preset configurations):**
```java
ComputerDirector director = new ComputerDirector();
Computer standardGaming = director.buildStandardGamingPC(new GamingComputerBuilder());
Computer budgetOffice = director.buildBudgetOfficePC(new OfficeComputerBuilder());
```

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA (JDK 17)
3. Run `client/Main.java`

The demo prints both manually built and Director-built computers to the
console, and demonstrates validation by attempting to build an invalid
gaming PC (missing GPU), which throws an `IllegalStateException`.

## Requirements

- Java 17 (JDK 17)