<template>
  <TheHeader />
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-2 siderbar">
        <div>
          <a-list bordered style="width: 100%">
            <template #header>
              <div>Bảng Điều Khiển</div>
            </template>
            <TheMenu />
          </a-list>
        </div>
      </div>
      <div class="col-sm-10">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
import TheHeader from "./components/TheHeader.vue";
import TheMenu from "./components/TheMenu.vue";
export default {
  name: "app",
  components: {
    TheHeader,
    TheMenu,
  },
  data() {
    return {};
  },
  mounted() {},
};
</script>
<style>
.siderbar {
  float: left;
  position: sticky;
  top: 66px; /* Nếu header của bạn có độ cao là 66px */
  height: calc(
    100vh - 66px
  ); /* Giảm độ cao của sidebar đi 66px để không bị đè lên phần content */
  padding-left: 0 !important;
}
</style>
