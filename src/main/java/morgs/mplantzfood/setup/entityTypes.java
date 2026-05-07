package morgs.mplantzfood.setup;

import joshxviii.plantz.entity.plant.Plant;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import static morgs.mplantzfood.mplantzfoodMain.MOD_ID;

public class entityTypes {
    public static <T extends Entity> EntityType<T> registerEntity(String id, EntityType.Builder builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, id));
        return Registry.register(
                BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }
}



