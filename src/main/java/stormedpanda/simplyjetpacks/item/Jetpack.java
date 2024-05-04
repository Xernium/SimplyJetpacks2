package stormedpanda.simplyjetpacks.item;

import net.minecraft.resources.ResourceLocation;

public class Jetpack {

    private final ResourceLocation resourceLocation;
    public int tier;
    public String name;
    public String displayName;

    private int energyCapacity;
    private int energyUsage;
    private int energyPerTickIn;
    private int energyPerTickOut;
    private int armorReduction;
    private int armorEnergyPerHit;
    private int enchantability;

    private double speedVertical;
    private double accelVertical;
    private double speedVerticalHover;
    private double speedVerticalHoverSlow;
    private double speedSideways;
    private double sprintSpeedModifier;
    private double sprintEnergyModifier;
    private boolean hoverMode;
    private boolean emergencyHoverMode;
    private boolean chargerMode;

    public ResourceLocation getResourceLocation() {
        return resourceLocation;
    }

    public int getEnergyCapacity() {
        return energyCapacity;
    }

    public int getEnergyUsage() {
        return energyUsage;
    }

    public int getEnergyPerTickIn() {
        return energyPerTickIn;
    }

    public int getEnergyPerTickOut() {
        return energyPerTickOut;
    }
}
