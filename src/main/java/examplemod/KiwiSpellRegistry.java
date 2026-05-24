package examplemod;

import legend.game.inventory.SpellStats0c;
import org.legendofdragoon.modloader.registries.MutableRegistry;

public class KiwiSpellRegistry extends MutableRegistry<SpellStats0c> {
  public KiwiSpellRegistry() {
    super(Kiwi.id("spells"));
  }
}