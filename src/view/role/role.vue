<template>
  <div>
    <el-button type="primary" @click="openDialog" plain>添加角色</el-button>
    <el-button type="danger" plain @click="roleDel">批量删除</el-button>
     <!-- 数据展示部分 -->
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%"
      @selection-change="roleSelectionChange" fit stripe border :cell-style="{ textAlign: 'center' }"
      :header-cell-style="{ textAlign: 'center' }">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="rname" label="角色名称" width="120">
      </el-table-column>
      <el-table-column prop="rdesc" label="角色描述" width="120">
      </el-table-column>
      <el-table-column prop="rstatus" label="角色状态" width="120">
      </el-table-column>
      <el-table-column prop="createTime" label="角色创建时间" width="120">
      </el-table-column>
    
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" plain @click="roleEdit(scope.row)">编辑</el-button>
          <el-button size="mini" plain type="danger" @click="roleDel(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加修改表单-->
    <el-dialog title="添加or修改" :visible.sync="roleFormVisible">
      <el-form :model="formData">
       
        <el-form-item label="角色名称" :label-width="formLabelWidth">
          <el-input v-model="formData.rname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="角色描述" :label-width="formLabelWidth">
          <el-input v-model="formData.rdesc" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="角色状态" :label-width="formLabelWidth">
          <el-input v-model="formData.rstatus" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="角色创建时间" :label-width="formLabelWidth">
         <el-col :span="11">
            <el-form-item prop="createTime">
              <el-date-picker type="date" placeholder="选择日期" v-model="formData.createTime" format="yyyy-MM-dd"
                value-format="yyyy-MM-dd" style="width: 100%"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
       
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="roleFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addOrUpdateRole">确 定</el-button>
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
        id:0,
        rname:'',
        rdesc:'',
        rstatus:0,
        createTime:''
          
      },
      // 添加弹出层是否可见
      roleFormVisible: false,
    

      // 批量删除  多选的结果存在这里
      delSelection: [],

    };
  },
  // 自定义函数
  methods: {
    // 得到首页数据
    getRoleList() {

      // 将对象进行封装 可以更好的调用data中的数据 
      var app = this;
      // 发送请求
      this.http({
        url: "role/list",
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
        this.roleFormVisible = true

      //将其设置为默认值
        this.formData.id=0;
        this.formData.rname='',
        this.formData.rdesc='',
        this.formData.rstatus=0,
        this.formData.createTime=''
       
  
    },
    // 添加 
    addOrUpdateRole() {
    
      var app = this;
      // 判断formData是否有id 如果有则进行修改 否则进信息新增
      var url01=this.formData.id?"update":"save"
      // 发送请求
      this.http({
        url: "role/" + url01,
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
        this.getRoleList()
        // 成功后弹出框消失
        app.roleFormVisible = false


      }).catch((error) => {
        console.log(error)
      }

      )
    },

    // 数据回显
    roleEdit(row) {
      this.roleFormVisible = true
      
      //发送请求
      this.http({
        url: "role/info/" + row.id,
        method: "post"

      }).then(({ data }) => {
        console.log(data.data)
        this.formData = data.data

        // 显示框框
      this.roleFormVisible=true

      })

    },

    // 删除
    roleDel(row) {

      console.log(this.delSelection)

      // if(this.delSelection)
      if (row) {
        this.delSelection.push(row.id)
      }

      // 确定删除框
      this.$confirm('确定删除？', '删除哦~', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 发送请求
        this.http({
          url: "role/remove",
          method: "Post",
          data: this.delSelection
        }).then(() => {
          // 提示相应信息
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          //重新加载页面
          this.getRoleList()
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
    roleSelectionChange(val) {
      // var array=[]
      for (var i = 0; i <= val.length; i++) {
        this.delSelection.push(val[i].roleno)
      }

    }

  },
  mounted() {
    // 调用方法
    this.getRoleList()
  },

}
</script>

<style>
</style>