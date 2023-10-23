import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import UserManagement from '@/components/UserManagement'
import ClassManagement from '@/components/ClassManagement'
import AssociationManager from '@/components/AssociationManager'
import ActivityManagement from '../components/ActivityManagement.vue'
Vue.use(Router)

export default new Router({
  mode: 'history',
  base: '/h',
  
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    //用户登录界面
    
    //用户注册界面

    //用户管理面板
    {
      path: '/UserManagement',
      name: 'UserManagement',
      component: UserManagement
    },
    //班级管理面板
    {
      path: '/ClassManagement',
      name: 'ClassManagement',
      component: ClassManagement
    },
    //社团管理面板
    {
      path: '/AssociationManager',
      name: 'AssociationManager',
      component: AssociationManager
    },
    //活动管理面板
    {
      path: '/ActivityManagement',
      name: 'ActivityManagement',
      component: ActivityManagement
    },
  ]
})
