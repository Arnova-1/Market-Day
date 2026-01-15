package org.arnova.market_day.utils

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.world.World

object MarketDayAnnouncement {
    private var lastAnnouncement = -1L

    fun init() {
        ServerTickEvents.END_WORLD_TICK.register { world ->
            val day = MarketTime.getDayCount()

            if (!MarketTime.isMarketDay() && day != lastAnnouncement) {
                announceMarketDay(world)
                lastAnnouncement = day
            }
        }
    }

    fun announceMarketDay(world: World) {
        for (player in world.players) {
            player.sendMessage(
                Text.literal("Today is Market Day!"),
                false
            )
        }
        world.playSound(
            null,
            world.spawnPoint.pos,
            SoundEvents.BLOCK_BELL_USE,
            SoundCategory.AMBIENT,
            1.0f,
            1.0f
        )
    }
}