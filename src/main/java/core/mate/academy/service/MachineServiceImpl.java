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
    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll(Class<? extends Machine> type) {
        List<T> machines = new ArrayList<>();

        if (type == null) {
            return List.of();
        } else if (Truck.class.isAssignableFrom(type)) {
            machines.addAll((List<T>) new TruckProducer().get());
        } else if (Bulldozer.class.isAssignableFrom(type)) {
            machines.addAll((List<T>) new BulldozerProducer().get());
        } else if (Excavator.class.isAssignableFrom(type)) {
            machines.addAll((List<T>) new ExcavatorProducer().get());
        }

        return machines.isEmpty() ? List.of() : machines;
    }

    @Override
    public void fill(List<Object> machines, Machine value) {
        machines.replaceAll(ignored -> value);
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
