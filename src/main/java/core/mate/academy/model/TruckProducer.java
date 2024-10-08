package core.mate.academy.model;

import core.mate.academy.service.MachineProducer;
import java.util.List;

public class TruckProducer implements MachineProducer<Truck> {
    @Override
    public List<? extends Machine> get() {
        Machine machine = new Truck();
        return List.of(machine);
    }
}
