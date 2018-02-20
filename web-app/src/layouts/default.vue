<template>
  <div>
    <div class="container">
    <nav class="navbar" role="navigation" aria-label="main navigation">
      <div class="navbar-menu" id="navMenu">
        <nuxt-link to="/stocks" exact class="navbar-item">Stock</nuxt-link>
        <nuxt-link to="/others" exact class="navbar-item">Other</nuxt-link>
      </div>      
    </nav>
    </div>
    <nuxt/>
  </div>
</template>

<style>
.navbar-menu a.nuxt-link-active {
  border-bottom: 1px solid #333;
  font-weight: 600;
}
</style>