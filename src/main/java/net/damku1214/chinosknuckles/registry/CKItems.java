package net.damku1214.chinosknuckles.registry;

import net.damku1214.chinosknuckles.ChinosKnuckles;
import net.damku1214.chinosknuckles.item.KnucklesItem;
import net.damku1214.chinosknuckles.item.LeatherSlidesItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CKItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ChinosKnuckles.MOD_ID);

    public static final DeferredItem<Item> IRON_KNUCKLES = ITEMS.register("iron_knuckles", () -> new KnucklesItem(Tiers.IRON, new Item.Properties().attributes(KnucklesItem.createAttributes(Tiers.IRON, 4, -2.3F, 0.005F, -1, 0.5F)).durability(125)));
    public static final DeferredItem<Item> GOLDEN_KNUCKLES = ITEMS.register("golden_knuckles", () -> new KnucklesItem(Tiers.GOLD, new Item.Properties().attributes(KnucklesItem.createAttributes(Tiers.GOLD, 4, -1.4F, 0.005F, -1, 0.5F)).durability(16)));
    public static final DeferredItem<Item> DIAMOND_KNUCKLES = ITEMS.register("diamond_knuckles", () -> new KnucklesItem(Tiers.DIAMOND, new Item.Properties().attributes(KnucklesItem.createAttributes(Tiers.DIAMOND, 4, -2.3F, 0.005F, -1, 0.5F)).durability(781)));

    public static final DeferredItem<Item> LEATHER_SLIDES = ITEMS.register("leather_slides", () -> new LeatherSlidesItem(CKArmorMaterials.LEATHER_SLIDES, ArmorItem.Type.BOOTS, 0.02F, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(1))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
