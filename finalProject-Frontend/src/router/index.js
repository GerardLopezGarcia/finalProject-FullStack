import { createRouter,createWebHistory} from "vue-router"
import HomeView from "../views/HomeView.vue"
import Profile from "../views/Profile.vue"
import CardInfo from "../views/CardInfo.vue"

const routes = [
    {
        path: '/',
        name: 'root',
        component:HomeView
    },
    {
        path:'/profile/:name',
        name:'profile',
        component:Profile
    },
    {
        path:'/housecard/:id',
        name:'housecard',
        component:CardInfo
    }
]


const router = createRouter({
    history: createWebHistory("/"),
    routes,
    scrollBehavior(){
        document.getElementById("app").scrollIntoView();
    }
})

export default router
