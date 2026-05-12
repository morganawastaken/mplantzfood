package morgs.mplantzfood.setup;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import static morgs.mplantzfood.mplantzfoodMain.MOD_ID;

public class RegisterFood {
    public static void initialize(){}
    public static final Holder<MobEffect> PFood =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(MOD_ID, "pfood"),
                    new PlantFoodEffects());
}
