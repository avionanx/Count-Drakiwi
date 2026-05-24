package examplemod;

import legend.game.combat.Battle;
import legend.game.combat.deff.DeffPackage;
import legend.game.unpacker.Loader;

import java.io.IOException;
import java.nio.file.LinkOption;

import static legend.game.EngineStates.currentEngineState_8004dd04;

public class KiwiBossDeffPackage extends DeffPackage {

  public KiwiBossDeffPackage() {

  }

  @Override
  public void load() {
    try {
      ((Battle)currentEngineState_8004dd04).loadDeff(
        Loader.resolve("..").normalize().toRealPath(LinkOption.NOFOLLOW_LINKS).resolve("mods/drakiwi/deffs/%s/textures".formatted(this.getRegistryId().entryId())),
        Loader.resolve("..").normalize().toRealPath(LinkOption.NOFOLLOW_LINKS).resolve("mods/drakiwi/deffs/%s/scripts".formatted(this.getRegistryId().entryId())));
    } catch(final IOException e) {
      throw new RuntimeException(e);
    }
  }
}
