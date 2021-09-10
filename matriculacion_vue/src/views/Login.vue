<template>
    <v-container>
        <div >
            <v-layout row>
                <v-flex  py-15>
                
                </v-flex>
            </v-layout>
            <v-layout row>
                <v-flex py-15>
                    <v-row >
                        <v-col >
                            <v-flex >
                                <v-icon size="350">
                                    mdi-shield-account-outline
                                </v-icon>
                            </v-flex>
                        </v-col>
                        <v-col >
                            <v-card rounded outlined xs7 :elevation="8">
                                <v-card-title>
                                    <v-layout  justify-space-between>
                                        <h3 class="headline mb-0">Ingresar</h3>
                                    </v-layout>
                                </v-card-title>
                                <v-divider></v-divider>
                                <v-card-text>
                                    <v-flex pb-15 pt-10>
                                        <p>Entrar con correo y contraseña:</p>
                                        <v-form>
                                            <v-text-field
                                                required
                                                v-model="user.username"
                                                outlined
                                                dense
                                                label="Correo"
                                            ></v-text-field>
                                            
                                            <label>Contraseña</label>
                                            <VuePassword
                                            required
                                            class="input"
                                                v-model="user.password"
                                                outlined
                                                label="Correo"
                                                :strength="pswd_strength"
                                            />
                                
                                            
                                        </v-form>
                                        </v-flex>
                                </v-card-text>
                                <v-divider></v-divider>
                                <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn @click="handleLogin" color="primary">Entrar</v-btn>
                                
                                </v-card-actions>
                            </v-card>
                        </v-col>
                    </v-row>
                </v-flex>
            </v-layout>
        </div>
    </v-container>
</template>
<script>
import User from '../models/user';
import VuePassword from 'vue-password';
import AuthService from '../api/auth_service.js';
export default {
    name: 'Login',
    components: {
        VuePassword
    },
    data() {
        return {
            user: new User('', '', ''),
            loading: false,
            message: '',
            name: '',
            email: '',
            pswd_strength: 0,
        }
    },
    mixins: [],
    computed:{
        
    },
    created(){
        if(this.loggedIn){
            this.$router.push('/');
        }    
    },
    methods:{
        handleLogin(){
            this.loading = true;
            if(this.user.username && this.user.password){
                AuthService.login(this.user);
            }
        },
    }
}
</script>
