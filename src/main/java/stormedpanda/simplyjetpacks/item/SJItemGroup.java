package stormedpanda.simplyjetpacks.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.handlers.RegistryHandler;
import stormedpanda.simplyjetpacks.util.DisplayItemGenerator;

public final class SJItemGroup {

    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimplyJetpacks.MODID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = REGISTRY.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.simplyjetpacks"))
            .icon(() -> {
                return new ItemStack(RegistryHandler.LEATHER_STRAP.get());
            })
            .displayItems(DisplayItemGenerator.create((parameters, output) -> {
                output.accept(RegistryHandler.LEATHER_STRAP.get());

            }))
            .build());
}
