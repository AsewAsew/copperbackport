package asewasew.copperbackport.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static final TagKey<Block> NEEDS_COPPER_TOOL = createBlockTag("needs_copper_tool");
    public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createBlockTag("incorrect_for_copper_tool");

    public static final TagKey<Item> COPPER_REPAIR = TagKey.of(RegistryKeys.ITEM, Identifier.ofVanilla("copper_repair"));

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.ofVanilla(name));
    }
}
