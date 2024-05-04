package stormedpanda.simplyjetpacks.registry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.resources.ResourceLocation;
import stormedpanda.simplyjetpacks.item.Jetpack;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JetpackRegistry {

    private static final JetpackRegistry INSTANCE = new JetpackRegistry();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final Map<ResourceLocation, Jetpack> jetpacks = new LinkedHashMap<>();
    private final ArrayList<Integer> tiers = new ArrayList<>();
    private int lowestTier = Integer.MAX_VALUE;
    private boolean isErrored = false;

    public void register(Jetpack jetpack) {
        if (this.jetpacks.containsKey(jetpack.getResourceLocation())) {
            this.isErrored = true;
            throw new RuntimeException(String.format("Tried to register multiple jetpacks with the same name: %s", jetpack.name));
        }

        this.jetpacks.put(jetpack.getResourceLocation(), jetpack);

        if (jetpack.tier > -1 && !this.tiers.contains(jetpack.tier)) {
            this.tiers.add(jetpack.tier);
            this.tiers.sort(Integer::compareTo);
        }

        if (jetpack.tier > -1 && jetpack.tier < this.lowestTier) {
            this.lowestTier = jetpack.tier;
        }
    }

    public List<Jetpack> getJetpacks() {
        return new ArrayList<>(this.jetpacks.values());
    }

    public List<Integer> getAllTiers() {
        return this.tiers;
    }

    public Integer getLowestTier() {
        return this.lowestTier;
    }
}
