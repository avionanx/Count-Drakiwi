package examplemod;

import legend.game.inventory.SpellStats0c;
import org.legendofdragoon.modloader.events.registries.RegistryEvent;
import org.legendofdragoon.modloader.registries.MutableRegistry;

public class RegisterKiwiSpellEvent extends RegistryEvent.Register<SpellStats0c> {
  public RegisterKiwiSpellEvent(final MutableRegistry<SpellStats0c> registry) {
    super(registry);
  }
}
