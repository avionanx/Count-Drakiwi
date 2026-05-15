package examplemod;

import legend.core.MathHelper;
import legend.game.combat.Battle;
import legend.game.combat.bent.MonsterBattleEntity;
import legend.game.inventory.ItemRegistryEvent;
import legend.game.modding.events.battle.CombatantModelLoadedEvent;
import legend.game.modding.events.engine.EngineStateChangeEvent;
import legend.game.scripting.ScriptState;
import org.legendofdragoon.modloader.Mod;
import org.legendofdragoon.modloader.events.EventListener;
import org.legendofdragoon.modloader.registries.RegistryId;

import static legend.core.GameEngine.EVENTS;
import static legend.core.GameEngine.SCRIPTS;
import static legend.game.Scus94491BpeSegment_8006.battleState_8006e398;
import static legend.game.combat.bent.BattleEntity27c.FLAG_MONSTER;

@Mod(id = ExampleMod.MOD_ID, version = "3.0.0")
public class ExampleMod {
  public static final String MOD_ID = "examplemod";
  private ScriptAllocationListener scriptAllocationListener;

  public ExampleMod() {
    EVENTS.register(this);
  }

  public static RegistryId id(final String entryId) {
    return new RegistryId(MOD_ID, entryId);
  }


  @EventListener
  public void onEngineStateChanged(final EngineStateChangeEvent event) {
    if(event.engineState instanceof Battle) {
      this.scriptAllocationListener = new ScriptAllocationListener(() -> this.scriptAllocationListener = null);
    }
  }
}
