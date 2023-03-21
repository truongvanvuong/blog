<template>
  <div class="wrapper">
    <form @submit.prevent="updatePost()">
      <div class="form_control">
        <div class="wrap_heading">
          <div class="from-item">
            <label for=""> Tiêu đề bài viết</label>
            <input type="text" v-model="post.title" />
          </div>
          <div class="from-item">
            <label for="">Ảnh</label>
            <div>
              <a-upload
                v-model:file-list="fileList"
                name="file"
                action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
                :headers="headers"
                @change="handleChange"
              >
                <a-button>
                  <upload-outlined></upload-outlined>
                  Click to Upload
                </a-button>
              </a-upload>
            </div>
          </div>
        </div>
        <div class="edittor">
          <label for="">Nội dung</label>
          <quill-editor v-model:value="post.content" />
        </div>
      </div>
      <div class="btn-create">
        <a-button type="primary" shape="round" size="middle" html-type="submit">
          Cập nhật bài viết
        </a-button>
      </div>
    </form>
  </div>
</template>
<script>
import { message } from "ant-design-vue";
import { UploadOutlined } from "@ant-design/icons-vue";
import { ref, reactive, onMounted } from "vue";
import { useRoute } from "vue-router";
import { quillEditor } from "vue3-quill";
import BlogService from "../../Services/BlogService.js";
export default {
  name: "UpdateArticle",
  components: {
    quillEditor,
    UploadOutlined,
  },
  setup() {
    const route = useRoute();
    const postId = route.params.id;

    const headers = {
      authorization: "authorization-text",
    };
    const fileList = ref([]);

    const post = reactive({
      id: postId,
      title: "",
      img: "",
      content: "",
    });

    const handleChange = (info) => {
      if (info.file.status !== "uploading") {
        console.log(info.file, info.fileList);
      }
      if (info.file.status === "done") {
        message.success(`${info.file.name} file uploaded successfully`);
      } else if (info.file.status === "error") {
        message.error(`${info.file.name} file upload failed.`);
      }
    };

    const getPostEdit = () => {
      BlogService.getPost(postId)
        .then((response) => {
          post.title = response.data.title;
          post.content = response.data.content;
          post.img = response.data.img;
        })
        .catch((error) => {
          console.log(error);
        });
    };

    const updatePost = () => {
      fileList.value.forEach((file) => {
        post.img = file.name;
      });
      BlogService.updatePost(post)
        .then(() => {
          alert("thanh cong");
        })
        .catch((error) => {
          console.log(error);
        });
    };

    onMounted(() => {
      getPostEdit();
    });

    return {
      post,
      fileList,
      headers,
      handleChange,
      updatePost,
    };
  },
};
</script>
<style>
.wrapper {
  margin-top: 40px;
}
.wrap_heading {
  width: 100%;
  display: flex;
  align-items: flex-end;
  justify-content: space-between;
  margin-bottom: 20px;
}
.from-item {
  width: 50%;
  display: flex;
  align-items: flex-end;
}
.from-item:nth-child(2) {
  flex: 1;
}
.from-item > input {
  width: 80%;
  border-top: none;
  border-right: none;
  border-left: none;
  outline: none;
}
.from-item > label {
  margin-right: 12px;
}
.from-item:first-child {
  margin-right: 12px;
}
.edittor {
  width: 100%;
}
.ql-editor {
  min-height: 450px;
}
.btn-create {
  margin: 12px 0;
}
.edittor > label {
  margin-bottom: 12px;
}
</style>
