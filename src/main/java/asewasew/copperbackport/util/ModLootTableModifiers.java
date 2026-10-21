package asewasew.copperbackport.util;

import asewasew.copperbackport.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;

import java.util.Map;

public class ModLootTableModifiers {
    private static final Map<RegistryKey<LootTable>, int[]> tableMap = Map.of(
            LootTables.END_CITY_TREASURE_CHEST, new int[] {46, 954},
            LootTables.SIMPLE_DUNGEON_CHEST, new int[] {194, 806},
            LootTables.VILLAGE_WEAPONSMITH_CHEST, new int[] {56, 944},
            LootTables.NETHER_BRIDGE_CHEST, new int[] {179, 821},
            LootTables.STRONGHOLD_CORRIDOR_CHEST, new int[] {25, 975},
            LootTables.DESERT_PYRAMID_CHEST, new int[] {170, 830},
            LootTables.JUNGLE_TEMPLE_CHEST, new int[] {44, 956}
    );
    private static final int[] defaults = new int[] {50, 950};

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (!source.isBuiltin() || !tableMap.containsKey(key)) {
                return;
            }

            int[] weights = tableMap.getOrDefault(key, defaults);
            int itemWeight = weights[0];
            int emptyWeight = weights[1];

            ConstantLootNumberProvider con = ConstantLootNumberProvider.create(1);
            LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(con)
                    .with(ItemEntry.builder(ModItems.COPPER_HORSE_ARMOR)
                            .weight(itemWeight))
                    .with(EmptyEntry.builder().weight(emptyWeight));

            tableBuilder.pool(poolBuilder.build());
        }));
    }
}
