package asewasew.copperbackport.datagen;

import asewasew.copperbackport.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                List<ItemConvertible> items = List.of(ModItems.COPPER_SHOVEL, ModItems.COPPER_PICKAXE, ModItems.COPPER_AXE, ModItems.COPPER_HOE, ModItems.COPPER_SWORD,
                        ModItems.COPPER_BOOTS, ModItems.COPPER_LEGGINGS, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_HELMET, ModItems.COPPER_HORSE_ARMOR);

                offerSmelting(items, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.1f, 200, "copper");
                offerBlasting(items, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.1f, 100, "copper");

                createShapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET, 9).input(Items.COPPER_INGOT)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.COPPER_INGOT)
                        .pattern("###").pattern("###").pattern("###").input('#', ModItems.COPPER_NUGGET)
                        .criterion(hasItem(ModItems.COPPER_NUGGET), conditionsFromItem(ModItems.COPPER_NUGGET)).offerTo(exporter,
                                RegistryKey.of(RegistryKeys.RECIPE, Identifier.ofVanilla("copper_ingot_from_nuggets")));

                createShaped(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL)
                        .pattern("#").pattern("S").pattern("S").input('#', Items.COPPER_INGOT).input('S', Items.STICK)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE)
                        .pattern("###").pattern(" S ").pattern(" S ").input('#', Items.COPPER_INGOT).input('S', Items.STICK)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE)
                        .pattern("##").pattern("#S").pattern(" S").input('#', Items.COPPER_INGOT).input('S', Items.STICK)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE)
                        .pattern("##").pattern(" S").pattern(" S").input('#', Items.COPPER_INGOT).input('S', Items.STICK)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.COPPER_SWORD)
                        .pattern("#").pattern("#").pattern("S").input('#', Items.COPPER_INGOT).input('S', Items.STICK)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS)
                        .pattern("# #").pattern("# #").input('#', Items.COPPER_INGOT)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS)
                        .pattern("###").pattern("# #").pattern("# #").input('#', Items.COPPER_INGOT)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE)
                        .pattern("# #").pattern("###").pattern("###").input('#', Items.COPPER_INGOT)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, ModItems.COPPER_HELMET)
                        .pattern("###").pattern("# #").input('#', Items.COPPER_INGOT)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).offerTo(exporter);
            }
        };
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier identifier) {
        return identifier;
    }

    @Override
    public String getName() {
        return "Copper Backport Recipes";
    }
}
