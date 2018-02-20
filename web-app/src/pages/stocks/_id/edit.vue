<template>
    <section class="hero">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">
            Edit Stock # {{id}}
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
                    <input v-model.number="currentPrice" class="input" type="number">
                  </p>
                </div>
              </div>
            </div>          
            <div class="field is-grouped is-grouped-right">
              <p class="control">
                <a class="button is-primary" @click="saveStock()">
                  Submit
                </a>
              </p>
              <p class="control">
                <nuxt-link to="/stocks" exact class="button is-light">Cancel</nuxt-link>
              </p>
            </div>      
        </div>
      </div>
    </section>
</template>

<script>
import axios from 'axios'

export default {
  asyncData({ params }) {
    return axios.get(`http://localhost:8080/api/stocks/${params.id}`)
            .then((result) => { return result.data })
  },
  methods: {
    saveStock: function () {
      var self = this
      axios.put(`http://localhost:8080/api/stocks/${this.id}`, { currentPrice: this.currentPrice })
          .then((result) => { this.$router.push('/stocks') })
    }
  }  
}
</script>