import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

// Component import
import BoardMain from "@/components/BoardMain.vue";
import LoginPage from "@/components/LoginPage.vue";
import UserPage from "@/components/UserPage.vue";

export default new VueRouter({
  routes: [
    {
      path: "/",
      component: LoginPage,
    },
    {
      name: "LoginPage",
      path: "/login",
      component: LoginPage,
    },
    {
      name: "BoardMain",
      path: "/board",
      component: BoardMain,
    },
    {
      name: "UserPage",
      path: "/user",
      component: UserPage,
    },
  ],
});
