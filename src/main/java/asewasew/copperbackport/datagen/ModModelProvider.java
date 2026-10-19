package asewasew.copperbackport.datagen;

import asewasew.copperbackport.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COPPER_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.COPPER_HELMET, Identifier.ofVanilla("copper"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.ofVanilla("copper")).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.COPPER_CHESTPLATE, Identifier.ofVanilla("copper"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.ofVanilla("copper")).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.COPPER_LEGGINGS, Identifier.ofVanilla("copper"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.ofVanilla("copper")).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.COPPER_BOOTS, Identifier.ofVanilla("copper"),
                EquipmentModel.builder().addHumanoidLayers(Identifier.ofVanilla("copper")).build(), EquipmentSlot.FEET);

        itemModelGenerator.register(ModItems.COPPER_HORSE_ARMOR, Models.GENERATED);
    }
}
