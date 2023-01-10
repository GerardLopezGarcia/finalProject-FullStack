<template>
    <div :class="colorMode">
        <div class="img-header-profile">
            <Header />
        </div>
        <div class="booking-title">
            <h2> Comunidad de usuarios </h2>
            <p>hoja de contacto</p>
            <br>
        </div>
        <div class="media-width">
            <section class="section ">
                <ul class="profile-list">
                    <li v-for="(user, index) in supabaseData" :key="index" @mouseenter="focus" @mouseleave="unfocus">
                        <UserCard :user="user" :profile="this.profiles[index]" />
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
import Footer from "../components/Footer.vue"
import UserCard from "../components/UserCard.vue"
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
        Footer,
        UserCard
    },

    data() {
        return {
            profiles: ['https://d3d00swyhr67nd.cloudfront.net/w1200h1200/collection/NWM/LLD/NWM_LLD_LLDMG_1987_322-001.jpg', 'https://image.invaluable.com/housePhotos/HillAuctionGallery/10/711710/H19846-L270623932_original.jpg', 'https://p1.pxfuel.com/preview/265/920/51/victorian-woman-creative-painting-restoration.jpg', 'https://d38lgik2zino6p.cloudfront.net/items/3593/large/3593_1375395.jpg', 'https://i.pinimg.com/474x/4f/7f/77/4f7f77ea91794fe5f743abbadc41ca6f--spanish-art-blue-ribbon.jpg']
        }
    },
    computed: {
        // acceso a las variables de pinia
        ...mapState(useStoreStore, ['colorMode']),
        ...mapState(useUsersStore, ['supabaseData'])
    },
    methods: {
        // gives access to this.fetchAll()
        ...mapActions(useUsersStore, ['fetchUsersSupabase']),
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
.booking-title {
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    border-bottom: 1px solid #0002;
    margin: 2rem;
}

.section {
    /* margin-top: 4vw;
      margin-left: 11vw;
      margin-right: 11vw;
      margin-bottom: 4vw; */
    margin: 3rem var(--sidePadding) 0;

}

.profile-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}

ul {
    list-style: none;
}


@media (min-width: 1550px) {
    .media-width {
        padding-left: 6rem;
        padding-right: 6rem;
    }
}
</style>