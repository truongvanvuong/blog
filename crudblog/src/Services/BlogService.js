import axios from "axios";
import baseUrl from "./baseUrl";

const baseApi = baseUrl.url;
const resource = "/blog";
export default {
  get() {
    return axios.get(baseApi + `${resource}/`);
  },
  getPost(postId) {
    return axios.get(baseApi + `${resource}/${postId}`);
  },
  createPost(post) {
    return axios.post(baseApi + `${resource}/`, post);
  },
  updatePost(post) {
    return axios.put(baseApi + `${resource}/`, post);
  },
  deletePost(postId) {
    return axios.delete(baseApi + `${resource}/${postId}`);
  },
};
