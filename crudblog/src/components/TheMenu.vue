<template>
  <div class="wrap-menu">
    <a-menu v-model:openKeys="openKeys" v-model:selectedKeys="selectedKeys">
      <a-menu-item key="HomePage">
        <router-link :to="{ name: 'HomePage' }">
          <span class="item_link"><home-outlined class="me-2" />Trang Chủ</span>
        </router-link> </a-menu-item
      ><a-menu-item key="AddArticle">
        <router-link :to="{ name: 'AddArticle' }">
          <span class="item_link"
            ><plus-outlined class="me-2" />Thêm bài viết</span
          >
        </router-link>
      </a-menu-item>
    </a-menu>
  </div>
</template>
<script>
import { HomeOutlined, PlusOutlined } from "@ant-design/icons-vue";
import { useMenu } from "../stores/user-menu.js";
import { storeToRefs } from "pinia";
export default {
  name: "TheMenu",
  components: {
    HomeOutlined,
    PlusOutlined,
  },
  setup() {
    const store = useMenu();

    return {
      ...storeToRefs(store),
    };
  },
};
</script>
<style>
.item_link {
  display: flex;
  align-items: center;
}
</style>
