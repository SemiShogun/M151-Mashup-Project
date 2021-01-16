<template>
  <div id="showpokemon">
    <div class="input-group mb-3">
      <input
        type="text"
        class="form-control"
        placeholder="Search for the ID or the name of the pokemon"
        v-model="input"
      />
      <div class="input-group-append">
        <button
          class="btn btn-outline-secondary"
          type="button"
          @click="findPokemon()"
        >
          Button
        </button>
      </div>
    </div>
    <div style="height: 1rem"></div>

    <div v-if="pokemon">
      <div class="d-flex flex-row justify-content-between">
        <div class="col-8 d-flex flex-column justify-content-start">
          <h1>
            <strong>{{ pokemon.name }}</strong>
          </h1>
          <p><strong>Height:</strong> {{ pokemon.height }}</p>
          <p><strong>Weight:</strong> {{ pokemon.weight }}</p>
          <p><strong>Base-Experience:</strong> {{ pokemon.base_experience }}</p>
          <p><strong>Abilities</strong></p>
          <ul class="list-group">
            <li
              v-for="ability in pokemon.abilities"
              :key="ability.ability.name"
              class="list-group-item"
            >
              {{ ability.ability.name }}
              <br />
              Slot: {{ ability.slot }}
            </li>
          </ul>
          <p><strong>Types</strong></p>
          <ul class="list-group">
            <li
              v-for="type of pokemon.types"
              :key="type.type.name"
              class="list-group-item"
            >
              {{ type.type.name }}
            </li>
          </ul>
          <p><strong>Moves</strong></p>
          <ul class="list-group">
            <li
              v-for="move of pokemon.moves"
              :key="move.move.name"
              class="list-group-item"
            >
              {{ move.move.name }}
            </li>
          </ul>
          <p><strong>Stats</strong></p>
          <ul class="list-group">
            <li
              v-for="stat of pokemon.stats"
              :key="stat.stat.name"
              class="list-group-item"
            >
              {{ stat.stat.name }}
              <br />
              base_stat: {{ stat.base_stat }}
              <br />
              effort: {{ stat.effort }}
            </li>
          </ul>
        </div>
        <div class="col-4 d-flex justify-content-center align-items-start">
          <img
            :src="pokemon.sprites.front_default"
            alt="pokemon_image"
            class="image"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Emit } from "vue-property-decorator";
import axios from "axios";

@Component({})
export default class ShowPokemon extends Vue {
  private pokemon = null;
  private input = "";

  async findPokemon() {
    if (isNaN(this.input)) {
      await axios
        .get(`http://localhost:8080/pokemon/name/${this.input.toLowerCase()}`)
        .then((res) => {
          this.pokemon = res.data;
          this.reformatName();
        })
        .catch((e) => {
          console.log(e);
        });
    } else {
      await axios
        .get(`http://localhost:8080/pokemon/${this.input}`)
        .then((res) => {
          this.pokemon = res.data;
          this.reformatName();
        })
        .catch((e) => {
          console.log(e);
        });
    }
  }

  reformatName() {
    if (typeof this.pokemon === "undefined" || this.pokemon != null) {
      this.pokemon.name =
        this.pokemon.name[0].toUpperCase() +
        this.pokemon.name.substr(1).toLowerCase();
    }
  }
}
</script>

<style>
#showpokemon {
  margin-top: 1rem;
  width: 250%;
}

.image {
  width: 150%;
}

.list-group {
  margin-bottom: 1rem !important;
}
</style>