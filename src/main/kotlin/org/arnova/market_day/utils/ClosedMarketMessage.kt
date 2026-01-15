package org.arnova.market_day.utils

import net.minecraft.entity.passive.VillagerEntity
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.text.Text
import net.minecraft.village.VillagerProfession
import kotlin.random.Random

fun getClosedMarketMessage(villager: VillagerEntity): Text {
    // Child villagers
    if (villager.isBaby) {
        val lines = arrayOf(
            "I'm not old enough to trade yet!",
            "The grown-ups handle the market.",
            "I'm still learning how the village works."
        )
        return Text.literal(pick(lines))
    }

    val villagerProfession: RegistryEntry<VillagerProfession> = villager.villagerData.profession

    // Nitwit
    if (villagerProfession.matchesKey(VillagerProfession.NITWIT)) {
        val lines = arrayOf(
            "Huh? Market? What market?",
            "I was told not to sell anything...",
            "I think I'm just here to watch."
        )
        return Text.literal(pick(lines))
    }

    // Unemployed
    if (villagerProfession.matchesKey(VillagerProfession.NONE)) {
        val lines = arrayOf(
            "I don't have anything to sell yet.",
            "Maybe I should find a job before the next market.",
            "I'm still deciding what I want to do."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.FARMER)) {
        val lines = arrayOf(
            "I'm still harvesting for the next market.",
            "The crops need a bit more time.",
            "Good produce can't be rushed."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.LIBRARIAN)) {
        val lines = arrayOf(
            "I'm still cataloguing books.",
            "These pages need proper sorting.",
            "Knowledge takes time to organize."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.TOOLSMITH)) {
        val lines = arrayOf(
            "These tools need more sharpening.",
            "A dull edge is dangerous.",
            "Quality tools take time."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.CLERIC)) {
        val lines = arrayOf(
            "The potions need more time to brew.",
            "Some things can't be hurried."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.BUTCHER)) {
        val lines = arrayOf(
            "The meat isn't ready yet.",
            "Fresh cuts take preparation.",
            "Come back when the smoke clears."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.ARMORER)) {
        val lines = arrayOf(
            "I need more time to polish my armor.",
            "Strong armor takes patience.",
            "These plates aren't ready yet."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.CARTOGRAPHER)) {
        val lines = arrayOf(
            "I'm still drawing maps.",
            "These lands need careful charting.",
            "Ink takes time to dry."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.FISHERMAN)) {
        val lines = arrayOf(
            "The fish aren't biting today.",
            "I'm waiting for a better catch.",
            "Tides decide the schedule."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.FLETCHER)) {
        val lines = arrayOf(
            "These arrows need better feathers.",
            "Straight shafts take time.",
            "Accuracy comes from patience."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.LEATHERWORKER)) {
        val lines = arrayOf(
            "The hides need more tanning time.",
            "Leather can't be rushed.",
            "The smell means progress."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.MASON)) {
        val lines = arrayOf(
            "The stonework isn't finished yet.",
            "Chiseling takes a steady hand.",
            "These blocks need refinement."
        )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.SHEPHERD)) {
        val lines = arrayOf(
            "I'm still sorting the wool.",
            "The sheep were restless today.",
            "Soft wool needs care."
            )
        return Text.literal(pick(lines))
    }

    if (villagerProfession.matchesKey(VillagerProfession.WEAPONSMITH)) {
        val lines = arrayOf(
            "The blades aren't ready yet.",
            "Steel needs proper tempering.",
            "Sharp weapons take patience."
        )
        return Text.literal(pick(lines))
    }

    return Text.literal("I'm preparing goods for the next market.")
}

fun pick(lines: Array<String>): String {
    return lines[Random.nextInt(lines.size)]
}