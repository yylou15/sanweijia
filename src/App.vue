<template>
<!--    <div id="app">-->
        <Main></Main>
        <!--      <router-link to="/">Home21</router-link> |-->
        <!--    <router-view/>-->
<!--    </div>-->
</template>

<style>
    body {
        margin: 0;
            min-width: 1368px;
            /*overflow: hidden;*/
    }

    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }

</style>
<script>
    import Main from "@/views/Main";

    export default {
        components: {Main}
    }
</script>