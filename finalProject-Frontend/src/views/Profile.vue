<template>
    <div :class="colorMode">
        <div class="img-header-profile">
            <Header />
        </div>
        <div class="media-width">
            <div class="container">
                <div class="userdata-column">
                    <h2> Detalles de la cuenta </h2>
                    <h4>Hola, {{ selectedUser.name }} </h4>
                    <br>
                    <p>Fecha de nacimiento: {{ selectedUser.dateOfBirth }}</p>
                    <p>Dirección: Calle {{ selectedUser.address.street }}, {{ selectedUser.address.houseAddress }} </p>
                    <p>{{ selectedUser.address.city }}</p>
                    <div v-if="selectedUser.userStatus == 'ONLINE'">
                        <p>Status : online <img src="../components/icons/online.svg" style="width: 1rem;"></p>
                    </div>
                    <div v-else>
                        <p>Status : offline <img src="../components/icons/offline.svg" style="width: 1rem;"></p>
                    </div>
                    <br>

                </div>
                <div class="bookings-column">
                    <div class="booking-title">
                        <h2> Gestiona tus reservas </h2>
                        <p>Consulta las casas disponibles</p>
                        <br>
                    </div>
                    <div class="bookings">
                        <div class="booked-house" v-for="(el, index) in users[selectedUserId].houses" :key="index">
                            <img :src="el.imageUrl" style="width: 4.5rem;border-radius: .4rem;">
                            <p> Booked house in : {{ el.houseAddress }},{{ el.country }} </p>
                            <p> {{ el.score }} <img src="../components/icons/star.svg" alt="star" style="width: 1vw;padding-left: .1rem;">
                            </p>
                            <div class="details-grid">
                                <p class="house-icon">🏡 {{ el.houseDetails.bedrooms }} </p>
                                <p class="house-icon">🛌 {{ el.houseDetails.beds }}</p>
                                <p class="house-icon">🛀 {{ el.houseDetails.bathrooms }} </p>
                                <p class="house-icon">🙍‍♂️ {{ el.houseDetails.guests }}</p>
                            </div>
                            <a class="cancel-booking" @click="unAssignHouse(el.id, this.$router)"><img
                                    src="../components/icons/cross.svg" style="width: 1.4rem;"></a>
                        </div>
                    </div>
                    <ul class="house-grid">
                        <li v-for="(house, index) in houses" :key="index" @mouseenter="focus" @mouseleave="unfocus">
                            <SimplifiedHouseCard :house="houses[index]" :userName="selectedUser.name" />
                        </li>
                    </ul>
                </div>
            </div>
            <LastBanner :kiss="kiss" :unfocus="unfocus" />
            <br>
        </div>
        <Footer />
    </div>




</template>

<script>
import Header from "../components/Header.vue"
import MidBanner from "../components/MidBanner.vue"
import LastBanner from "../components/LastBanner.vue"
import Footer from "../components/Footer.vue"
import SimplifiedHouseCard from "../components/SimplifiedHouseCard.vue"
import { mapState, mapActions } from "pinia";
import { useStoreStore } from "../store/store";
import { useUsersStore } from "../store/users";
//animations
import { gsap } from "gsap"
import { CSSPlugin } from 'gsap/CSSPlugin'
gsap.registerPlugin(CSSPlugin);




export default {
    components: {
        Header,
        SimplifiedHouseCard,
        MidBanner,
        LastBanner,
        Footer
    },

    data() {
        return {
            selectedUser: {},
            selectedUserId: ""
        }
    },
    computed: {
        // gives read access to this.countries and this.anotherVar
        ...mapState(useStoreStore, ['colorMode', 'houses']),
        ...mapState(useUsersStore, ['users', 'logedUser'])
    },
    methods: {
        // gives access to this.fetchAll()
        ...mapActions(useUsersStore, ['fetchAllUsers']),
        ...mapActions(useStoreStore, ['fetchAll', 'unAssignHouse']),
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
    async created() {
        this.fetchAll();
        this.fetchAllUsers();
        const response = await fetch(`http://localhost:8080/guestusers/${this.$route.params.name}`)
        const selectedUserFetch = await response.json()
        this.selectedUser = selectedUserFetch
        //user id para el refresh
        const arrayNames = ["mujerilusionada", "estudianteindeciso", "reciencasados", "padresconhijos", "grupodeamigos"]
        const arrayId = [2, 0, 4, 3, 1]
        for (let i = 0; i < arrayNames.length; i++) {
            if (this.selectedUser.name == arrayNames[i]) {
                this.selectedUserId = arrayId[i]
            }
        }
    }
}
</script>

<style scoped>
header {
    position: relative;
}

.container {
    /* display: flex;
    flex-direction: row; */
    display: grid;
    grid-template-columns: 1fr 3fr;
    grid-template-rows: 1fr;
}

.img-header-profile {
    background: url("../components/icons/forest.jpg");
    background-size: cover;
    background-position: 0% 35%;
}

.userdata-column {
    display: flex;
    flex-direction: column;
    padding: 2rem;
    width: 100%;
    border-right: 1px solid #0002;
    margin: 1rem;
}

.bookings-column {
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    padding: 2rem;
    width: 100%;
}

.booking-title {
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    border-bottom: 1px solid #0002;
    width: 55rem;
}

.bookings {
    border-bottom: 1px solid #0002;
    width: 55rem;
    margin-top: 2rem;
    padding-bottom: 2rem;
}

.booked-house {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    padding-bottom: 1rem;
}
.details-grid {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
    -webkit-filter: grayscale(1) invert(1);
    filter: brightness(0) saturate(100%) invert(46%)  saturate(1203%) opacity(60%);
}
.house-icon{
    padding-left: 1rem;
}

.cancel-booking:active {
    position: relative;
    top: .3rem;
}

@media (min-width: 1550px) {
    .media-width {
        padding-left: 11rem;
        padding-right: 11rem;
    }
}
</style>