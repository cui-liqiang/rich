package com.thoughtworks.rich.event;

import com.thoughtworks.rich.Player;

public interface Eventful {
    public void trigger(Player player);
}
