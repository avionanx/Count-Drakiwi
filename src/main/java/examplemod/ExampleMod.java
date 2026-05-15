package examplemod;

import legend.game.inventory.ItemRegistryEvent;
import org.legendofdragoon.modloader.Mod;
import org.legendofdragoon.modloader.events.EventListener;
import org.legendofdragoon.modloader.registries.RegistryId;

import static legend.core.GameEngine.EVENTS;

@Mod(id = ExampleMod.MOD_ID, version = "3.0.0")
public class ExampleMod {
  public static final String MOD_ID = "examplemod";

  public ExampleMod() {
    EVENTS.register(this);
  }

  public static RegistryId id(final String entryId) {
    return new RegistryId(MOD_ID, entryId);
  }

  @EventListener
  public void registerItems(final ItemRegistryEvent event) {
    System.out.println("Registering items");
  }
}
