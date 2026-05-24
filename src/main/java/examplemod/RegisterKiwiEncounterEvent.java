package examplemod;

import legend.game.combat.encounters.Encounter;
import org.legendofdragoon.modloader.events.registries.RegistryEvent;
import org.legendofdragoon.modloader.registries.MutableRegistry;

public class RegisterKiwiEncounterEvent extends RegistryEvent.Register<Encounter> {
  public RegisterKiwiEncounterEvent(final MutableRegistry<Encounter> registry) {
    super(registry);
  }
}
