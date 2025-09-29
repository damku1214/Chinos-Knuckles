package net.damku1214.chinosknuckles;

import net.damku1214.chinosknuckles.registry.CKCreativeModeTabs;
import net.damku1214.chinosknuckles.registry.CKItems;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(ChinosKnuckles.MOD_ID)
public class ChinosKnuckles {
    public static final String MOD_ID = "chinosknuckles";

    public ChinosKnuckles(IEventBus modEventBus, ModContainer modContainer) {
        CKItems.register(modEventBus);
        CKCreativeModeTabs.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(CKItems.IRON_KNUCKLES);
            event.accept(CKItems.GOLDEN_KNUCKLES);
            event.accept(CKItems.DIAMOND_KNUCKLES);
            event.accept(CKItems.LEATHER_SLIDES);
        }
    }
}
