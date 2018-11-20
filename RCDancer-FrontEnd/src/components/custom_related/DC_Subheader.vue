<template>
    <v-subheader>
        <span class="pr-1">
            <v-icon small>menu</v-icon>
        </span>
        {{menuName}}
    </v-subheader>
</template>

<script>
export default {
    props: {
        menuName: String
    },
    data () {
        return {}
    }
}
</script>

<style>

</style>
