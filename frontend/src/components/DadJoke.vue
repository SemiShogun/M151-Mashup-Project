<template>
  <div id="dadjoke">
    <img src="../assets/dad_zoomed.png" alt="my-dad" class="dad" />
    <div class="d-flex flex-column justify-content-between">
      <h1>DadJoke Generator</h1>
      <DadList />
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Emit } from "vue-property-decorator";
import DadList from "./dadjoke/DadList.vue";

@Component({
  components: {
    DadList,
  },
})
export default class DadJoke extends Vue {}
</script>

<style>
.dad {
  height: 200px;
  border-radius: 50%;
}
</style>