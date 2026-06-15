package examplemod;

import legend.core.AddRegistryEvent;
import legend.game.combat.Battle;
import legend.game.combat.SBtld;
import legend.game.combat.deff.RegisterDeffsEvent;
import legend.game.combat.encounters.Encounter;
import legend.game.inventory.SpellRegistryEvent;
import legend.game.inventory.SpellStats0c;
import legend.game.modding.events.battle.MonsterStatsEvent;
import legend.game.modding.events.engine.EngineStateChangeEvent;
import legend.game.modding.events.input.InputPressedEvent;
import legend.game.submap.SMap;
import legend.game.submap.SubmapState;
import org.legendofdragoon.modloader.Mod;
import org.legendofdragoon.modloader.events.EventListener;
import org.legendofdragoon.modloader.registries.Registry;
import org.legendofdragoon.modloader.registries.RegistryId;

import static examplemod.KiwiEncounters.COUNT_DRAKIWI;
import static legend.core.GameEngine.EVENTS;
import static legend.game.EngineStates.currentEngineState_8004dd04;
import static legend.game.Scus94491BpeSegment_8005.submapCut_80052c30;
import static legend.lodmod.LodMod.DARK_ELEMENT;
import static legend.lodmod.LodMod.INPUT_ACTION_SMAP_INTERACT;

@Mod(id = Kiwi.MOD_ID, version = "3.0.0")
public class Kiwi {
  public static final String MOD_ID = "drakiwi";

  private ScriptAllocationListener scriptAllocationListener;
  private boolean isKiwiEncounter;

  public static final Registry<Encounter> KIWI_ENCOUNTER_REGISTRY = new KiwiEncounterRegistry();
  public static final Registry<SpellStats0c> KIWI_SPELL_REGISTRY = new KiwiSpellRegistry();

  public Kiwi() {
    EVENTS.register(this);
  }

  public static RegistryId id(final String entryId) {
    return new RegistryId(MOD_ID, entryId);
  }


  @EventListener
  public void onEngineStateChanged(final EngineStateChangeEvent event) {
    if(event.engineState instanceof Battle && this.isKiwiEncounter) {
      this.scriptAllocationListener = new ScriptAllocationListener(() -> this.scriptAllocationListener = null);
    }
  }

  @EventListener
  public void onInputPressed(final InputPressedEvent event) {
    if(submapCut_80052c30 == 8 && event.action == INPUT_ACTION_SMAP_INTERACT.get()) {
      this.isKiwiEncounter = true;
      SBtld.startEncounter(COUNT_DRAKIWI.get(), 38);
      ((SMap)currentEngineState_8004dd04).smapLoadingStage_800cb430 = SubmapState.TRANSITION_TO_COMBAT_19;
    }
  }

  @EventListener
  public void onMonsterStatsEvent(final MonsterStatsEvent event) {
    if(this.isKiwiEncounter) {
      this.isKiwiEncounter = false;

      event.maxHp = 40000;
      event.hp = 40000;

      event.attack = 250;
      event.magicAttack = 200;
      event.defence = 160;
      event.magicDefence = 220;
      event.speed = 40;
      event.statusResistFlag = 0xff;
      event.specialEffectFlag = 0x90;
      event.elementFlag = DARK_ELEMENT.get();

      ((Battle)currentEngineState_8004dd04).currentEnemyNames_800c69d0[0] = "Count Drakiwi";
    }
  }

  @EventListener
  public void registerRegistries(final AddRegistryEvent event) {
    event.addRegistry(KIWI_ENCOUNTER_REGISTRY, RegisterKiwiEncounterEvent::new);
    event.addRegistry(KIWI_SPELL_REGISTRY, RegisterKiwiSpellEvent::new);
  }

  @EventListener
  public void registerKiwiEncounters(final RegisterKiwiEncounterEvent event) {
    KiwiEncounters.register(event);
  }

  @EventListener
  public void registerKiwiSpells(final SpellRegistryEvent event) {
    KiwiSpells.register(event);
  }

  @EventListener
  public void deffRegistry(final RegisterDeffsEvent event) {
    KiwiDeffs.register(event);
  }
}
