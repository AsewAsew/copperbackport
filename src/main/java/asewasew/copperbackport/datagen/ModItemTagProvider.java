package asewasew.copperbackport.datagen;

import asewasew.copperbackport.item.ModItems;
import asewasew.copperbackport.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.COPPER_REPAIR).add(Items.COPPER_INGOT);

        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.COPPER_SWORD);

        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.COPPER_SHOVEL);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.COPPER_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.COPPER_AXE);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.COPPER_HOE);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ModItems.COPPER_BOOTS);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ModItems.COPPER_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ModItems.COPPER_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ModItems.COPPER_HELMET);
    }
}
