package stormedpanda.simplyjetpacks.integration;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import stormedpanda.simplyjetpacks.SimplyJetpacks;
import stormedpanda.simplyjetpacks.model.JetpackModelLayers;
import stormedpanda.simplyjetpacks.model.JetpackModelNew;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class PilotGogglesRenderer implements ICurioRenderer {

    public PilotGogglesRenderer(ResourceLocation texture) {
        this.texture = texture;
    }

    private final ResourceLocation texture;

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        HumanoidModel<LivingEntity> model = new HumanoidModel<LivingEntity>(1.0F);
        HumanoidModel<LivingEntity> model2 = HumanoidModel.createMesh(CubeDeformation.NONE, 1.0F);
        HumanoidModel<LivingEntity> model3 = new HumanoidModel<LivingEntity>();
        model.setupAnim(slotContext.entity(), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ICurioRenderer.followHeadRotations(slotContext.entity(), model.getHead());
//        ICurioRenderer.followBodyRotations(slotContext.entity(), model);
        model.getHead().render(matrixStack, ItemRenderer.getArmorFoilBuffer(renderTypeBuffer, model.renderType(texture), false, stack.hasFoil()), light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
//        model.renderToBuffer(matrixStack, ItemRenderer.getFoilBuffer(renderTypeBuffer, model.renderType(texture), false, stack.hasFoil()), light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
    }
}