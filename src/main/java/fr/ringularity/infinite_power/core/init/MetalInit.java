package fr.ringularity.infinite_power.core.init;

import fr.ringularity.infinite_power.ip_objects.group.IPMetal;

public class MetalInit {

    public static final IPMetal
            copper = new IPMetal("copper", 5, 500, 1000),
            lead = new IPMetal("lead", 5, 500, 1000),
            tin = new IPMetal("tin", 30, 1000, 2000);

    public static void create() {
        copper.register();
        lead.register();
        tin.register();
    }

    private MetalInit() {
    }
}
