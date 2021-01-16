<template>
  <div id="pokemon">
    <div class="d-flex flex-column justify-content-between align-items-center">
      <img src="../assets/pikachu.png" alt="pikachu" class="pokemon" />
      <h1>Pokedex</h1>
      <ShowPokemon />
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Emit } from "vue-property-decorator";
import ShowPokemon from "./pokemon/ShowPokemon.vue";

@Component({
  components: {
    ShowPokemon
  },
})
export default class Pokemon extends Vue {}
</script>

<style>
.pokemon {
  height: 200px;
  width: 200px;
  border-radius: 50%;
}
</style>