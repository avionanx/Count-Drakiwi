package examplemod;

import org.legendofdragoon.modloader.events.registries.RegistryEvent;
import org.legendofdragoon.modloader.registries.MutableRegistry;

public class RegisterKiwiEncounterEvent extends RegistryEvent.Register<KiwiEncounter> {
  public RegisterKiwiEncounterEvent(final MutableRegistry<KiwiEncounter> registry) {
    super(registry);
  }
}
