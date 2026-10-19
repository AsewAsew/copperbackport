package asewasew.copperbackport.item;

import asewasew.copperbackport.CopperBackport;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", Item::new);

    public static final Item COPPER_SWORD = registerItem("copper_sword",
            settings -> new SwordItem(ModToolMaterials.COPPER, 3, -2.4f, settings));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            settings -> new ShovelItem(ModToolMaterials.COPPER, 1.5f, -3.0f, settings));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            settings -> new PickaxeItem(ModToolMaterials.COPPER, 1, -2.8f, settings));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            settings -> new AxeItem(ModToolMaterials.COPPER, 7, -3.2f, settings));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            settings -> new HoeItem(ModToolMaterials.COPPER, -1, -2.0f, settings));

    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            settings -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, EquipmentType.HELMET, settings));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            settings -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, settings));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            settings -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, EquipmentType.LEGGINGS, settings));
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            settings -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, EquipmentType.BOOTS, settings));

    public static final Item COPPER_HORSE_ARMOR = registerItem("copper_horse_armor",
            settings -> new AnimalArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, settings.maxCount(1)));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.ofVanilla(name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.ofVanilla(name)))));
    }

    public static void registerModItems() {
        CopperBackport.LOGGER.info("Registering Items for " + CopperBackport.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->
            entries.addBefore(Items.IRON_NUGGET, COPPER_NUGGET)
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.STONE_HOE, COPPER_SHOVEL);
            entries.addAfter(COPPER_SHOVEL, COPPER_PICKAXE);
            entries.addAfter(COPPER_PICKAXE, COPPER_AXE);
            entries.addAfter(COPPER_AXE, COPPER_HOE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.addAfter(Items.STONE_SWORD, COPPER_SWORD);
            entries.addAfter(Items.STONE_AXE, COPPER_AXE);

            entries.addAfter(Items.LEATHER_BOOTS, COPPER_HELMET);
            entries.addAfter(COPPER_HELMET, COPPER_CHESTPLATE);
            entries.addAfter(COPPER_CHESTPLATE, COPPER_LEGGINGS);
            entries.addAfter(COPPER_LEGGINGS, COPPER_BOOTS);

            entries.addAfter(Items.LEATHER_HORSE_ARMOR, COPPER_HORSE_ARMOR);
        });
    }
}
