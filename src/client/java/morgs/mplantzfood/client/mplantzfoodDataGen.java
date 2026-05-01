package morgs.mplantzfood.client;

import morgs.mplantzfood.client.data.provider.blockTagger;
import morgs.mplantzfood.client.data.provider.recipeMaker;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class mplantzfoodDataGen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(blockTagger::new);
		pack.addProvider(recipeMaker::new);
	}
}
