package core.mate.academy.model;

import core.mate.academy.service.MachineProducer;
import java.util.List;

public class ExcavatorProducer implements MachineProducer<Excavator> {
    @Override
    public List<? extends Machine> get() {
        Machine machine = new Excavator();
        return List.of(machine);
    }
}
