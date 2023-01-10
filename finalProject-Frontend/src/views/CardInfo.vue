<template>
    <div :class="colorMode">

        <div class="img-header-profile">
            <Header />
        </div>
        <div class="media-width">
        <section class="section selected-house">
            <a :href="houses[position].imageUrl" target="_blank" id="anchor-img">
                <img :src="houses[position].imageUrl" class="house-img" @mouseenter="enlight" @mouseleave="dimm">
            </a>

            <div class="house-info">
                <h3>{{ houses[position].houseAddress }}, {{ houses[position].country }}</h3>
                <p>{{ houses[position].price }} €/noche</p>
                <p>{{ houses[position].score }} <img src="../components/icons/star.svg" alt="star" style="width: 1vw;">
                </p>

                <div class="tags">
                    <ul v-for="(tag, index) in houses[position].tags" :key="index">
                        <small>#{{ tag.tag }}</small>
                    </ul>
                </div>

                <div class="details-grid">
                    <p>🏡 {{ houses[position].houseDetails.bedrooms }} <small> bedrooms</small></p>
                    <p>🛌 {{ houses[position].houseDetails.beds }}<small> beds</small> </p>
                    <p>🛀 {{ houses[position].houseDetails.bathrooms }} <small> wc</small> </p>
                    <p>🙍‍♂️ {{ houses[position].houseDetails.guests }} <small> guests</small> </p>
                </div>

                <div class="images-grid">
                    <ul v-for="(image, index) in houses[position].houseImages" :key="index">
                        <li>
                            <img :src="image.url" style="width: 10rem; border-radius:.2rem; height: 6.8rem; "
                                class="secondary-image" @click="zoom" @mouseenter="focus" @mouseleave="unfocus">
                        </li>

                    </ul>
                </div>
            </div>

        </section>
        <section class="section">
            <ul class="house-grid">
                <li v-for="(house, index) in houses" :key="index" @mouseenter="focus" @mouseleave="unfocus">
                    <HouseCard :house="houses[index]" />
                </li>
            </ul>
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
        ...mapState(useUsersStore, ['users']),
        position() {
            return this.$route.params.id
        }
    },
    methods: {
        // gives access to this.fetchAll()
        ...mapActions(useUsersStore, ['fetchAllUsers']),
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
        },
        enlight(event){
            event.target.style.boxShadow = "8px 18px 28px -10px #645fa8a6";
        },
        dimm(event){
            event.target.style.boxShadow = "";
        }
    },
    async created() {
        this.fetchAll();

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

.details-grid {
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
    margin-bottom: .5rem;
    margin-top: .5rem;
    -webkit-filter: grayscale(1) invert(1);
    filter: brightness(0) saturate(100%) invert(46%) sepia(20%) saturate(1203%) opacity(80%);
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