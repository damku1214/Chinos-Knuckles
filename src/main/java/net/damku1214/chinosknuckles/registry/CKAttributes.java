package net.damku1214.chinosknuckles.registry;

import net.damku1214.chinosknuckles.ChinosKnuckles;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.neoforge.common.PercentageAttribute;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CKAttributes {
    // These attributes doesn't do anything - it is only for cosmetic reasons
    public static final Holder<Attribute> ONE_HANDED_ATTACK_DAMAGE = register(
            "generic.one_handed_attack_damage", new PercentageAttribute("attribute.name.generic.one_handed_attack_damage", 0.0, -1.0, 1024.0).setSyncable(true)
    );
    public static final Holder<Attribute> ARMOR_ATTACK_DAMAGE = register(
            "generic.armor_attack_damage", new PercentageAttribute("attribute.name.generic.armor_attack_damage", 0.0, -1.0, 1024.0).setSyncable(true)
    );

    private static Holder<Attribute> register(String name, Attribute attribute) {
        return Registry.registerForHolder(BuiltInRegistries.ATTRIBUTE, ResourceLocation.fromNamespaceAndPath(ChinosKnuckles.MOD_ID, name), attribute);
    }
}
