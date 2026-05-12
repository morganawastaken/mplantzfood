package morgs.mplantzfood.setup;

import joshxviii.plantz.entity.plant.Sunflower;
import morgs.mplantzfood.ai.SunPlantFoodGoal;
import morgs.mplantzfood.mixin.MobAccessor;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SpellParticleOption;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.GoalSelector;

import java.util.HashMap;

public class PlantFoodEffects extends MobEffect {
    protected PlantFoodEffects() {
        super(MobEffectCategory.BENEFICIAL, 2);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier){
        return super.applyEffectTick(level, entity, amplifier);
    }

    public static void sunflowerFoodEffect(int i){
        System.out.println("\"Delicious!\" - said Sunflower" + i);
    }
}

