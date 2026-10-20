package asewasew.copperbackport.item;

import asewasew.copperbackport.CopperBackport;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new Item.Settings()));

    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER, 3, -2.4f))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER, 1.5f, -3.0f))));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 1, -2.8f))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 7, -3.2f))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER, -1, -2.0f))));

    public static final Item COPPER_HELMET = registerItem("copper_helmet",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(11))));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(11))));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(11))));
    public static final Item COPPER_BOOTS = registerItem("copper_boots",
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(11))));

    public static final Item COPPER_HORSE_ARMOR = registerItem("copper_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.ofVanilla(name), item);
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
