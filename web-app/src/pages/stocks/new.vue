<template>
    <section class="hero">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">
            New Stock
          </h1>
            <div class="field">
              <label class="label">Name</label>
              <div class="control">
                <input v-model="name" class="input" type="text" placeholder="Name">
              </div>
            </div>
            <div class="field">
              <label class="label">Price</label>
              <div class="control">
                <input v-model.number="price" class="input" type="number" placeholder="Price">
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
  data: function () {
    return {
      name: '',
      price: 0.0
    };
  },
  methods: {
    saveStock: function () {
      axios.post('http://localhost:8080/api/stocks', { name: this.name, currentPrice: this.price })
          .then((result) => { this.$router.push('/stocks') })
    }
  }  
}
</script>