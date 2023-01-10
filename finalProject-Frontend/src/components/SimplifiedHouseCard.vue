<template>
    
        <div class="box">
            <div class="box-image">
                <router-link :to="`/housecard/${house.id - 1}`" class="router-link">
                    <img :src="house.imageUrl" style="width: 100%; border-radius: .6rem; height: 13rem;">
                </router-link>
            </div>
            <div class="box-info">
                <div>
                    <h6>{{ house.houseAddress }},{{ house.country }}</h6>
                    <p>{{ house.price }} €/noche</p>
                    <p>{{ house.score }} <img src="./icons/star.svg" alt="star" style="width: 1vw;"></p>
                </div>
                <div v-if="house.status == 'AVALIABLE'">
                    <a class="myButton" @click="assignHouse(house.id,userName,this.$router)">book it!</a>
                </div>
                <div v-if="house.status == 'UNAVALIABLE'">
                    <a class="myButton-unavaliable" >booked</a>
                </div>
            </div>
        </div>



</template>

<script>
    import { mapState, mapActions } from "pinia"
    import { useStoreStore } from "../store/store"
    import { useUsersStore } from "../store/users"

export default {

    props: {
        house: {
            type: Object,
            default: {}
        },
        userName: String
    },
    methods: {
        // gives access to this.fetchAll()
        ...mapActions(useStoreStore, ['assignHouse'])
    }
}

</script>

<style scoped>
img {
    max-width: 100%;
    max-height: 100%;
}

.box {
    background-color: var(--light);
    width: 19rem;
    margin: 2vw;
    height: 88%;
    border-radius: 1vw;
    color: var(--dark);
    text-decoration: none;
}

p {
    font-size: 1vw;
}

h6 {
    font-size: 1vw;
}

.box-info {
    margin: 1vw 1vw;
    padding-bottom: 1rem;
    display: flex;
    justify-content: space-between;
}

.router-link {
    text-decoration: none;
}

/* estilos de boton */
.myButton {
	box-shadow: 0px 10px 14px -7px #3e7327;
	background:linear-gradient(to bottom, #77b55a 5%, #72b352 100%);
	background-color:#77b55a;
	border-radius:.4rem;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:.8rem;
	font-weight:bold;
	padding:.5rem 1rem;
	text-decoration:none;
	text-shadow:0px 1px 0px #5b8a3c;
}
.myButton:hover {
	background:linear-gradient(to bottom, #72b352 5%, #77b55a 100%);
	background-color:#72b352;
}
.myButton:active {
	position:relative;
	top:.7rem;
}

.myButton-unavaliable {
	box-shadow: 0px 10px 14px -7px #e67a73;
	background:linear-gradient(to bottom, #e4685d 5%, #eb675e 100%);
	background-color:#e4685d;
	border-radius:.4rem;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:.8rem;
	font-weight:bold;
	padding:.5rem 1rem;
	text-decoration:none;
	text-shadow:0px 1px 0px #b23e35;
}
.myButton-unavaliable:active {
	position:relative;
	top:.7rem;
}

</style>