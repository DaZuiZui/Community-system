<template>
    <div class="hello">
            <Top/> 
        <!-- Main content -->
        <section >
            <div class="container">
                <!-- Title -->
                <!-- Section title -->
                <div class="row mb-5 justify-content-center text-center">
                    <div class="col-lg-6">

                 <h2 class=" mt-4">登入您的账户</h2>
                        <div class="mt-2">
                            <p class="lead lh-180">Login Your Account</p>
                        </div> 
                        <div>
                                <div class="form-group">
                                  <label for="exampleInputEmail1">Username</label>
                                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" v-model="userLoginBo.username">
                                  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                  <label for="exampleInputPassword1">Password</label>
                                  <input type="password" class="form-control" id="exampleInputPassword1" v-model="userLoginBo.password" @keyup.enter="submit()">
                                </div>
                                <div class="form-group form-check">

                                </div>
                                <button  class="btn btn-primary" style="width:100%" @click="submit()"   :disabled="switchbutton">Submit</button>
 
                        </div>
                    </div>
                </div>
            </div>
            
        </section>

        <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer>
    </div>
  </template>

  <script>
  import Foot from './fream/Foot.vue';
  import Top  from './fream/LoginTop.vue'
  import {synRequestPost,synRequestGet} from "../../static/request"

  export default {
    name: 'HelloWorld',
    components: {
           Foot,Top
      },
    data () {
      return {
        userLoginBo: {
            username: "",
            password: "",
        },
        //按钮开关
        switchbutton: false,
      }
    },
    mounted(){

  },

  methods: {
    //提交登入
    async submit(){
         this.switchbutton = true;
         var object =await synRequestPost("/user/login",this.userLoginBo);
         console.log(object);
         if(object.code != "0x200"){
            alert(object.message);
            this.userLoginBo.username= ""
            this.userLoginBo.password= "";
            this.switchbutton = false;
            return ;
         }
        setCookie ("token",object.data.token);
        localStorage.setItem("user",JSON.stringify(object.data.userAndUserAdminBo));
         alert(object.message);
         this.$router.push("/ActivityManagement");
         this.switchbutton = false;
     },
}
  }
  </script>

  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  h1, h2 {
    font-weight: normal;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
  </style>
