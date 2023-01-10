import { defineStore } from "pinia";

export const useStoreStore = defineStore('store', {
  state: () => ({
    houses: [],
    colorMode: "light",
    colorModeIcon: "🌝"
  }),
  actions: {
    async fetchAll() {
      const response = await fetch('http://localhost:8080/houses')
      const data = await response.json()
      this.houses = await data
      console.log(this.houses);
    },
    async assignHouse(id,name,router){
      await fetch(`http://localhost:8081/houses/${id}/${name}`,{
        method:'PATCH'
      })
      console.log(id,name);
      router.go()
    },
    async unAssignHouse(id,router){
      await fetch(`http://localhost:8081/houseunassignguest/${id}`,{
        method:'PATCH'
      })
      console.log("booking removed");
      router.go()
    },
    changeColorMode() {
      this.colorMode = (this.colorMode == "dark")? "light" : "dark"
      this.colorModeIcon = (this.colorModeIcon == "🌚")? "🌝" : "🌚"
      console.log(this.colorModeIcon)
      if(this.colorMode == "dark"){
        document.querySelector("html").style.background = "#1e1e38"
      }else{
        document.querySelector("html").style.background = "#fafafc"
      }
    }
  }
})