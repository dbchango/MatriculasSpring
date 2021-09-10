<template>
    <v-app>
        <v-main transition="slide-x-transition">

            <div >
                <Login/>
            </div>
            <div >
                <Register/>
            </div>
            <div >
                <Matricula/>
            </div>
        </v-main>
      
    </v-app>
    
</template>
<script>
import Login from './views/Login.vue'
import Register from './views/Register.vue'
import Matricula from './views/Matricula.vue'
export default {
    data(){
        return {
        }
    },
    name: 'App', 
    components: { 
        Login, 
        Register,
        Matricula
    }, 
    mounted:function(){
    }
    
}
</script>
