<template>

    <v-navigation-drawer dark clipped app>
        <v-list>
            <v-list-item class="px-2">
                <v-list-item-avatar>
                    <v-icon>mdi-account</v-icon>
                </v-list-item-avatar>
                <v-list-item-content>
                  <!--  <v-list-item-title class="text-h7">{{ user}}</v-list-item-title> -->
                    <v-list-item-subtitle class="text-h9">Email</v-list-item-subtitle>
                </v-list-item-content>
            </v-list-item>
         
        </v-list>
        <v-divider></v-divider>
        <v-list nav dense>
            <!--<v-list-item link :to="{ name: 'products-list'}">
                <v-list-item-icon>
                    <v-icon>mdi-bottle-soda-classic-outline</v-icon>
                </v-list-item-icon>
                <v-list-item-title>Products</v-list-item-title>
            </v-list-item>-->
        </v-list>
        <v-divider></v-divider>
        <template v-slot:append>
            <div class="pa-2">
                <v-btn color="error" @click="handleLogOut" block>
                    Salir
                </v-btn>
            </div>
        </template>

    </v-navigation-drawer>
    
</template>
<script>
export default {
    name: 'AppNavigation',
    data(){
        return {
            loggedIn:false,
            user: null
        }
    },
    mounted: function () {
    },
    methods: {
        handleLogOut(){
        }
    }
}
</script>
<style scoped>

</style>