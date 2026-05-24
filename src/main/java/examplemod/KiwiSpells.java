package examplemod;

import legend.core.GameEngine;
import legend.game.inventory.SpellRegistryEvent;
import legend.game.inventory.SpellStats0c;
import legend.lodmod.LodMod;
import legend.lodmod.spells.RetailSpell;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

public class KiwiSpells {
  private KiwiSpells() { }

  private static final Registrar<SpellStats0c, SpellRegistryEvent> REGISTRAR = new Registrar<>(GameEngine.REGISTRIES.spells, Kiwi.MOD_ID);

  public static final RegistryDelegate<SpellStats0c> RAYS = REGISTRAR.register("rays", () -> new RetailSpell(0x40, 0, 0, 0x80, 0, 100, 0, 0, LodMod.EARTH_ELEMENT, 0, 0, 0, -1));

  static void register(final SpellRegistryEvent event) {
    REGISTRAR.registryEvent(event);
  }
}
