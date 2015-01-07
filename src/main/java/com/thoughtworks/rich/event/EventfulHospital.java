package com.thoughtworks.rich.event;

import com.thoughtworks.rich.dots.Hospital;

public class EventfulHospital extends EventfulDot<Hospital> {
    public EventfulHospital(Hospital hospital) {
        super(hospital);
    }
}
