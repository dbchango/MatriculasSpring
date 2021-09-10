<template>
    <div>
        <v-card>

        <v-data-table
            dense
            :headers="headers"
            :items="data"
            item-key="id"
            class="elevation-1"
        >
        
            <template v-slot:top>
                <v-toolbar flat>
                    <v-toolbar-title>Matriculas</v-toolbar-title>
                    <v-divider
                        class="mx-4"
                        inset
                        vertical
                    ></v-divider>
                    <v-spacer></v-spacer>
                    <v-dialog
                        v-model="dialog"
                        max-width="500px"
                    >
                        <template v-slot:activator="{ on, attrs }">
                            <v-btn
                                dark
                                class="mb-2"
                                v-bind="attrs"
                                v-on="on"
                            >
                            Crear
                            </v-btn>
                        </template>
                        <v-card>
                            <v-card-title>
                                <span class="text-h5">{{ formTitle }}</span>
                            </v-card-title>
                            <v-card-text>
                                <v-container>
                                    <v-row>
                                        <v-col
                                        >
                                            <v-text-field
                                                v-model="editedItem.Name"
                                                label="Cédula"
                                                required
                                            ></v-text-field>
                                        </v-col>
                                        
                                    </v-row>
                                    <v-row>
                                        <v-col
                                        >
                                            <v-textarea
                                                v-model="editedItem.Details"
                                                label="NRC"
                                                required
                                            ></v-textarea>
                                        </v-col>
                                    </v-row>
                                </v-container>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn
                                    color="dark"
                                    text
                                    @click="close"
                                >
                                    Cancelar
                                </v-btn>
                                <v-btn
                                    dark
                                    @click="save"
                                >
                                    Guardar
                                </v-btn>
                            </v-card-actions>

                        </v-card>
                    </v-dialog>
                    <v-dialog v-model="dialogDelete" max-width="500px">
                        <v-card>
                            <v-card-title class="text-h5">
                                ¿Estas seguro de que deseas eliminar este producto?
                            </v-card-title>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn color="dark" text @click="closeDelete">Cancelar</v-btn>
                                <v-btn dark @click="deleteItemConfirm">Ok</v-btn>

                            </v-card-actions>
                        </v-card>

                    </v-dialog>
                </v-toolbar>
            </template>
            <template v-slot:[`item.actions`]="{ item }">
                <v-icon
                    small
                    class="mr-2"
                    @click="editItem(item)"
                >
                    mdi-pencil
                </v-icon>
                <v-icon
                    small
                    class="mr-2"
                    @click="deleteItem(item)"
                >
                    mdi-delete
                </v-icon>
            </template>
            <template v-slot:no-data>
                <v-btn
                    color="primary"
                    @click="initialize"
                >
                    Reset
                </v-btn>
            </template>

        </v-data-table>
        </v-card>
    </div>
</template>
<script>
import ProductsService from '../api/products_service';
import Product from '../models/product';
export default {
    name: 'ProductsList',
    data() {
        return {
            dialog:false,
            dialogDelete:false,
            headers: [
                {
                    text: 'Nombre',
                    align: 'start',
                    value: 'Name'

                },
                {
                    text: 'Detalles',
                    value: 'Details'
                },
                {
                    text: 'Precio',
                    value: 'Price'
                },
                {
                    text: 'Stock',
                    value: 'Stock'
                },
                {
                    text: 'Actions',
                    value: 'actions',
                    sortable: false
                }
            ],
            data: [],
            editedIndex: -1,
            editedItem: new Product('', '', '', null, null, null),
            defaultItem: new Product('', '', '', null, null, null)
        }
    },
    mounted: function(){
        this.initialize()
    },
    computed:{
        formTitle(){
            return this.editedIndex === -1 ? 'Nuevo producto': 'Editar producto'
        },
        
    },
    watch:{
        dialog(val){
            val || this.close()
        },
        dialogDelete(val){
            val||this.closeDelete()
        },           
    },
    created(){
        this.initialize();
    },
    methods:{
        initialize(){
            ProductsService.getProducts().then(res=>this.data = res.data)
        },
        editItem(item){
            console.log(item)
            this.editedItem = item
            this.dialog = true
        },
        deleteItem(item){
            this.editedItem = item
            this.dialogDelete = true;
        },
        deleteItemConfirm(){
            ProductsService.deleteProduct(this.editedItem.Id).then(resp=>{
                this.initialize()
                console.log(resp.data)
            }).catch(err=>console.log(err.response))
            this.closeDelete()
        },
        close(){
            this.dialog = false;
            this.$nextTick(()=>{
                this.editedItem = Object.assign({}, this.defaultItem)
            })
        },
        closeDelete(){
            this.dialogDelete = false;
            this.$nextTick(()=>{
                this.editedItem = Object.assign({}, this.defaultItem)
                this.editedIndex = -1;
            })

        },
        save(){
            if(this.editedItem.Id!=''){
                ProductsService.editProduct(this.editedItem).then(
                    resp=>{
                        this.initialize()
                        console.warn(resp.data)
                    }
                    ).catch(
                    (err)=>{
                        console.warn(err.response)
                    })
            }else{
                ProductsService.createProduct(this.editedItem).then(
                    (res)=>{
                        this.initialize()
                        console.warn(res.data)
                    }
                ).catch(
                    (err)=>console.warn(err.response))
            }
            this.close()
        }
    }


}
</script>