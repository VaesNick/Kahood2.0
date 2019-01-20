<template lang="html">

  <form @submit.prevent="login">
     <label>loginName:</label>   
     <input type="text" v-model="loginName" />
     <br>
     <br>
     <label>password:</label>
     <input type="password" v-model="password"/>
     <br>
     <br>
     <button v-on:click="login">Login </button>
     <p> {{loginSucces}} </p>
  </form>

</template>

<script lang="js">
  export default  {
    name: 'login',
  
    data() {
      return {
        loginName:"name",
        password: "password",
        loginSucces: "Please enter your credentials",
        usernames: [{name: "nick"}, {name:"steffen"}, { name:"jonathan"}],
        usersList:{}

      }
    },
    methods: {
      login(){
          for (let index = 0; index < this.usersList.length; index++){
              var elementName = this.usersList[index].name;
              var elementPassword = this.usersList[index].password;

              if(this.loginName == elementName && this.password == elementPassword  ){
                  this.loginSucces ="Succesfully logged in!";
                  this.$router.push({ name: 'LandingsPage'});
                  break;

              }else{
                  this.loginSucces = "Wrong credentials!"
              }
          }
      }
    },
    mounted() {
        var self = this;
        this.axios.get('localhost:8080/student')
        .then(response => (self.usersList =response.data))
    }
}
</script>

<style scoped >
.login {
}
</style>
