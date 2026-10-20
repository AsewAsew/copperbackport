package asewasew.copperbackport.item;

import asewasew.copperbackport.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static final ArmorMaterial COPPER_ARMOR_MATERIAL = new ArmorMaterial(11,
                Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 1); map.put(EquipmentType.LEGGINGS, 3); map.put(EquipmentType.CHESTPLATE, 4);
                map.put(EquipmentType.HELMET, 2); map.put(EquipmentType.BODY, 4);
            }), 8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f, 0f, ModTags.COPPER_REPAIR,
                    Identifier.ofVanilla("copper"));
}
