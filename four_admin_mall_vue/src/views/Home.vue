<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import {api_test} from '@/network/api/admin';

export default {
  name: 'Home',
  components: {
    HelloWorld
  },
  props: {},
  data () {
    return {}
  },
  computed: {},
  created () {
    this.handleProductList()
  },
  mounted () {

  },
  methods: {
    async handleProductList() {
      console.log("111");
      const res = await api_test()
      console.log(res.data);
    },
  },
  filter: {

  },
  watch: {

  }
}
</script>
