<template>
  <header class="wrap_header">
    <div class="header_content">
      <img src="../assets/logo.png" alt="logo" />
      <h2>BLOG</h2>
    </div>
  </header>
</template>
<script>
export default {
  name: "TheHeader",
};
</script>
<style lang="scss">
.wrap_header {
  position: sticky;
  z-index: 10;
  top: 0;
  left: 0;
  right: 0;
  height: 66px;
  background-color: #fff;
  border-bottom: 1px solid #cccc;
}
.header_content {
  margin: 0 24px;
  height: 66px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.header_content > img {
  height: 46px;
  width: 46px;
  border-radius: 8px;
  object-fit: cover;
}
.header_content > h2 {
  margin: 0;
}
</style>
