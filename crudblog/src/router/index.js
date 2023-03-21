import { createRouter, createWebHistory } from "vue-router";
import AddArticle from "../views/AddArticle";
import UpdateArticle from "../views/UpdateArticle";
import HomePage from "../views/Home";
import DetailPost from "../views/detail";

const routes = [
  {
    path: "/home",
    name: "HomePage",
    component: HomePage,
  },
  {
    path: "/addArticle",
    name: "AddArticle",
    component: AddArticle,
  },
  {
    path: "/updateArticle/:id",
    name: "UpdateArticle",
    component: UpdateArticle,
  },
  {
    path: "/detailpost/:id",
    name: "DetailPost",
    component: DetailPost,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
