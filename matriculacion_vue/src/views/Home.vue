<template>
    <div class="home">
        <div>
            <AppNavigation/>
            <div >
                <v-container >
                    <v-flex pt-15 >
                        
                            <router-view></router-view>
                        
                    </v-flex>
                   
                </v-container>
            </div>
        </div>
        
        
    </div>
</template>

<script>
// @ is an alias to /src
import AppNavigation from '../components/AppNavigation.vue';

export default {
    name: 'Home',
    components: {
        AppNavigation, 
    },
};
</script>
