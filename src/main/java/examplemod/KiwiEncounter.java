package examplemod;

import legend.game.combat.encounters.Encounter;
import org.legendofdragoon.modloader.registries.RegistryEntry;

public class KiwiEncounter extends Encounter {
  public KiwiEncounter(final int musicIndex, final int postCombatSubmapCut, final int postCombatSubmapScene, final Monster... monsters) {
    super(musicIndex, 0, 0, 0, 0, 0, 0, 0, postCombatSubmapCut, postCombatSubmapScene, monsters);
  }
}
