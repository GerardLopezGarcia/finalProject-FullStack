<template>
<div :class="colorMode">
  <span >
    <h2 class="animate-footer">About</h2>
    <ul class="animate-footer">
      <li >How Housing works</li>
      <li >Newsroom</li>
      <li >Housing 2021</li>
      <li >Investors</li>
      <li >Housing Plus</li>
      <li >Housing Luxe</li>
    </ul>
  </span>
  <span >
    <h2 class="animate-footer">Community</h2>
    <ul class="animate-footer"> 
      <li>Diversity & Belonging</li>
      <li>Accessibility</li>
      <li>Housing Associates</li>
      <li>Frontline Stays</li>
      <li>Guest Referrals</li>
      <li>Housing.org</li>
    </ul>
  </span>
  <span >
    <h2 class="animate-footer">Host</h2>
    <ul class="animate-footer">
      <li>Host your home</li>
      <li>Host an Online Experience</li>
      <li>Host an Experience</li>
      <li>Responsible hosting</li>
      <li>Resource Centre</li>
      <li>Community Centre</li>
    </ul>
  </span>
  <span >
    <h2 class="animate-footer">Support</h2>
    <ul class="animate-footer">
      <li>Our COVID-19 Response</li>
      <li>Help Centre</li>
      <li>Cancellation options</li>
      <li>Neighbourhood Support</li>
      <li>Trust & Safety</li>
    </ul>
  </span>
</div>

</template>

<script>
import { mapState, mapActions } from "pinia";
import { useStoreStore } from "../store/store";

  export default {
    computed: {    
     // gives read access to this.countries and this.anotherVar
    ...mapState(useStoreStore, ['colorMode'])
    },
  }
</script>

<style scoped>
h2 {
    font-size: 1rem;
    text-transform: uppercase;
    margin-bottom: 0.5rem;
    font-weight: 800;
  }
  .light{
    padding: 3rem var(--sidePadding);
    background: var(--light);
    border-top: 1px solid #0002;
    display: flex;
    justify-content: space-evenly;
  }
  .dark{
    padding: 3rem var(--sidePadding);
    background: var(--gray);
    border-top: 1px solid #0002;
    display: flex;
    justify-content: space-evenly;
  }

    ul {
      list-style: none;
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    }
    li {
        padding: 0.25rem 0;
        font-size: 0.85rem;
        cursor: pointer;
        opacity: 0.8;
        transition: all 0.2s;
        width: fit-content;
      }
    .footer-bottom {
      display: flex;
      flex-direction: row-reverse;
      align-items: flex-end;
      justify-content: space-between;
    }

    a {
    margin-left: 0.5rem;
    }
    a:hover {
    text-decoration: underline;
    color: var(--red);
    }
    svg {
    height: 1rem;
    }
    svg.globe {
    margin-right: 0.1rem;
    }
    svg.dollar {
    margin-right: -0.1rem;
    }
    span + span {
    margin-left: 1rem;
    }
    p,
    span {
    display: flex;
    align-items: center;
    flex-direction: column;
    align-items: stretch;
    }

</style>

