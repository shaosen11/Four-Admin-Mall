<template>
  <div class="home" style="height: 100%">
    <el-container style="height: 100%">
      <el-aside :width="!menuCollapse?'200px':'64px'">
        <el-menu
          :default-active="activeMenu"
          router
          :collapse="menuCollapse"
          class="el-menu-vertical-demo"
          background-color="#304156"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-menu-item index="/welcome"><i class="el-icon-location"></i>首页</el-menu-item>
          <el-submenu :index="formatPath(null,item.name)" v-for="item in firstMenus" :key="item.id">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>{{item.title}}</span>
            </template>
            <el-menu-item-group>
              <el-menu-item :index="formatPath(item.name,seconditem.name)" v-for="seconditem in secondMenus(item.id)" :key="seconditem.id">{{seconditem.title}}</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header>
          <el-button :icon="!menuCollapse?'el-icon-s-fold':'el-icon-s-unfold'" @click="menuCollapse = !menuCollapse"></el-button>
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/welcome' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>商品</el-breadcrumb-item>
            <el-breadcrumb-item>商品列表</el-breadcrumb-item>
          </el-breadcrumb>
          <el-dropdown @command="handleCommand">
            <span class="el-dropdown-link">
              <el-avatar :src="loginUser.icon" ></el-avatar>
              欢迎：{{loginUser.username}}
              <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="update">修改密码</el-dropdown-item>
              <el-dropdown-item command="quit">退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

export default {
  name: 'Home',
  components: {
  },
  props: {},
  data () {
    return {
      menuCollapse: false,
      activeMenu: '',
      loginUser: {
        username: '',
        icon: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'
      },
      menus: []
    }
  },
  computed: {
    firstMenus () {
      return this.menus.filter(item => item.parentId === 0)
    },
    secondMenus () {
      return parentId2 => this.menus.filter(item => item.parentId === parentId2)
    }
  },
  create () {

  },
  mounted () {
    this.activeMenu = window.sessionStorage.getItem('activeMenu')
    if (!this.activeMenu) {
      this.activeMenu = '/welcome'
    }
    this.getInfo()
  },
  methods: {
    handleCommand (command) {
      console.log(command)
      if (command === 'quit') {
        this.handleLogout()
      }
    },
    handleLogout () {
    },
    selectMenu (index) {
      console.log(index)
      this.activeMenu = index
      window.sessionStorage.setItem('activeMenu', index)
    },
    getInfo () {
    },
    formatPath (folder, name) {
      name = '/' + name
      if (folder) {
        name = '/' + folder + name
      }
      return name
    }
  },
  filter: {

  },
  watch: {
    $route (to) {
      this.selectMenu(to.path)
    }
  }
}
</script>
<style scoped>
  .el-header {
    background-color: #ffffff;
    text-align: center;
    line-height: 60px;
    align-items: center;
    border-bottom: #D3DCE6 solid 1px;
  }
  .el-header> .el-button {
    float: left;
    margin-top: 10px;
  }
  .el-header> .el-breadcrumb {
    float: left;
    margin-top: 21px;
    margin-left: 15px;
  }
  .el-header> .el-dropdown {
    float: right;
  }
  .el-avatar {
    position: relative;
    top: 12px;
  }

  .el-aside {
    background-color: #304156;
    line-height: 200px;
  }

  .el-menu {
    border: none;
  }

  .el-menu> .el-menu-item, .el-submenu> .el-submenu__title {
    text-align: left;
  }

  .el-main {
    background-color: #E9EEF3;
  }

  body > .el-container {
    margin-bottom: 40px;
    height: 100%;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  .el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }

  .menu-second {
    background-color: #1f2d3d;
  }
</style>
