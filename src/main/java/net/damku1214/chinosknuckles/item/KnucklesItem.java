package net.damku1214.chinosknuckles.item;

import net.damku1214.chinosknuckles.ChinosKnuckles;
import net.damku1214.chinosknuckles.client.ClientKnuckleDualWieldingData;
import net.damku1214.chinosknuckles.registry.CKAttributes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class KnucklesItem extends Item {
    private final Tier tier;

    public static final ResourceLocation BASE_MOVEMENT_SPEED_ID = ResourceLocation.withDefaultNamespace("base_movement_speed");
    public static final ResourceLocation BASE_ONE_HANDED_ATTACK_DAMAGE_ID = ResourceLocation.fromNamespaceAndPath(ChinosKnuckles.MOD_ID, "base_one_handed_attack_damage");
    public static final ResourceLocation BASE_ARMOR_ATTACK_DAMAGE_ID = ResourceLocation.fromNamespaceAndPath(ChinosKnuckles.MOD_ID, "base_armor_attack_damage");

    public KnucklesItem(Tier tier, Properties properties) {
        super(properties.component(DataComponents.TOOL, new Tool(List.of(), 1.0F, 2)));
        this.tier = tier;
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed, float movementSpeed, float oneHandedAttackDamage, float armorAttackDamage) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                BASE_ATTACK_DAMAGE_ID, attackDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.MOVEMENT_SPEED,
                        new AttributeModifier(BASE_MOVEMENT_SPEED_ID, movementSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        CKAttributes.ARMOR_ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ARMOR_ATTACK_DAMAGE_ID, armorAttackDamage, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        CKAttributes.ONE_HANDED_ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ONE_HANDED_ATTACK_DAMAGE_ID, oneHandedAttackDamage, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    @Override
    public float getAttackDamageBonus(@NotNull Entity target, float damage, @NotNull DamageSource damageSource) {
        return ClientKnuckleDualWieldingData.get() ? target instanceof LivingEntity livingEntity && Objects.requireNonNull(livingEntity.getAttribute(Attributes.ARMOR)).getValue() > 0 ? 0.5F * damage : 0 : -damage;
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack toRepair, @NotNull ItemStack repair) {
        return this.tier.getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
    }
}
