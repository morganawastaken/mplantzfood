package morgs.mplantzfood.setup;

import joshxviii.plantz.item.SunItem;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import morgs.mplantzfood.item.plantfoodItem;

import java.util.function.Function;

import static morgs.mplantzfood.mplantzfoodMain.MOD_ID;

public class items {

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB2_KEY, CUSTOM_CREATIVE_TAB2);
    }

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static final Item plant_food = register("plant_food", SunItem::new, new Item.Properties());
    public static final Item dna = register("dna", Item::new, new Item.Properties());

    //CREATIVE TAB
    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MOD_ID, "creative_tab")
    );
    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB2_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MOD_ID, "creative_tab2")
    );

    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(items.plant_food))
            .title(Component.translatable("creativeTab.mplantzfood"))
            .displayItems((params, output) -> {
                output.accept(items.plant_food);
                output.accept(items.dna);
            })
            .build();
    public static final CreativeModeTab CUSTOM_CREATIVE_TAB2 = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(blocks.ANALYZER))
            .title(Component.translatable("creativeTab2.mplantzfood"))
            .displayItems((params, output) -> {
                output.accept(blocks.ANALYZER);
                output.accept(blocks.EXTRACTOR);
            })
            .build();
}
