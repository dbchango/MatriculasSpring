<template>
    <v-container>
        <div>
            <v-layout row>
                <v-flex py-15></v-flex>
            </v-layout>
            <v-layout row>
                <v-flex py-15>
                    <v-row>
                        <v-col>
                            <v-flex >
                                <v-icon size="350">
                                    mdi-card-account-details
                                </v-icon>
                            </v-flex>
                        </v-col>
                        <v-col>
                            <v-card rounded outlined xs7 :elevation="8">
                                <v-card-title>
                                    <v-layout  justify-space-between>
                                        <h3 class="headline mb-0">Registrarse</h3>
                                    </v-layout>
                                </v-card-title>
                                <v-divider></v-divider>
                                <v-card-text>
                                    <v-flex pb-15 pt-10>
                                        <p>Registrate con tu correo:</p>
                                        <v-form>
                                            <v-text-field
                                                required
                                                v-model="user.username"
                                                label="Correo"
                                                outlined
                                                dense
                                            >
                                            </v-text-field>
                                            <v-flex py-2>
                                                <label>Contraseña</label>
                                                <VuePassword
                                                    required
                                                    v-model="user.password"
                                                    @input="updatePswdStrength"
                                                    :strength="pswd_strength"
                                                />
                                            </v-flex>
                                            <v-flex py-2>
                                                <label>Vuelva a ingresar su contraseña</label>
                                                <VuePassword
                                                    required
                                                    v-model="user.confirmPassword"
                                                    @input="updateCPswdStrength"
                                                    :strength="conf_pswd_strength"
                                                />
                                            </v-flex>
                                            
                                        </v-form>
                                    </v-flex>
                                </v-card-text>
                                <v-divider></v-divider>
                                <v-card-actions>
                                    <v-spacer>                                    </v-spacer>
                                    <v-btn @click="handleRegister" color="primary">Registrar</v-btn>
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

import VuePassword from 'vue-password';
import User from '../models/user.js';
export default {
    name: 'Register',
    components: {
        VuePassword
    },
    data() {
        return {
            user: new User('', '', ''),
            pswd_strength:0,
            conf_pswd_strength:0,

        }
    },
    methods: {
        handleRegister(){

        },

        // password strength
        updatePswdStrength(password){
            const containsUppercase = /[A-Z]/.test(password)
            const containsLowercase = /[a-z]/.test(password)
            const containsNumber = /[0-9]/.test(password)
            const containsSpecial = /[#?!@$%^&*-]/.test(password)
            const containsLenght = password.length>10?true:false;
            if(password.length == 0 ) this.pswd_strength = 0;
            if(containsUppercase||containsLowercase||containsNumber) this.pswd_strength = 1;
            if((containsUppercase||containsLowercase||containsNumber)&&containsLenght) this.pswd_strength = 2;
            if(containsNumber&&containsUppercase&&containsLowercase) this.pswd_strength = 3;
            if(containsNumber&&containsUppercase&&containsLowercase&&containsSpecial&&containsLenght) this.pswd_strength = 4;

        },
        // confirmation password strength
        updateCPswdStrength(password){
            if(this.user.password!=password) {
                this.conf_pswd_strength = 0
            }else{
                this.conf_pswd_strength = 4
            }

        },
    }
}
</script>