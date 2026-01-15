package org.arnova.market_day

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.player.UseEntityCallback
import net.minecraft.entity.passive.VillagerEntity
import net.minecraft.util.ActionResult
import org.arnova.market_day.utils.MarketDayAnnouncement
import org.arnova.market_day.utils.MarketTime
import org.arnova.market_day.utils.getClosedMarketMessage

class MarketDay : ModInitializer {
    override fun onInitialize() {
        MarketTime.init()
        MarketDayAnnouncement.init()

        UseEntityCallback.EVENT.register { player, world, hand, entity, hitResult ->
            if (world.isClient) {
                return@register ActionResult.PASS
            }
            if (entity is VillagerEntity && MarketTime.isMarketDay()) {
                player.sendMessage(
                    getClosedMarketMessage(entity),
                    true)
                ActionResult.FAIL
            } else {
                ActionResult.PASS
            }
        }
    }
}
