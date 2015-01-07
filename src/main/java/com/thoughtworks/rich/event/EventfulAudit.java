package com.thoughtworks.rich.event;

import com.thoughtworks.rich.dots.Audit;

public class EventfulAudit extends EventfulDot<Audit> {
    public EventfulAudit(Audit audit) {
        super(audit);
    }
}
