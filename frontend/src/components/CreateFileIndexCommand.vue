<template>
    <v-card outlined>
        <v-card-title>
            CreateFileIndex
        </v-card-title>

        <v-card-text>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createFileIndex"
            >
                CreateFileIndex
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CreateFileIndexCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
        },
        watch: {
        },
        methods: {
            createFileIndex() {
                this.$emit('createFileIndex', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

