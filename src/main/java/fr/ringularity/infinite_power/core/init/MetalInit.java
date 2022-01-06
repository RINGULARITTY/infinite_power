package fr.ringularity.infinite_power.core.init;

import fr.ringularity.infinite_power.ip_objects.group.IPMetal;

public class MetalInit {

    public static final IPMetal lead = new IPMetal("lead", 34, 500, 1000);

    public static void create() {
        lead.register();
    }

    private MetalInit() {
    }
}
