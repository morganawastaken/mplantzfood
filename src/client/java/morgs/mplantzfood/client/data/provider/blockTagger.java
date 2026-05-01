package morgs.mplantzfood.client.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import morgs.mplantzfood.setup.blocks;


import java.util.concurrent.CompletableFuture;

import static joshxviii.plantz.PazTags.BlockTags.PLANTABLE;

public class blockTagger extends FabricTagsProvider.BlockTagsProvider {
	public blockTagger(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
		super(output, registryLookupFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(PLANTABLE)
                .add(blocks.ANALYZER)
				.add(blocks.EXTRACTOR);
	}
}
