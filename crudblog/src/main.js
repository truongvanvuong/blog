import { createApp } from "vue";
import App from "./App.vue";
import { Drawer, List, Menu, Card, Button, Upload } from "ant-design-vue";
import { createPinia } from "pinia";
import "./registerServiceWorker";
import router from "./router";

import "bootstrap/dist/css/bootstrap.min.css";
import "ant-design-vue/dist/antd.css";

const pinia = createPinia();
const app = createApp(App);
app.use(Drawer);
app.use(List);
app.use(Menu);
app.use(Card);
app.use(Button);
app.use(Upload);
app.use(router);
app.use(pinia);
app.mount("#app");
