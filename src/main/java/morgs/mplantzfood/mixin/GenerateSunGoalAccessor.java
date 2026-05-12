package morgs.mplantzfood.mixin;

import morgs.mplantzfood.pazimports.GenerateSunGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GenerateSunGoal.class)
public interface GenerateSunGoalAccessor {

    @Invoker("doAction")
    boolean callDoAction();

}
