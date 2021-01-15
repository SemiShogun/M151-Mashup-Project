<template>
  <div id="app">
    <div class="size d-flex justify-content-center align-items-center">
      <DadJoke />
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import DadJoke from "./components/DadJoke.vue";

@Component({
  components: {
    DadJoke,
  },
})
export default class App extends Vue {}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0rem 5rem 0rem 5rem;
  height: 100vh;
}

.size {
  height: 100%;
}
</style>
