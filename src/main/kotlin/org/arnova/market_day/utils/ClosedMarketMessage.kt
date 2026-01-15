package org.arnova.market_day.utils

import net.minecraft.entity.passive.VillagerEntity
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.text.Text
import net.minecraft.village.VillagerProfession

fun getClosedMarketMessage(villager: VillagerEntity): Text {
    val villagerProfession: RegistryEntry<VillagerProfession> = villager.villagerData.profession

    if (villagerProfession.matchesKey(VillagerProfession.FARMER)) {
        return Text.literal("I'm still harvesting for the next market.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.LIBRARIAN)) {
        return Text.literal("I'm still cataloguing books for the next market.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.TOOLSMITH)) {
        return Text.literal("These tools need proper forging.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.CLERIC)) {
        return Text.literal("The potions need more time to brew.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.BUTCHER)) {
        return Text.literal("The meat isn't ready yet. Come back later.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.ARMORER)) {
        return Text.literal("I need more time to polish my armor.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.CARTOGRAPHER)) {
        return Text.literal("My maps aren't finished yet.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.FISHERMAN)) {
        return Text.literal("The fish aren’t biting today. Come back later.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.FLETCHER)) {
        return Text.literal("These arrows need better feathers.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.LEATHERWORKER)) {
        return Text.literal("This leather needs more curing time.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.MASON)) {
        return Text.literal("The stonework isn't finished yet.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.SHEPHERD)) {
        return Text.literal("I'm still shearing and sorting wool.")
    }

    if (villagerProfession.matchesKey(VillagerProfession.WEAPONSMITH)) {
        return Text.literal("I'm still shearing and sorting wool.")
    }

    return Text.literal("I'm preparing goods for the next market.")
}