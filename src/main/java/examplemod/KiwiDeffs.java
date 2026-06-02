package examplemod;

import legend.game.combat.deff.DeffPackage;
import legend.game.combat.deff.RegisterDeffsEvent;
import org.legendofdragoon.modloader.registries.Registrar;
import org.legendofdragoon.modloader.registries.RegistryDelegate;

import static examplemod.Kiwi.MOD_ID;
import static legend.core.GameEngine.REGISTRIES;

public final class KiwiDeffs {
  private KiwiDeffs() { }

  private static final Registrar<DeffPackage, RegisterDeffsEvent> REGISTRAR = new Registrar<>(REGISTRIES.deff, MOD_ID);

  public static final RegistryDelegate<DeffPackage> EXPLOSION = REGISTRAR.register("explosion", KiwiBossDeffPackage::new);
  public static final RegistryDelegate<DeffPackage> KIWI_RAIN = REGISTRAR.register("kiwi_rain", KiwiBossDeffPackage::new);
  public static final RegistryDelegate<DeffPackage> RAYS = REGISTRAR.register("rays", KiwiBossDeffPackage::new);
  public static final RegistryDelegate<DeffPackage> SUCKY_SUCKY = REGISTRAR.register("sucky_sucky", KiwiBossDeffPackage::new);
  public static final RegistryDelegate<DeffPackage> DEVOUR = REGISTRAR.register("devour", KiwiBossDeffPackage::new);

  static void register(final RegisterDeffsEvent event) {
    REGISTRAR.registryEvent(event);
  }
}
