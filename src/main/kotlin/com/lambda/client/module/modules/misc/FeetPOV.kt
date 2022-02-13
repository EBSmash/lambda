package com.lambda.client.module.modules.misc

import baritone.api.utils.Helper
import com.lambda.client.module.Category
import com.lambda.client.module.Module
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.entity.RenderManager
import net.minecraft.client.renderer.entity.RenderPig
import net.minecraft.entity.passive.EntityPig
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly


object FeetPOV : Module(
    name = "FeetPOV",
    category = Category.MISC,
    description = "Usefull when stuck in bedrock. allows reach blocks to blocks you couldnt otherwise reach"
) {

    @SideOnly(Side.CLIENT)
    class NoRenderPig(manager: RenderManager?, private val mc: Minecraft) : RenderPig(manager) {
        override fun doRender(pig: EntityPig, d0: Double, d1: Double, d2: Double, f1: Float, f2: Float) {
            var d1 = d1
            if (this.mc.player.ridingEntity === pig) d1 -= 0.5
            super.doRender(pig, d0, d1, d2, f1, f2)
        }
    }
    init {
        val mc = Minecraft.getMinecraft()
        mc.player.eyeHeight = 0.6f;
        Helper.mc.renderManager.entityRenderMap[EntityPig::class.java] = RenderPig(Helper.mc.renderManager)

    }

}