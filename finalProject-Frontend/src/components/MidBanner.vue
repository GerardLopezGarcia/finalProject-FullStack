<template>
    <section class="section mid-banner">
        <span class="mid-banner-flex">
        <h2>Not sure where to go? <br> Perfect.</h2>
        <router-link :to="`/housecard/${randomPlaceToGo}`" class="router-link">
            <a href="#" class="btn btn-dark" @mouseenter="kiss" @mouseleave="unfocus">I'm flexible</a>
        </router-link>
        </span>
    </section>
</template>

<script>
    export default {
    props : {
        kiss: { type: Function },
        unfocus: { type: Function }
    },
    computed : {
        //al hacer click en I'm flexible nos propone un sitio al que ir
        randomPlaceToGo(){
            return Math.floor(Math.random() * 6);
        }
    }

        
    }
</script>

<style>
/* mid banner section */

    .mid-banner{
    color: var(--brown);
    padding: 6rem var(--sidePadding);
    border-radius: 1rem;
    background: url("./icons/banner.jpg") 0% 0% / cover;
    background-position: center;
    }
    .mid-banner h2 {
    font-size: clamp(1.75rem, 3vw, 2.25rem);
    line-height: 1.2;
    margin-bottom: 1.5rem;
    font-weight: 800;
    }
    .btn-dark{
        --bgcolor: var(--brown);
        --color: var(--yellow);
    }
</style>