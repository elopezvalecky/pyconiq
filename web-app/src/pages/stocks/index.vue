<template>
<section class="hero">
  <div class="hero-body">
    <div class="container">
      <div class="level">
        <div class="level-left">
          <h1 class="title">
            Stocks
          </h1>
        </div>
        <div class="level-right">
          <nuxt-link to="/stocks/new" exact class="button">New</nuxt-link>
        </div>
      </div>
        <table class="table is-striped is-fullwidth">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Price</th>
              <th>Updated</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="stock in data">
              <th>{{stock.id}}</th>
              <td>{{stock.name}}</td>
              <td>$ {{stock.currentPrice}}</td>
              <td>{{formatDate(stock.lastUpdate)}}</td>
              <td>
                <span class="icon button" title="Edit" @click="editStock(stock.id)">
                  <i class="fa fa-pencil"></i>
                </span>              
                <span class="icon button" title="Remove" @click="removeStock(stock.id)">
                  <i class="fa fa-remove"></i>
                </span>              
              </td>
            </tr>                      
          </tbody>
        </table>      
    </div>
  </div>
</section>
</template>

<script>
import axios from 'axios'
import moment from 'moment'

export default {

  asyncData() {
    return axios.get('http://localhost:8080/api/stocks?size=100')
        .then((result) => { return result.data })
  },

  methods: {
    formatDate(timestamp) {
      return moment.unix(timestamp).fromNow()
    },
    editStock(id) {
        this.$router.push({ name: 'stocks-id-edit', params: { id }})
    },
    removeStock(id) {
      axios.delete(`http://localhost:8080/api/stocks/${id}`)
          .then((result) => { window.location.reload() })
    }
  }
  
}
</script>