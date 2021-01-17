<template>
  <div id="app">
    <button
      type="button"
      class="btn btn-outline-primary"
      style="overflow: hidden; float: left"
      @click="apiSwitch()"
    >
      Switch
    </button>
    <button
      type="button"
      class="btn btn-outline-primary"
      style="overflow: hidden; float: right"
      @click="showModal = true; getHistory();"
      
    >
      History
    </button>
    <div v-if="showModal">
      <transition name="modal">
        <div class="modal-mask d-flex justify-content-center">
          <div class="modal-wrapper">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">History</h5>
                  <button
                    type="button"
                    class="close"
                    data-dismiss="modal"
                    aria-label="Close"
                  >
                    <span aria-hidden="true" @click="showModal = false"
                      >&times;</span
                    >
                  </button>
                </div>
                <div class="modal-body">
                  <ul class="list-group">
                    <li
                      v-for="request of history"
                      :key="request.request"
                      class="list-group-item"
                    >
                      Request: {{ request.request }}
                      <br />
                      Response Code: {{ request.responseCode }}
                    </li>
                  </ul>
                </div>
                <div class="modal-footer">
                  <button
                    type="button"
                    class="btn btn-secondary"
                    @click="showModal = false"
                  >
                    Close
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </transition>
    </div>
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
import History from "./components/History.vue";
import axios from "axios";

@Component({
  components: {
    DadJoke,
    Pokemon,
    History,
  },
})
export default class App extends Vue {
  private dadApi = true;
  private showModal = false;
  private history = [];

  apiSwitch() {
    this.dadApi = !this.dadApi;
  }

  async getHistory() {
    await axios
      .get("http://localhost:8080/history")
      .then((res) => {
        this.history = res.data;
        console.log(this.history);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  mounted() {
    this.getHistory();
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

.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  /* display: table; */
  transition: opacity 0.3s ease;
  overflow-y: auto !important;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}
</style>
