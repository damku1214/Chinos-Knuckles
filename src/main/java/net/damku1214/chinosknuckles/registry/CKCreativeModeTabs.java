package net.damku1214.chinosknuckles.registry;

import net.damku1214.chinosknuckles.ChinosKnuckles;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CKCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChinosKnuckles.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHINOS_KNUCKLES = CREATIVE_MODE_TABS.register("chinosknuckles", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chinosknuckles"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> CKItems.DIAMOND_KNUCKLES.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CKItems.IRON_KNUCKLES.get());
                output.accept(CKItems.GOLDEN_KNUCKLES.get());
                output.accept(CKItems.DIAMOND_KNUCKLES.get());
                output.accept(CKItems.LEATHER_SLIDES.get());
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
