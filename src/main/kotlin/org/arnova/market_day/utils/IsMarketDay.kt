package org.arnova.market_day.utils

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.world.World

object MarketTime {
    var lastDay = -1
    var marketDayCounter = 0

    fun isMarketDay(world: World): Boolean {
        ServerTickEvents.END_WORLD_TICK.register { world ->
            val currentDay = (world.timeOfDay / 24000).toInt()

            if (currentDay != lastDay) {
                marketDayCounter++
                lastDay = currentDay
            }
        }
        return marketDayCounter % 3 != 0
    }
}