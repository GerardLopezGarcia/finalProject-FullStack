import { defineStore } from "pinia";

export const useUsersStore = defineStore('users', {
  state: () => ({
    users: [],
    logedUser: {},
    message:false,
    supabaseData: []
  }),
  actions: {
    async fetchAllUsers() {
      const response = await fetch('http://localhost:8080/users')
      const usersFetch = await response.json()
      this.users = usersFetch
    },
    enterUser(user,password,router){
      //comprobar usuario
      console.log(user)
      const arrayNames =["mujerilusionada","estudianteindeciso","reciencasados","padresconhijos","grupodeamigos"]
      const arrayPass= ["ironhack1","ironhack4","ironhack","ironhack2","ironhack3"]
      for (let i = 0; i < arrayNames.length; i++) {
        if(user.toLowerCase() == arrayNames[i]){
          //usuario encontrado -  compruebo contraseña
          if(password.toLowerCase() == arrayPass[i]){
            this.message=false
            this.logedUser.user = user
            this.logedUser.password = password
            console.log("mensaje de pinia",user)
            console.log("mensaje de pinia pass",password)
            router.push(`/profile/${user}`)
          }else{
            this.message = true
            setTimeout(() => {
              this.message = false
            }, "2000")
          }

        }else if(i == 4 && user.toLowerCase() != arrayNames[i]){
          this.message = true
          setTimeout(() => {
            this.message = false
          }, "2000")
        }
      }

    },
    async fetchUsersSupabase(){
      //fetch con supabase ---------
      const response = await fetch('https://gvomsfinyxfrmcscxynd.supabase.co/rest/v1/guest_user?select=*',{
        method: 'GET',
        headers: {
          'apikey':'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imd2b21zZmlueXhmcm1jc2N4eW5kIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzMzMzk2NTAsImV4cCI6MTk4ODkxNTY1MH0.Bw1RQX8h386Yldtyc2YPL9WlZN9X68nIKU-jpDrr0VU',
          'Authorization':'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imd2b21zZmlueXhmcm1jc2N4eW5kIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzMzMzk2NTAsImV4cCI6MTk4ODkxNTY1MH0.Bw1RQX8h386Yldtyc2YPL9WlZN9X68nIKU-jpDrr0VU'
        }
      })
      const data = await response.json()
      this.supabaseData = await data
    }
  }
})