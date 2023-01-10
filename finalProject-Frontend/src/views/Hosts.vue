<template>
    <div :class="colorMode">

        <div class="img-header-profile">
            <Header />
        </div>
        <div class="media-width">
        <section class="section selected-house">
            {{ supabaseData }}

            <div class="house-info">

                <div class="images-grid">
                </div>
            </div>

        </section>
        <br>
        </div>
        <Footer />
    </div>

</template>

<script>
import Header from "../components/Header.vue"
import HouseCard from "../components/HouseCard.vue"
import Footer from "../components/Footer.vue"
import { mapState, mapActions } from "pinia";
import { useStoreStore } from "../store/store";
import { useUsersStore } from "../store/users";
//animation
import { gsap } from "gsap"
import { CSSPlugin } from 'gsap/CSSPlugin'
import 'animate.css';
gsap.registerPlugin(CSSPlugin);



export default {
    components: {
        Header,
        HouseCard,
        Footer
    },

    data() {
        return {

        }
    },
    computed: {
        // acceso a las variables de pinia
        ...mapState(useStoreStore, ['colorMode', 'houses']),
        ...mapState(useUsersStore, ['supabaseData']),
        position() {
            return this.$route.params.id
        }
    },
    methods: {
        // gives access to this.fetchAll()
        ...mapActions(useUsersStore, ['fetchUsersSupabase']),
        ...mapActions(useStoreStore, ['fetchAll']),
        zoom(event) {
            //se presenta la imagen seleccionada
            document.querySelector('.house-img').src = event.target.src
            document.querySelector('#anchor-img').href = event.target.src
        },
        //animaciones
        focus(event) {
            gsap.to(event.target, { duration: .4, scale: 1.1 })
        },
        unfocus(event) {
            gsap.to(event.target, { duration: .4, scale: 1 })
        }
    },
    async created() {
        this.fetchUsersSupabase();

    }
}
</script>

<style scoped>
header {
    position: relative;
}

.img-header-profile {
    background: url("../components/icons/forest.jpg");
    background-size: cover;
    background-position: 0% 35%;
}

.selected-house {
    display: flex;
}

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

.house-img {
    height: 31rem;
    width: 49rem;
    border-radius: 1rem;
    margin: 0rem 2.5rem 0rem 2.5rem;
}

.house-info {
    /* padding-left: 2rem; */
    display: flex;
    flex-direction: column;
}

p {
    font-size: 1rem;
    padding-bottom: .3rem;
}

.tags {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    color: #7670ca;


}
.secondary-image{
    cursor: pointer;
}

.images-grid {
    width: 40%;
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr;
    gap: .08rem .4rem;
    grid-auto-flow: row;
    grid-template-areas:
        ". ."
        ". .";
    border-radius: .4rem;
}
@media (min-width: 1550px) { 
  .media-width{
    padding-left: 6rem;
    padding-right: 6rem;
  }
}
</style>