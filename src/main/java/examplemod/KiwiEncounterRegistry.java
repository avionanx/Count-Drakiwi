package examplemod;

import legend.game.combat.encounters.Encounter;
import org.legendofdragoon.modloader.registries.MutableRegistry;

public class KiwiEncounterRegistry extends MutableRegistry<Encounter> {
  public KiwiEncounterRegistry() {
    super(Kiwi.id("encounter"));
  }
}
