<template>
  <!-- router-link 추가(isLogin에 따라 링크를 보이고 안보이게 처리)
    user image를 isLogin에 따라 보이고 안보이게 처리 
    => img url을 변수로 처리할 경우 생기는 문제에 대응!
    -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
      <a class="navbar-brand" href="#">
        <img src="../assets/noProfile.png" style="width: 24px; height: 24px; border-radius: 50%" />
        <span style="color: green"
          ><strong> {{ userInfo.data.userName }}</strong></span
        >
        <span v-show="isLogin" to="#" style="color: black">님, 안녕하세요</span>
      </a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link v-show="isLogin" class="nav-link" to="/board">Board</router-link>
          </li>

          <li class="nav-item">
            <router-link v-show="isLogin" class="nav-link" to="/user">MyPage</router-link>
          </li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item" v-show="isLogin">
            <router-link class="nav-link" to="#">Logout</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  props: ["isLogin", "userInfo"],
};
</script>

<style></style>
