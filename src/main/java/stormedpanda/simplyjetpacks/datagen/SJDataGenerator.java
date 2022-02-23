package stormedpanda.simplyjetpacks.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import stormedpanda.simplyjetpacks.SimplyJetpacks;

@Mod.EventBusSubscriber(modid = SimplyJetpacks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class SJDataGenerator {

    private SJDataGenerator() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(new SJItemModelProvider(gen, existingFileHelper));
        gen.addProvider(new SJItemTagsProvider(gen, new BlockTagsProvider(gen, SimplyJetpacks.MODID, existingFileHelper), existingFileHelper));
        gen.addProvider(new SJRecipeProvider(gen));
        gen.addProvider(new SJAdvancementProvider(gen));
    }
}