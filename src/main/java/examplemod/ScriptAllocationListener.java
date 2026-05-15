package examplemod;

import legend.game.modding.events.battle.MonsterStatsEvent;
import legend.game.modding.events.scripting.ScriptAllocatedEvent;
import legend.game.scripting.ScriptFile;
import legend.game.unpacker.FileData;
import legend.game.unpacker.Loader;
import org.legendofdragoon.modloader.events.EventListener;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import static legend.core.GameEngine.EVENTS;
import static legend.core.GameEngine.SCRIPTS;
import static legend.game.Scus94491BpeSegment_8006.battleState_8006e398;

public class ScriptAllocationListener {
  final Runnable clearListener;

  public ScriptAllocationListener(final Runnable clearListener) {
    EVENTS.register(this);

    this.clearListener = clearListener;
  }

  @EventListener
  public void ScriptAllocatedEvent(final MonsterStatsEvent event) {
    //if(event.scriptIndex == 11) {
      try {
        final Path path = Loader.resolve("..").normalize().toRealPath(LinkOption.NOFOLLOW_LINKS).resolve("mods/drakiwi/scripts/drakiwi");
        final FileData file = Loader.loadFile(path);
        battleState_8006e398.monsterBents_e50[0].innerStruct_00.combatant_144.scriptPtr_10 = new ScriptFile("sucky sucky", file.getBytes());
      } catch(final IOException e) {
        throw new RuntimeException(e);
      }
    this.clearListener.run();
    //}
  }
}
