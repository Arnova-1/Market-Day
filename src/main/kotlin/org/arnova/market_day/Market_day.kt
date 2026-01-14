package org.arnova.market_day

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.player.UseEntityCallback
import net.minecraft.entity.passive.VillagerEntity
import net.minecraft.util.ActionResult
import org.arnova.market_day.utils.MarketTime.isMarketDay

class MarketDay : ModInitializer {

    override fun onInitialize() {
        UseEntityCallback.EVENT.register { player, world, hand, entity, hitResult ->
            if (world.isClient) {
                return@register ActionResult.PASS
            }
            if (entity is VillagerEntity && isMarketDay(world)) {
                ActionResult.FAIL
            } else
                ActionResult.PASS
        }
    }
}
