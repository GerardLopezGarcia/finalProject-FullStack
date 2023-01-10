<template>
    <section class="section live-anywhere">
    <h2>Live anywhere</h2>
    <div class="cards">
      <div class="card" >
        <img src="./icons/outdoor.jpg" alt="outdoor image" style="width: 100%; border-radius: 1.5rem;" class="innner-card-image" @mouseenter="focus" @mouseleave="unfocus">
        <span>
          <h3>Outdoor getaways</h3>
        </span>
      </div>
      <div class="card">
        <img src="./icons/unique.jpg" alt="outdoor image" style="width: 100%; border-radius: 1.5rem;" class="innner-card-image" @mouseenter="focus" @mouseleave="unfocus">
        <span>
          <h3>Unique stays</h3>
        </span>
      </div>
      <div class="card">
        <img src="./icons/entire.jpg" alt="outdoor image" style="width: 100%; border-radius: 1.5rem;" class="innner-card-image" @mouseenter="focus" @mouseleave="unfocus">
        <span>
          <h3>Entire homes</h3>
        </span>
      </div>
      <div class="card">
        <img src="./icons//pets.jpg" alt="outdoor image" style="width: 100%; border-radius: 1.5rem;" class="innner-card-image" @mouseenter="focus" @mouseleave="unfocus">
        <span>
          <h3>Pets allowed</h3>
        </span>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  props : {
    focus: { type: Function },
    unfocus: { type: Function }
  }
}
</script>

<style>
    /* live anywhere section */

    .cards{
    /* display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 1.5rem;
    padding: 1.5rem 0px; */

    display: flex;
    }
    .card {
    width: 30%;
    padding: 1rem;
    display: flex;
    flex-direction: column;
    cursor: pointer;
    justify-content: space-between;
    align-items: flex-start;
    }
    .card span h3 {
    font-size: 1.25rem;
    padding-top: 1.4rem;
    }

    .inner-card-image{
    height: 20%;
    }
</style>