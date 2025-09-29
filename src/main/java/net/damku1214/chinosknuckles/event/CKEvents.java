package net.damku1214.chinosknuckles.event;

import net.damku1214.chinosknuckles.ChinosKnuckles;
import net.damku1214.chinosknuckles.client.ClientKnuckleDualWieldingData;
import net.damku1214.chinosknuckles.item.KnucklesItem;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = ChinosKnuckles.MOD_ID)
public class CKEvents {
    @SubscribeEvent
    public static void checkKnucklesDualWielding(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) {
            ClientKnuckleDualWieldingData.set(player.getMainHandItem().getItem() instanceof KnucklesItem && player.getOffhandItem().getItem() instanceof KnucklesItem);
        }
    }
}