package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.BulldozerProducer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.ExcavatorProducer;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import core.mate.academy.model.TruckProducer;
import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of MachineService.
 */

public class MachineServiceImpl<T extends Machine> implements MachineService<T> {

    private final Machine truck = new Truck();
    private final Machine excavator = new Excavator();
    private final Machine bulldozer = new Bulldozer();

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        List<Machine> machines = new ArrayList<>(); // Ініціалізуємо список Machine
        List<? extends Machine> truckProducer = new TruckProducer().get();
        List<? extends Machine> excavatorProducer = new ExcavatorProducer().get();
        List<? extends Machine> bulldozerProducer = new BulldozerProducer().get();

        if (Truck.class.isAssignableFrom(type)) {
            machines.addAll(truckProducer);
        } else if (Bulldozer.class.isAssignableFrom(type)) {
            machines.addAll(bulldozerProducer);
        } else if (Excavator.class.isAssignableFrom(type)) {
            machines.addAll(excavatorProducer);
        }
        return machines;
    }

    @Override
    public void fill(List<Object> machines, Machine value) {
        machines.replaceAll(ignored -> value);
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        if (machines.contains(truck)) {
            truck.doWork();
        } else if (machines.contains(excavator)) {
            excavator.doWork();
        } else if (machines.contains(bulldozer)) {
            bulldozer.doWork();
        }
    }
}
