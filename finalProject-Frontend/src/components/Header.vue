<template>
      <header>
    <div class="headerInner">
      <div class="div-logo">
        <router-link to="/">
            <a href="#"><img src="https://img.icons8.com/material/2x/hut.png" alt="logo" class="logo"></a>
        </router-link>
        <span >The housing App</span>
      </div>
      <div class="profile">
        <!-- acceso facil a los perfiles  -->
        <!-- <router-link :to="`/profile/estudianteindeciso`">
            <a href="#">Become a host</a>
        </router-link> -->
        <div class="color-mode" @click="changeColorMode()">
            {{colorModeIcon}}
        </div>
        <div class="user-form" v-if="showForm">
            <input type="text" placeholder="user" class="input-user" v-model="user" v-on:keyup.enter="enterUser(user,password,this.$router)">
            <input type="password" placeholder="password" class="input-password" v-model="password" v-on:keyup.enter="enterUser(user,password,this.$router)">
            <img src="./icons/login.svg" class="login-logo" @click="enterUser(user,password,this.$router)">
            <p v-if="message" class="error-message" >❌</p>

        </div>
        <div class="user" @click="displayForm()">
            <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="userIcon">
                <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path><circle cx="12" cy="7" r="4"></circle>
            </svg>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
import { mapState,mapActions } from "pinia";
import { useStoreStore } from "../store/store";
import { useUsersStore } from "../store/users";


    export default {
        data(){
            return{
                showForm: false,
                userInput: "",
                passwordInput: "",
                user:"",
                password:""
            }
        },
        props:{
            users: {
                type: Array
            }
        },
        methods : {
            displayForm() {
                this.showForm = (this.showForm == false)? true : false;
            },
            //traigo actions de pinia
            ...mapActions(useStoreStore, ['changeColorMode']),
            ...mapActions(useUsersStore, ['enterUser'])
        },
        computed : {
            ...mapState(useStoreStore, ['colorModeIcon']),
            ...mapState(useUsersStore, ['logedUser','message'])
        },
        watch: {
            //la mala seguridad se paga caro

            user(newValue){
                this.user =newValue
                
            },
            password(newValue){
                this.password =newValue
            }
        }
    }
    // router.push({path: tripPathView(trip.id)})

</script>

<style scoped>
    header{
        position: absolute;
        top: 0;
        color: #fafafc;
        padding: 1.5rem var(--sidePadding);
        width: 100%;
        z-index: 10;
        /* position: fixed; */
        
    }
    .headerInner{
        max-width: var(--containerWidth);
        margin: 0px auto;
        display: flex;
        justify-content: space-between;
        align-items: center;

    }
    .user-form{
        display: flex;
        justify-content: space-evenly;
    }
    .input-user {
        padding: 0.2rem;
        font-size: .83rem;
        border-width: 1px;
        /* border-color: #CCCCCC; */
        background-color: #FFFFFF;
        color: var(--dark);
        border-style: solid;
        border-radius: 9px;
        /* box-shadow: 0px 0px 5px rgba(255, 255, 255, 0.411); */
        width: 44%;
     
    }
    .input-password {
        padding: 0.2rem;
        font-size: .83rem;
        border-width: 1px;
        /* border-color: #CCCCCC; */
        background-color: #FFFFFF;
        color: var(--dark);
        border-style: solid;
        border-radius: 9px;
        /* box-shadow: 0px 0px 5px rgba(255, 255, 255, 0.411); */
        width: 44%;
    }

    span, a {
        font-weight: 600;
        font-size: 1.15rem;
        margin-left: 0.5rem;
        text-decoration: none;
        color: var(--light);
    }
    a {
        margin-right: 1rem;
    }
 
    .profile{
        -webkit-box-pack: end;
        justify-content: flex-end;
        white-space: nowrap;
        display: flex;
        -webkit-box-align: center;
        align-items: center;
        margin-right: 1rem;
        margin-left: 1rem;
    }
    .profile div {
        margin-right: 1rem;
    }
    .logo{
    -webkit-filter: grayscale(1) invert(1);
    filter: grayscale(1) invert(1); 
    }
    .div-logo{
        display: flex;
        align-items: center;
    }
    .userIcon{
        width: 1.5rem;
    }
    .login-logo{
        width: 1.5rem;
        cursor: pointer;
    }
    .user {
        cursor: pointer;
        display: flex;
    }
    .color-mode{
        cursor: pointer;
        font-size: 1.3rem;
    }
    .error-message{
        color: red;
        padding-left: 1rem;
    }
</style>