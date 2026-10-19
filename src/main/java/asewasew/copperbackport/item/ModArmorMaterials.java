package asewasew.copperbackport.item;

import asewasew.copperbackport.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> COPPER_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.ofVanilla("copper"));

    public static final ArmorMaterial COPPER_ARMOR_MATERIAL = new ArmorMaterial(190,
                Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 1); map.put(EquipmentType.LEGGINGS, 3); map.put(EquipmentType.CHESTPLATE, 4);
                map.put(EquipmentType.HELMET, 2); map.put(EquipmentType.BODY, 4);
            }), 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f, 0f, ModTags.COPPER_REPAIR, COPPER_KEY);
}
