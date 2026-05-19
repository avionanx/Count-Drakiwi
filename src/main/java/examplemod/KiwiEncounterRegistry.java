package examplemod;

import org.legendofdragoon.modloader.registries.MutableRegistry;

public class KiwiEncounterRegistry extends MutableRegistry<KiwiEncounter> {
  public KiwiEncounterRegistry() {
    super(Kiwi.id("encounter"));
  }
}
