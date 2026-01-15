package org.arnova.market_day.utils

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents

object MarketTime {
    private var lastDay = -1L
    private var dayCount = 0L

    fun init() {
        ServerTickEvents.END_WORLD_TICK.register { world ->
            val currentDay = world.timeOfDay / 24000L

            if (currentDay != lastDay) {
                dayCount++
                lastDay = currentDay
            }
        }
    }

    fun isMarketDay(): Boolean {
        return dayCount % 3L != 0L
    }

    fun getDayCount(): Long {
        return dayCount
    }
}