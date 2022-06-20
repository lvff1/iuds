<template>
  <div>

    <!-- 进行检索使用的 -->
    <div>
      <el-input v-model="queryParams.ename" placeholder="员工姓名"></el-input>
     <!--  绑定一个值  不可为某个集合 -->
          <el-select v-model="queryParams.deptno" placeholder="请选择部门">

            <!-- v-for--前面的dept相当于在deptData中取出的某个dept对象  主要包括dname deptno 
            
                :label-- 标签中的值

                :key -- 特殊 attribute key 来提供一个排序提示：进行区分取出的是那个dept对象
                
                :value -- 传给后端的值
            -->
            <el-option v-for="dept in deptData " :label="dept.dname" :key="dept.deptno" :value="dept.deptno">
            </el-option>
          </el-select>

      <el-button icon="el-icon-search" type="success" round @click="doQuery">搜索</el-button>
      <el-button icon="el-icon-refresh-right" type="success" round @click="resetQueryParam">重置</el-button>
    </div>

    <el-button type="primary" @click="openDialog" plain>添加员工</el-button>
    <el-button type="danger" plain @click="empDel">批量删除</el-button>
    <!-- 数据展示部分 -->
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%"
      @selection-change="empSelectionChange" fit stripe border :cell-style="{ textAlign: 'center' }"
      :header-cell-style="{ textAlign: 'center' }">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="ename" label="姓名" width="120">
      </el-table-column>
      <el-table-column prop="sal" label="工资" width="120">
      </el-table-column>
      <el-table-column prop="comm" label="奖金" width="120">
      </el-table-column>
      <el-table-column prop="job" label="职位" width="120">
      </el-table-column>
      <el-table-column prop="hiredate" label="入职日期" width="120">
      </el-table-column>
      <el-table-column prop="mgr" label="老板" width="120">
      </el-table-column>
      <el-table-column prop="deptno" label="部门编号" show-overflow-tooltip>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" plain @click="empEdit(scope.row)">编辑</el-button>
          <el-button size="mini" plain type="danger" @click="empDel(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页代码 -->
    <el-pagination background layout="total, sizes, prev, pager, next, jumper" :total="total" :page-size="size"
      :page-sizes="pageSize" @prev-click="currentChange" @next-click="currentChange" @current-change="currentChange"
      @size-change="sizeChange">
    </el-pagination>

    <!-- 添加修改表单-->
    <el-dialog title="添加or修改" :visible.sync="empFormVisible">
      <el-form :model="formData">
        <el-form-item label="员工姓名" :label-width="formLabelWidth">
          <el-input v-model="formData.ename" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="工资" :label-width="formLabelWidth">
          <el-input v-model="formData.sal" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="奖金" :label-width="formLabelWidth">
          <el-input v-model="formData.comm" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="职位" :label-width="formLabelWidth">
          <el-input v-model="formData.job" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="入职时间">
          <el-col :span="11">
            <el-form-item prop="hiredate">
              <el-date-picker type="date" placeholder="选择日期" v-model="formData.hiredate" format="yyyy-MM-dd"
                value-format="yyyy-MM-dd" style="width: 100%"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="老板编号" :label-width="formLabelWidth">
          <el-input v-model="formData.mgr" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="部门编号" :label-width="formLabelWidth">

          <!--  判断一个值  不可为某个集合 -->
          <el-select v-model="deptData.deptno" placeholder="请选择部门">

            <!-- v-for--前面的dept相当于在deptData中取出的某个dept对象  主要包括dname deptno 
            
                :label-- 标签中的值

                :key -- 特殊 attribute key 来提供一个排序提示：进行区分取出的是那个dept对象
                
                :value -- 传给后端的值
            -->
            <el-option v-for="dept in deptData " :label="dept.dname" :key="dept.deptno" :value="dept.deptno">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="empFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addOrUpdateEmp">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
export default {
  // 数据
  data() {
    return {

      // 部门数据
      deptData: [],
      // 保存表格数据进行相关的展示
      tableData: [],

      queryParams: {
        ename: '',
        deptno: ''
      },
      // 分页相关
      current: 1,// 当前页
      size: 5, // 页面中一次性显示几条数据
      total: 0, //总条数
      pageSize: [5, 10, 15],
      //添加 修改表单数据
      formData: {
        empno: 0,
        ename: '',
        sal: '',
        comm: '',
        job: '',
        hiredate: '',
        mgr: 0,
        deptno: '',
      },
      // 添加弹出层是否可见
      empFormVisible: false,

      // 批量删除  多选的结果存在这里
      delSelection: [],

    };
  },
  // 自定义函数
  methods: {
    // 得到首页数据
    getEmpList() {
      // 将对象进行封装 可以更好的调用data中的数据 
      var app = this;
      // 发送请求
      this.http({
        url: "emp/page",
        method: "post",
        // 将当前页及大小传到后台
        data: {
          current: app.current,
          size: app.size
        }
      }).then(({ data }) => {// 解构表达式 成功后从返回结果中获取到data数据  
        console.log(data)
        // data 是前端数据封装使用的  .data后端返回时携带的键 
        // 将查询到的数据赋值给上述的表格  即 tableData   
        app.tableData = data.data.records
        app.total = data.data.total
        app.current = data.data.current
      }).catch((error) => {
        // 请求失败的回调
        console.log(error);
      });
    },
    //  只有当点击添加时才会进行初始化操作
    openDialog() {
      // 设置弹出层可见
      this.empFormVisible = true
      //将其设置为默认值
      this.formData.empno = 0
      this.formData.ename = '',
        this.formData.sal = '',
        this.formData.comm = '',
        this.formData.job = '',
        this.formData.hiredate = '',
        this.formData.mgr = 0,
        this.formData.deptno = ''
    },
    // 添加 
    addOrUpdateEmp() {
      var url01 = 'save';
      var app = this;
      // 判断formData是否有empno  如果有则进行修改 否则进信息新增
      if (this.formData.empno != 0) {
        url01 = 'update'
      }
      // 发送请求
      this.http({
        url: "emp/" + url01,
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
        this.getEmpList()
        // 成功后弹出框消失
        app.empFormVisible = false
      }).catch((error) => {
        console.log(error)
      }

      )
    },

    // 数据回显
    empEdit(row) {
      this.empFormVisible = true
      //发送请求
      this.http({
        url: "emp/info/" + row.empno,
        method: "post"

      }).then(({ data }) => {
        console.log(data.data)
        this.formData = data.data

        // 显示框框
        this.empFormVisible = true

      })

    },

    // 删除
    empDel(row) {

      console.log(this.delSelection)

      // 单个删除
      // if(this.delSelection)
      if (row) {
        this.delSelection.push(row.empno)
      }
      // 确定删除框
      this.$confirm('确定删除？', '删除哦~', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 发送请求
        this.http({
          url: "emp/remove",
          method: "Post",
          data: this.delSelection
        }).then(() => {
          // 提示相应信息
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          //重新加载页面
          this.getEmpList()
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
    empSelectionChange(val) {
      // var array=[]
      for (var i = 0; i <= val.length; i++) {
        this.delSelection.push(val[i].empno)
      }

    },

    // 点击上一页或下一页按钮进行切换
    currentChange(current) {
      console.log(current)
      this.current = current
      // 刷新
      this.getEmpList()
    },

    sizeChange(size) {
      this.size = size
      this.getEmpList()
    },

    // 获取部门编号及名称
    getDept() {
      // 发送请求
      this.http({
        url: "dept/list",
        method: "get"
      }).then(({ data }) => {
        if(data.code==200){
          // 赋值
          this.deptData = data.data
        }
     

      })
    },


    // 进行条件搜索
    doQuery(){
      var app=this;
      this.http({
        url:'emp/query',
        method:"post",
        data:{
          current: app.current,
          size: app.size,
          ename:app.queryParams.ename,
          deptno:app.queryParams.deptno
          
        }

      }).then(({data})=>{
        console.log(data)
        if(data.code==200){
          app.tableData=data.data.records
        }
      })
            



    },

    // 重置
    resetQueryParam() {
      this.queryParams = {}
      this.getEmpList()
    }



  },
  mounted() {
    // 获取当前dept的编号
    this.getDept()
    // 调用方法
    this.getEmpList()





  },

}
</script>

<style>
</style>