<template>
  <div class="wrap-detail">
    <h1 class="title">{{ post.title }}</h1>
    <div class="content" v-html="post.content"></div>
  </div>
</template>

<script>
import { useRoute } from "vue-router";
import { ref } from "vue";
import BlogService from "../../Services/BlogService.js";
export default {
  name: "DetailPost",
  setup() {
    const route = useRoute();
    const post = ref([]);
    const postId = route.params.id;
    const getPost = () => {
      BlogService.getPost(postId)
        .then((response) => {
          post.value = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    };
    getPost();
    return {
      post,
    };
  },
};
</script>
<style>
.title {
  text-align: center;
  padding-top: 20px;
}
.content {
  font-size: 18px;
  width: 900px;
  margin: auto;
}
.ql-align-center {
  text-align: center;
}
.ql-align-justify {
  text-align: justify;
}
</style>
