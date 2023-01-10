<template>
    <section class="jumbotron" style="width: 100%;">
        <div class="innerJumbo">
        <span>
            <h1 class="main-title" id="main-h1">Travel anywhere </h1> 
            <h1 class="main-title">fast secure and free</h1>
            <router-link to="/housecard/5" class="router-link">
              <a href="#" class="btn animate__bounceIn" id="btn-landing">Explore now</a>
            </router-link>

        </span>
        </div>
    </section>
</template>

<script>
</script>

<style>
  /* landing image */
  .jumbotron{
    background: linear-gradient(to bottom, #0a0c2c80 3rem, transparent 10rem),url(./icons/forest.jpg);
    background-size: cover;
    background-position: center;
    color: var(--light);
    padding: 15rem var(--sidePadding) 6rem;
    

  }
  .innerJumbo{
    display: flex;
    max-width: var(--containerWidth);
    margin: 0 auto;
  }
  #main-h1{
    margin-bottom: 0%;
  }
</style>