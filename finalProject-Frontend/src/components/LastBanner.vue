<template>
    <section class="section last-banner">
        <span class="mid-banner-flex">
        <h2>Looking for an extra income? <br> Try hosting.</h2>
        <br>
        <a href="#" class="btn" @mouseenter="kiss" @mouseleave="unfocus">Learn more</a>
        </span>
    </section>
</template>

<script>
    export default {
        props : {
            kiss: { type: Function },
            unfocus: { type: Function }
        }
    }
</script>

<style>
    /* 2n banner section */

    .last-banner{
    color: var(--brown);
    padding: 6rem var(--sidePadding);
    border-radius: 1rem;
    background: url("./icons/2banner.jpg") 0% 0% / cover;
    background-size: 80rem 40rem;
    background-position: 50% 65%;
    background-repeat: no-repeat;

    }
    .last-banner span h2{
    color: var(--light);
    font-size: 2.3rem;
    }

    section.section.last-banner{
    margin-bottom: 3rem;
    }
</style>