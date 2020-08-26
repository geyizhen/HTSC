package lesson.machine;

public class Machine {
    private String serialNumber;
    private double price;
    private MachineSpec spec;

    public Machine(String serialNumber, double price, MachineSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }


    public double getPrice() {
        return price;
    }

    public MachineSpec getSpec() {
        return spec;
    }
}
class Computer extends Machine {
    public Computer(String serialNumber, double price, MachineSpec spec) {
        super(serialNumber, price, spec);
    }
}
class Desktop extends Machine {
    public Desktop(String serialNumber, double price, MachineSpec spec) {
        super(serialNumber, price, spec);
    }
}
class Station extends Machine {
    public Station(String serialNumber, double price, MachineSpec spec) {
        super(serialNumber, price, spec);
    }
}