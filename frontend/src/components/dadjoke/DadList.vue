<template>
  <div id="dadlist">
    <button class="btn btn-primary" type="button" @click="generateJoke()">
      Generate Dadjoke
    </button>
    <div style="height: 1rem"></div>
    <p>{{ dadjoke }}</p>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Emit } from "vue-property-decorator";
import axios from "axios";

@Component({})
export default class DadList extends Vue {
  dadjoke = "";

  async generateJoke() {
    await axios
      .get("http://localhost:8080/dadjoke")
      .then((res) => {
        this.dadjoke = res.data.joke;
        console.log(this.dadjoke);
      })
      .catch((e) => {
        console.log(e);
      });
  }
}
</script>

<style>
#dadlist {
  margin-top: 1rem;
}
</style>