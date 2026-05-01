package morgs.mplantzfood.client.data.provider;

import joshxviii.plantz.PazItems;
import morgs.mplantzfood.setup.blocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import morgs.mplantzfood.setup.items;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class recipeMaker extends FabricRecipeProvider {
    public recipeMaker(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture){
        super(output, registriesFuture);
    }
    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                //RECIPES
                shapeless(RecipeCategory.MISC, items.plant_food, 3)
                        .requires(PazItems.SUN).requires(Items.BONE_MEAL).requires(items.dna)
                        .unlockedBy(getHasName(items.dna), has(items.dna))
                        .save(output);

                shaped(RecipeCategory.MISC, blocks.EXTRACTOR, 1)
                        .pattern("RS")
                        .pattern("ID")
                        .define('R', Items.REDSTONE).define('S', PazItems.SUN).define('I', Blocks.IRON_BLOCK).define('D', Blocks.DROPPER)
                        .group("group_dna")
                        .unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "recipeMaker";
    }
}
