<template>
  <div :class="colorMode">
    <Header :users="users" />
    <LandingSection />
    <div class="media-width">
      <section class="section">
        <ul class="house-grid">
          <li v-for="(house, index) in houses" :key="index" @mouseenter="focus" @mouseleave="unfocus">
            <HouseCard :house="houses[index]" />
          </li>
        </ul>
      </section>
      <MidBanner :kiss="kiss" :unfocus="unfocus" />
      <LiveAnywhere :focus="focus" :unfocus="unfocus" />
      <LastBanner :kiss="kiss" :unfocus="unfocus" />
    </div>

    <Footer />
  </div>
</template>

<script>
import Header from "../components/Header.vue"
import LandingSection from "../components/LandingSection.vue"
import HouseCard from "../components/HouseCard.vue"
import MidBanner from "../components/MidBanner.vue"
import LiveAnywhere from "../components/LiveAnywhere.vue"
import LastBanner from "../components/LastBanner.vue"
import Footer from "../components/Footer.vue"
import { mapState, mapActions } from "pinia";
import { useStoreStore } from "../store/store";
import { useUsersStore } from "../store/users";
//animation
import { gsap } from "gsap"
import { CSSPlugin } from 'gsap/CSSPlugin'
import ScrollTrigger from "gsap/ScrollTrigger";
import 'animate.css';
gsap.registerPlugin(CSSPlugin);
gsap.registerPlugin(ScrollTrigger);


export default {
  components: {
    Header,
    LandingSection,
    HouseCard,
    MidBanner,
    LiveAnywhere,
    LastBanner,
    Footer
  },

  data() {
    return {

    }
  },

  computed: {
    // gives read access to this.countries and this.anotherVar
    ...mapState(useStoreStore, ['colorMode', 'houses']),
    ...mapState(useUsersStore, ['users'])
  },
  methods: {
    // gives access to this.fetchAll()
    ...mapActions(useStoreStore, ['fetchAll']),
    ...mapActions(useUsersStore, ['fetchAllUsers']),
    focus(event) {
      gsap.to(event.target, { duration: .4, scale: 1.1 })
    },
    unfocus(event) {
      gsap.to(event.target, { duration: .4, scale: 1 })
    },
    kiss(event) {
      gsap.from(event.target, { duration: .7, scaleY: 0.4 })
      console.log("kissin");
    }
  },
  async mounted() {
    //llamada al backend
    this.fetchAll()

    //animaciones con gsap
    //inicial
    const web_init = gsap.timeline()
    web_init.from('.jumbotron', { duration: .6, opacity: 0.3 }).from('.main-title', { duration: .6, x: "200%", opacity: 0, stagger: 0.2 })
    //scroll -1st timeline
    const tl_1 = gsap.timeline({
      scrollTrigger: {
        trigger: '.jumbotron',
        toggleActions: 'play play none reverse',
        markers: false,
        start: 'bottom center',
        end: '100% center'
      }, stagger: 0.3
    });
    tl_1.to('.main-title', { duration: 1, x: "-100%", ease: "bounce.easeOut", opacity: 0 }).to('#btn-landing', { duration: 0.3, x: "100%", opacity: 0, ease: "bounce.easeOut" })

  }

}
</script>

<style>
*,
*::before,
*::after {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

:root {
  --dark: #1e1e38;
  --white: #112;
  --light: #fafafc;
  --gray: #002;
  --brown: #3f3f1a;
  --yellow: #ffffd6;
  --sidePadding: 8rem;
  --maxWidth: 40%;
  --containerWidth: 1200px;

}


body {
  font-family: Nunito Sans, sans-serif;
  line-height: 1.5;
  -webkit-tap-highlight-color: transparent;
  font-size: 1rem;
  -webkit-user-select: none;
  /* Safari */
  -ms-user-select: none;
  /* IE 10 and IE 11 */
  user-select: none;
  /* Standard syntax */
  -webkit-user-drag: none;
  -khtml-user-drag: none;
  -moz-user-drag: none;
  -o-user-drag: none;
}

.light {
  background: var(--light);
  color: var(--dark);
}

.dark {
  background: var(--dark);
  color: var(--light);
}



h1 {
  font-weight: 900;
  font-size: clamp(2rem, 5.5vw, 3.25rem);
  line-height: 1.2;
  margin-bottom: 1.5rem;
  width: 41%;
}

.btn {
  --color: var(--dark);
  --bgcolor: var(--light);
  display: inline-block;
  white-space: nowrap;
  padding: 0.75rem 1.5rem;
  font-size: 1.15rem;
  font-weight: 600;
  color: var(--color);
  background: var(--bgcolor);
  border-radius: 0.66rem;
  -webkit-transition: all .2s;
  -moz-transition: all .2s;
  transition: all .2s;
  -webkit-box-shadow: 0 .5rem 1.5rem -.5rem currentColor;
  box-shadow: 0 .5rem 1.5rem -.5rem currentColor;
  text-decoration: none;
}

p {
  font-size: 1vw;
}



/* house items section  -------*/
.section {
  /* margin-top: 4vw;
      margin-left: 11vw;
      margin-right: 11vw;
      margin-bottom: 4vw; */
  margin: 3rem var(--sidePadding) 0;

}

.house-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

ul {
  list-style: none;
}

@media (min-width: 1500px) { 
  .media-width{
    padding-left: 6rem;
    padding-right: 6rem;
  }
}
</style>