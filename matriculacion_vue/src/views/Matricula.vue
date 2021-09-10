<template>
  <form>
    <v-text-field

      label="Name"

    ></v-text-field>
    <v-text-field

      label="E-mail"

    ></v-text-field>
    <v-select
      v-model="select"
      :items="items"
      :error-messages="selectErrors"
      label="Item"

    ></v-select>
    <v-checkbox
      v-model="checkbox"
      :error-messages="checkboxErrors"
      label="Do you agree?"
      required
      @change="$v.checkbox.$touch()"
      @blur="$v.checkbox.$touch()"
    ></v-checkbox>

    <v-btn
      class="mr-4"
      @click="submit"
    >
      submit
    </v-btn>
    <v-btn @click="clear">
      clear
    </v-btn>
  </form>
</template>
<script>

export default {
    name: 'Matricula',
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
        }
    },



}
</script>