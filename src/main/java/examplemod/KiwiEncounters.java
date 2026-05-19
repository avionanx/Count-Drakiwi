package examplemod;

import legend.game.combat.encounters.Encounter;
import org.joml.Vector3f;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

public class KiwiEncounters {
  public KiwiEncounters() { }

  private static final Registrar<KiwiEncounter, RegisterKiwiEncounterEvent> REGISTRAR = new Registrar<>(Kiwi.KIWI_ENCOUNTER_REGISTRY, Kiwi.MOD_ID);

  public static final RegistryDelegate<KiwiEncounter> COUNT_DRAKIWI = REGISTRAR.register("count_drakiwi", () -> new KiwiEncounter(241, 0, 0, new Encounter.Monster(27, new Vector3f(-3712.000000f, 0.000000f, 128.000000f))));

  static void register(final RegisterKiwiEncounterEvent event) {
    REGISTRAR.registryEvent(event);
  }
}
