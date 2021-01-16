<template>
  <div id="app">
    <button
      type="button"
      class="btn btn-outline-primary"
      style="overflow: hidden; float: left;"
      @click="apiSwitch()"
    >
      Switch
    </button>
    <div class="size d-flex justify-content-center align-items-center">
      <div v-if="dadApi === true">
        <DadJoke />
      </div>
      <div v-if="dadApi === false">
        <Pokemon />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import DadJoke from "./components/DadJoke.vue";
import Pokemon from "./components/Pokemon.vue";

@Component({
  components: {
    DadJoke,
    Pokemon,
  },
})
export default class App extends Vue {
  private dadApi: boolean = true;

  apiSwitch() {
    this.dadApi = !this.dadApi;
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 5rem 5rem 0rem 5rem;
}
</style>
