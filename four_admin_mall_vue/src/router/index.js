import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    redirect: '/oms/orderList',
    children: [
      {
        path: '/oms/orderList',
        name: 'OrderList',
        //  懒加载
        component: () => import('../views/oms/OrderList.vue')
      },
      {
        path: '/oms/detailOrder',
        name: 'DetailOrder',
        //  懒加载
        component: () => import('../views/oms/DetailOrder.vue')
      },
      {
        path: '/oms/shipList',
        name: 'ShipList',
        //  懒加载
        component: () => import('../views/oms/ShipList.vue')
      },
      {
        path: '/oms/orderTracking',
        name: 'OrderTracking',
        //  懒加载
        component: () => import('../views/oms/OrderTracking.vue')
      },
      {
        path: '/oms/orderSetting',
        name: 'OrderSetting',
        //  懒加载
        component: () => import('../views/oms/OrderSetting.vue')
      }
    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
