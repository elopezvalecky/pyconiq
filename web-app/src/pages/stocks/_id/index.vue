<template>
    <section class="hero">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">
            Stock # {{id}}
          </h1>
            <div class="field is-horizontal">
              <div class="field-label is-normal">
                <label class="label">Name</label>
              </div>
              <div class="field-body">
                <div class="field">
                  <p class="control">
                    <input v-model="name" class="input is-static" type="text" readonly>
                  </p>
                </div>
              </div>
            </div>          
            <div class="field is-horizontal">
              <div class="field-label is-normal">
                <label class="label">Price</label>
              </div>
              <div class="field-body">
                <div class="field">
                  <p class="control">
                    <input v-model="currentPrice" class="input is-static" type="text" readonly>
                  </p>
                </div>
              </div>
            </div>          
            <div class="field is-horizontal">
              <div class="field-label is-normal">
                <label class="label">Updated</label>
              </div>
              <div class="field-body">
                <div class="field">
                  <p class="control">
                    <input v-model="formattedDate" class="input is-static" type="text" readonly>
                  </p>
                </div>
              </div>
            </div>          
        </div>
      </div>
    </section>
</template>

<script>
import axios from 'axios'
import moment from 'moment'

export default {
  asyncData({ params }) {
    return axios.get(`http://localhost:8080/api/stocks/${params.id}`)
            .then((result) => { return result.data })
  },
  computed: {
    formattedDate() {
      return moment.unix(this.lastUpdate).fromNow()
    }
  }
}
</script>