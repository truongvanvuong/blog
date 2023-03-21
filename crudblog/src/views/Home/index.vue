<template>
  <div class="wrap-home">
    <div class="container-fluid">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-5">
        <div
          class="col"
          v-for="blog in blogs"
          v-bind:key="blog.id"
          style="margin-top: 12px"
        >
          <router-link :to="{ name: 'DetailPost', params: { id: blog.id } }">
            <a-card hoverable style="width: 240px">
              <template #cover>
                <img
                  v-bind:alt="blog.title"
                  :src="require(`@/assets/` + blog.img)"
                />
              </template>
              <a-card-meta :title="blog.title"> </a-card-meta>
              <div class="action">
                <div class="btn_action">
                  <router-link
                    :to="{ name: 'UpdateArticle', params: { id: blog.id } }"
                  >
                    <a-button
                      type="primary"
                      shape="circle"
                      size="large"
                      style="margin-right: 6px"
                    >
                      <template #icon>
                        <edit-outlined />
                      </template>
                    </a-button>
                  </router-link>
                  <a-button
                    type="primary"
                    shape="circle"
                    size="large"
                    @click.stop="handleDelete(blog.id)"
                  >
                    <template #icon>
                      <delete-outlined />
                    </template>
                  </a-button>
                </div>
              </div>
            </a-card>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { defineComponent, ref } from "vue";
import { useMenu } from "../../stores/user-menu.js";
import BlogService from "../../Services/BlogService.js";
import { DeleteOutlined, EditOutlined } from "@ant-design/icons-vue";
export default defineComponent({
  name: "HomePage",
  components: {
    DeleteOutlined,
    EditOutlined,
  },
  methods: {
    handleDelete(id) {
      BlogService.deletePost(id)
        .then((response) => {
          console.log(response);
          location.reload();
          this.$forceUpdate();
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  setup() {
    useMenu().onSelectedKeys(["HomePage"]);

    const blogs = ref([]);

    const getBlogs = () => {
      BlogService.get()
        .then((response) => {
          blogs.value = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    };
    getBlogs();
    return {
      blogs,
    };
  },
});
</script>
<style>
.wrap-home {
  margin-top: 24px;
  padding-right: 12px;
}
.action {
  position: absolute;
  top: 8px;
  right: 8px;
}
</style>
