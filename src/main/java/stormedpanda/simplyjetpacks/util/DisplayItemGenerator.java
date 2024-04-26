package stormedpanda.simplyjetpacks.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.Objects;
import java.util.function.Supplier;

@FunctionalInterface
public interface DisplayItemGenerator {

    void accept(CreativeModeTab.ItemDisplayParameters var1, Output var2);

    static CreativeModeTab.DisplayItemsGenerator create(DisplayItemGenerator generator) {
        return (parameters, output) -> {
            generator.accept(parameters, DisplayItemGenerator.Output.from(output));
        };
    }

    public interface Output extends CreativeModeTab.Output {
        static Output from(CreativeModeTab.Output output) {
            Objects.requireNonNull(output);
            return output::accept;
        }

        default void accept(Supplier<? extends ItemLike> item) {
            this.accept(new ItemStack((ItemLike)item.get()));
        }
    }

}
