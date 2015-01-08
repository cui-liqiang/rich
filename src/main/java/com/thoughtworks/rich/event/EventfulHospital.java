package com.thoughtworks.rich.event;

import com.thoughtworks.rich.model.dots.Hospital;

public class EventfulHospital extends EventfulDot<Hospital> {
    public EventfulHospital(Hospital hospital) {
        super(hospital);
    }
}
