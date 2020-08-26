package lesson.machine;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List inventory;
    public Inventory(){
        inventory = new LinkedList();
    }

    public void addMachine(String serialNumber, double price, MachineSpec spec){
        Machine machine = new Machine(serialNumber, price, spec);
        inventory.add(machine);
    }

    public Machine get(String serialNumber){
        for(Iterator i = inventory.iterator(); i.hasNext(); ){
            Machine machine = (Machine)i.next();
            if(machine.getSerialNumber().equals(serialNumber)){
                return machine;
            }
        }
        return null;
    }


    //SRP
    public List search(MachineSpec searchspec){
        List matchingMachines = new LinkedList();
        for(Iterator i = inventory.iterator(); i.hasNext(); ){
            Machine machine = (Machine)i.next();
            if(machine.getSpec().matches(searchspec))
                matchingMachines.add(machine);
        }
        return matchingMachines;
    }

}
