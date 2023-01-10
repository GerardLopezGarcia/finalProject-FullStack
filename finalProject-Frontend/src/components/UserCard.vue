<template>
    <div class="box">
        <div class="box-info">
            <div class="profile">
                <img :src="profile" style="width: 14rem; border-radius: .6rem; ">
            </div>
            <div class="info-profile">
                <h6>{{ user.name }}</h6>
                <p>dirección : {{ user.street }} {{ user.house_address }}</p>
                <p>,{{ user.city }}</p>
                <p> {{ user.date_of_birth }} </p>
                <small v-if="user.user_status == 'ONLINE'"> 
                    Status : online <img src="../components/icons/online.svg" style="width: .6rem;">
                </small>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: {
        user: {
            type: Object,
            default: {}
        },
        profile: String
    }
}
</script>

<style scoped>
img {
    max-height: 100%;
}

.box {
    background-color: var(--light);
    width: 28rem;
    margin: 2vw;
    height: 88%;
    border-radius: 1vw;
    color: var(--dark);
    text-decoration: none;

}

p {
    font-size: .7rem;
}

h6 {
    font-size: 1vw;
}

.box-info {
    margin: 1vw 1vw;
    padding-bottom: 1rem;
    display: flex;
}
.profile {
    padding-top: 1rem;
}
.info-profile{
    padding: 1rem;
}
</style>