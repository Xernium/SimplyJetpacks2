package stormedpanda.simplyjetpacks.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.handlers.RegistryHandler;
import stormedpanda.simplyjetpacks.item.SJItem;
import stormedpanda.simplyjetpacks.item.SJItemGroup;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SimplyJetpacks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class SJDataGenerator {

    private SJDataGenerator() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // 1.20: Having this is useless, but I have no idea to avoid it
        BlockTagsProvider dummyProvider = new BlockTagsProvider(gen.getPackOutput(), event.getLookupProvider(), SimplyJetpacks.MODID, existingFileHelper) {
            @Override
            protected void addTags(HolderLookup.Provider provider) {}
        };

        // TODO: test the boolean
        gen.addProvider(true, new SJItemModelProvider(gen, existingFileHelper));
        gen.addProvider(true, new SJItemTagsProvider(gen.getPackOutput(), event.getLookupProvider(), dummyProvider.contentsGetter(), event.getExistingFileHelper()));
        gen.addProvider(true, new SJRecipeProvider(gen));
        // gen.addProvider(true, new SJAdvancementProvider(gen));// TODO 1.20: Re-enable advancements
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        // Add to ingredients tab
        if (event.getTab() instanceof SJItemGroup) {
            for (RegistryObject<Item> x : RegistryHandler.ITEMS.getEntries()) {
                event.accept(x);
            }
        }
    }
}