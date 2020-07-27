<template>
  <div>
    <el-card>
      <div class="card-heade">
        <div style="float: left">
          <i class="el-icon-search"></i><span>筛选搜索</span>
        </div>
        <el-button size="small" type="success" style="float: right">重置</el-button>
        <el-button size="small" type="primary" style="float: right">查询</el-button>
      </div>
      <el-form :inline="true">
        <el-row>
          <el-col :span="8">
            <el-form-item label="输入搜索">
              <el-input clearable size="small" placeholder="订单编号"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="收货人">
              <el-input clearable size="small" placeholder="收货人姓名/手机号码"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="提交时间">
              <el-date-picker
                v-model="value1"
                type="datetime"
                placeholder="选择日期时间" size="small">
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row >
          <el-col :span="8">
            <el-form-item label="订单状态">
              <el-select v-model="status" placeholder="请选择" size="small">
                <el-option
                  v-for="item in statusOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="支付方式">
              <el-select v-model="payType" placeholder="请选择" size="small">
                <el-option
                  v-for="item in payTypeOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="订单来源">
              <el-select v-model="sourceType" placeholder="请选择" size="small">
                <el-option
                  v-for="item in sourceTypeOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div class="card-heade">
        <i class="el-icon-s-order"></i><span>数据列表</span>
      </div>
      <div class="table-style">
        <el-table
          border
          ref="multipleTable"
          :data="orderData"
          tooltip-effect="dark"
          style="width: 100%"
          @selection-change="handleSelectionChange">
          <el-table-column
            type="selection"
            width="55">
          </el-table-column>
          <el-table-column
            align="center"
            label="编号"
            prop="id"
            width="50">
          </el-table-column>
          <el-table-column
            align="center"
            prop="orderSn"
            label="订单编号"
            width="160px">
          </el-table-column>
          <el-table-column
            align="center"
            prop="createTime"
            label="提交时间"
            width="180px">
          </el-table-column>
          <el-table-column
            align="center"
            prop="memberUsername"
            label="用户账号">
          </el-table-column>
          <el-table-column label="订单金额" align="center">
            <template slot-scope="scope">￥{{scope.row.payAmount}}</template>
          </el-table-column>
          <el-table-column label="支付方式" align="center">
            <template slot-scope="scope">{{scope.row.payType | payTypeFilter}}</template>
          </el-table-column>
          <el-table-column label="订单来源" align="center">
            <template slot-scope="scope">{{scope.row.sourceType | sourceTypeFilter}}</template>
          </el-table-column>
          <el-table-column label="订单状态" align="center">
            <template slot-scope="scope">{{scope.row.status | statusFilter}}</template>
          </el-table-column>
          <el-table-column label="操作" align="center" width="230px">
            <template slot-scope="scope">
              <el-button size="mini" type="success"
                         @click="handleToDetail(scope.$index, scope.row)">查看订单</el-button>
              <el-button size="mini" type="primary" v-if="scope.row.status < 4"
                         @click="handleOperate(scope.$index, scope.row)">{{scope.row.status | btnFilter}}</el-button>
              <el-button size="mini" type="danger" v-else
                         @click="handleOperate(scope.$index)">{{scope.row.status | btnFilter}}</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data () {
    return {
      value: [],
      orderData: [
        {
          id: 24,
          orderSn: '202020202020',
          createTime: '2020-02-02 09:20:20',
          memberUsername: 'MINO',
          payAmount: 18732,
          payType: 1,
          sourceType: 1,
          status: 0
        },
        {
          id: 25,
          orderSn: '202020202020',
          createTime: '2020-02-02 09:20:20',
          memberUsername: 'MINO',
          payAmount: 18732,
          payType: 0,
          sourceType: 0,
          status: 1
        },
        {
          id: 26,
          orderSn: '202020202020',
          createTime: '2020-02-02 09:20:20',
          memberUsername: 'MINO',
          payAmount: 18732,
          payType: 0,
          sourceType: 0,
          status: 2
        },
        {
          id: 27,
          orderSn: '202020202020',
          createTime: '2020-02-02 09:20:20',
          memberUsername: 'MINO',
          payAmount: 18732,
          payType: 0,
          sourceType: 0,
          status: 3
        },
        {
          id: 28,
          orderSn: '202020202020',
          createTime: '2020-02-02 09:20:20',
          memberUsername: 'MINO',
          payAmount: 18732,
          payType: 0,
          sourceType: 0,
          status: 4
        },
        {
          id: 29,
          orderSn: '202020202020',
          createTime: '2020-02-02 09:20:20',
          memberUsername: 'MINO',
          payAmount: 18732,
          payType: 0,
          sourceType: 0,
          status: 5
        }
      ],
      select: '',
      selectStatus: '',
      value1: '',
      statusOptions: [ // 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
        { value: 0, label: '待付款' },
        { value: 1, label: '待发货' },
        { value: 2, label: '已发货' },
        { value: 3, label: '已完成' },
        { value: 4, label: '已关闭' },
        { value: 5, label: '无效订单' }
      ],
      status: '',
      payTypeOptions: [ // 支付方式：0->未支付；1->支付宝；2->微信',
        { value: 0, label: '未支付' },
        { value: 1, label: '支付宝' },
        { value: 2, label: '微信' }
      ],
      sourceTypeOptions: [ // 订单来源：0->PC订单；1->app订单
        { value: 0, label: 'PC订单' },
        { value: 1, label: 'app订单' }
      ],
      sourceType: '',
      payType: ''
    }
  },
  filters: {
    statusFilter (value) { // 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
      let text = '待付款'
      if (value === 1) {
        text = '待发货'
      } else if (value === 2) {
        text = '已发货'
      } else if (value === 3) {
        text = '已完成'
      } else if (value === 4) {
        text = '已关闭'
      } else if (value === 5) {
        text = '无效订单'
      }
      return text
    },
    btnFilter (value) { // 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
      let text = '提醒付款'
      if (value === 1) {
        text = '订单发货'
      } else if (value === 2) {
        text = '订单跟踪'
      } else if (value === 3) {
        text = '订单跟踪'
      } else if (value === 4) {
        text = '删除订单'
      } else if (value === 5) {
        text = '删除订单'
      }
      return text
    },
    payTypeFilter (value) { // 支付方式：0->未支付；1->支付宝；2->微信',
      let text = '未支付'
      if (value === 1) {
        text = '支付宝'
      } else if (value === 2) {
        text = '微信'
      }
      return text
    },
    sourceTypeFilter (value) { // 订单来源：0->PC订单；1->app订单
      let text = 'PC订单'
      if (value === 1) {
        text = 'app订单'
      }
      return text
    }
  },
  methods: {
    handleChange (value) {
      console.log(value)
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    handleToDetail (index, row) {
      console.log(index, row)
      this.$router.push({ path: '/oms/detailOrder' })
    },
    handleOperate (index) {
      console.log(index)
      if (index === 0) {
        this.$message({
          type: 'success',
          message: '提醒成功!'
        })
      } else if (index === 1) {
        console.log('订单发货！')
        this.$router.push({ path: '/oms/shipList' })
      } else if (index === 2) { // 订单跟踪
        this.$router.push({ path: '/oms/orderTracking' })
      }
      // this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
      //   confirmButtonText: '确定',
      //   cancelButtonText: '取消',
      //   type: 'warning'
      // }).then(() => {
      //   this.tableData.splice(index, 1)
      //   this.$message({
      //     type: 'success',
      //     message: '删除成功!'
      //   })
      // }).catch(() => {
      //   this.$message({
      //     type: 'info',
      //     message: '已取消删除'
      //   })
      // })
    }
  }
}
</script>

<style scoped>
  .table-style {
    margin-top: 10px;
  }
  .card-heade {
    font-size: 16px;
  }
  .el-form {
    margin-top: 40px;
  }
  .box-card {
    margin-top: 20px;
  }
  .el-row {
    margin-bottom: 0;
  }
  .el-col {
    border-radius: 4px;
  }
  .el-card {
    font-size: 14px;
  }

</style>
