<template>
  <el-container style="height: 700px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu>
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-caret-bottom"></i>数据管理</template>
          <el-menu-item-group>

            <el-menu-item index="1-1">
              <router-link to="/index">
                首页
              </router-link>
            </el-menu-item>

            <el-menu-item index="1-2">
              <router-link to="/emp">
                员工管理
              </router-link>
            </el-menu-item>

            <el-menu-item index="1-3">
              <router-link to="/dept">
                部门管理
              </router-link>
            </el-menu-item>

            <el-menu-item index="1-3">
              <router-link to="/user">
                用户管理
              </router-link>
            </el-menu-item>

            <el-menu-item index="1-3">
              <router-link to="/role">
                角色管理
              </router-link>
            </el-menu-item>
          </el-menu-item-group>

        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>查看</el-dropdown-item>
            <el-dropdown-item>新增</el-dropdown-item>
            <el-dropdown-item>删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>孙玮博</span>
      </el-header>

      <el-main>
        <!-- <el-table :data="tableData">
        <el-table-column prop="date" label="日期" width="140">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="120">
        </el-table-column>
        <el-table-column prop="address" label="地址">
        </el-table-column>
      </el-table> -->

        <!-- 在此处导入视图 -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>


</template>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>

<script>
export default {
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      tableData: Array(20).fill(item)
    }
  }
};
</script>