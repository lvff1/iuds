<template>
  <div>
    <el-button type="primary" @click="openDialog" plain>添加部门</el-button>
    <el-button type="danger" plain @click="deptDel">批量删除</el-button>
     <!-- 数据展示部分 -->
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%"
      @selection-change="deptSelectionChange" fit stripe border :cell-style="{ textAlign: 'center' }"
      :header-cell-style="{ textAlign: 'center' }">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="deptno" label="部门编号" width="120">
      </el-table-column>
      <el-table-column prop="dname" label="部门名称" width="120">
      </el-table-column>
      <el-table-column prop="ioc" label="部门地址" width="120">
      </el-table-column>
    
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" plain @click="deptEdit(scope.row)">编辑</el-button>
          <el-button size="mini" plain type="danger" @click="deptDel(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加修改表单-->
    <el-dialog title="添加or修改" :visible.sync="deptFormVisible">
      <el-form :model="formData">
        <el-form-item label="部门编号" :label-width="formLabelWidth">
          <el-input v-model="formData.deptno" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="部门名称" :label-width="formLabelWidth">
          <el-input v-model="formData.dname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="部门位置" :label-width="formLabelWidth">
          <el-input v-model="formData.ioc" autocomplete="off"></el-input>
         </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="deptFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addOrUpdateDept">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
export default {
  // 数据
  data() {
    return {
      // 保存表格数据进行相关的展示
      tableData: [],

      //添加 修改表单数据
      formData: {
          deptno:0,
          dname:'',
          ioc:''
      },
      // 添加弹出层是否可见
      deptFormVisible: false,
      isSave:false,

      // 批量删除  多选的结果存在这里
      delSelection: [],

    };
  },
  // 自定义函数
  methods: {
    // 得到首页数据
    getDeptList() {

      // 将对象进行封装 可以更好的调用data中的数据 
      var app = this;
      // 发送请求
      this.axios({
        url: "http://localhost:8082/dept/list",
        methed: "GET"
      }).then(({ data }) => {// 解构表达式 成功后从返回结果中获取到data数据  
        console.log(data)
        // data 是前端数据封装使用的  .data后端返回时携带的键 
        // 将查询到的数据赋值给上述的表格  即 tableData   
        app.tableData = data.data
      }).catch((error) => {
        // 请求失败的回调
        console.log(error);
      });
    },
    //  只有当点击添加时才会进行初始化操作
    openDialog() {

      // 设置弹出层可见
        this.deptFormVisible = true

      //将其设置为默认值
       this.formData.deptno=0;
       this.formData.dname='';
       this.formData.ioc='';
       this.isSave=true
       
  
    },
    // 添加 
    addOrUpdateDept() {
     
      var url01 = 'save';
      var app = this;
      // 判断formData是否有deptno 如果有则进行修改 否则进信息新增
      if (!this.isSave) {
        url01 = 'update'
      }
      // 发送请求
      this.axios({
        url: "http://localhost:8082/dept/" + url01,
        method: "post",
        // 携带数据
        data: app.formData
      }).then(({ data }) => {
        console.log(data)
        // 正确的提示信息
        this.$message({
          message: '成功！',
          type: 'success'
        });
        // 重新加载首页数据
        this.getDeptList()
        // 成功后弹出框消失
        app.deptFormVisible = false


      }).catch((error) => {
        console.log(error)
      }

      )
    },

    // 数据回显
    deptEdit(row) {
      this.deptFormVisible = true
      this.isSave=false
      //发送请求
      this.axios({
        url: "http://localhost:8082/dept/info/" + row.deptno,
        method: "post"

      }).then(({ data }) => {
        console.log(data.data)
        this.formData = data.data

        // 显示框框
      this.deptFormVisible=true

      })

    },

    // 删除
    deptDel(row) {

      console.log(this.delSelection)

      // if(this.delSelection)
      if (row) {
        this.delSelection.push(row.deptno)
      }

      // 确定删除框
      this.$confirm('确定删除？', '删除哦~', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 发送请求
        this.axios({
          url: "http://localhost:8082/dept/remove",
          method: "Post",
          data: this.delSelection
        }).then(() => {
          // 提示相应信息
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          //重新加载页面
          this.getDeptList()
        })

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消删除'
        });
      });

    },
    // 反选  多选框
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },

    // 获取多选框中填充了哪些属性及值
    deptSelectionChange(val) {
      // var array=[]
      for (var i = 0; i <= val.length; i++) {
        this.delSelection.push(val[i].deptno)
      }

    }

  },
  mounted() {
    // 调用方法
    this.getDeptList()
  },

}
</script>

<style>
</style>