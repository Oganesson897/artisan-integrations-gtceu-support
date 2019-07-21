package com.codetaylor.mc.artisanintegrations;

import com.codetaylor.mc.artisanintegrations.modules.gamestages.ModuleGameStages;
import com.codetaylor.mc.artisanintegrations.modules.gregtech.ModuleGregTech;
import com.codetaylor.mc.artisanintegrations.modules.reskillable.ModuleReskillable;
import com.codetaylor.mc.artisanworktables.modules.worktables.ModuleWorktables;
import com.codetaylor.mc.athenaeum.gui.GuiHandler;
import com.codetaylor.mc.athenaeum.module.ModuleManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@SuppressWarnings({"WeakerAccess", "unused"})
@Mod(
    modid = ModArtisanIntegrations.MOD_ID,
    version = ModArtisanIntegrations.VERSION,
    name = ModArtisanIntegrations.NAME
    //@@DEPENDENCIES@@
)
public class ModArtisanIntegrations {

  public static final String MOD_ID = "artisanintegrations";
  public static final String VERSION = "@@VERSION@@";
  public static final String NAME = "Artisan Integrations";

  @Mod.Instance
  public static ModArtisanIntegrations INSTANCE;

  public static final CreativeTabs CREATIVE_TAB = ModuleWorktables.CREATIVE_TAB;

  private final ModuleManager moduleManager;

  public ModArtisanIntegrations() {

    this.moduleManager = new ModuleManager(MOD_ID);
  }

  @Mod.EventHandler
  public void onConstructionEvent(FMLConstructionEvent event) {

    if (Loader.isModLoaded("gamestages")) {
      this.moduleManager.registerModules(ModuleGameStages.class);
    }

    if (Loader.isModLoaded("reskillable")) {
      this.moduleManager.registerModules(ModuleReskillable.class);
    }

    if (Loader.isModLoaded("gregtech")) {
      this.moduleManager.registerModules(ModuleGregTech.class);
    }

    this.moduleManager.onConstructionEvent();
    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onPreInitializationEvent(FMLPreInitializationEvent event) {

    NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onInitializationEvent(FMLInitializationEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onPostInitializationEvent(FMLPostInitializationEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onLoadCompleteEvent(FMLLoadCompleteEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerAboutToStartEvent(FMLServerAboutToStartEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerStartingEvent(FMLServerStartingEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerStartedEvent(FMLServerStartedEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerStoppingEvent(FMLServerStoppingEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerStoppedEvent(FMLServerStoppedEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

}
