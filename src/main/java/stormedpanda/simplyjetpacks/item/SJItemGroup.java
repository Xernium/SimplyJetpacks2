package stormedpanda.simplyjetpacks.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.RegistryObject;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.handlers.RegistryHandler;

import javax.annotation.Nonnull;

public class SJItemGroup extends CreativeModeTab {

    public SJItemGroup() {
        super(CreativeModeTab.builder()
                .title(Component.translatable("itemGroup." + SimplyJetpacks.MODID + ".main"))
                .icon(()-> new ItemStack(RegistryHandler.JETPACK_CREATIVE.get()))
                .displayItems((params, output) -> {
                    for(RegistryObject<Item> i : RegistryHandler.ITEMS.getEntries()) {
                        Item item = i.get();
                        output.accept(new ItemStack(item));
                        if (item instanceof JetpackItem jetpackItem) {
                            output.accept(jetpackItem.asChargedCopy());
                        }
                    }
                }));
    }
}
