<template>
    <div>
      <el-card>
        <h4><i class="el-icon-tickets"></i>发货列表</h4>
        <el-table
          border
          ref="multipleTable"
          :data="shipData"
          tooltip-effect="dark"
          style="width: 100%">
          <el-table-column
            align="center"
            label="订单编号"
            prop="orderSn"
            width="200">
          </el-table-column>
          <el-table-column
            align="center"
            prop="receiverName"
            label="收货人"
            width="100px">
          </el-table-column>
          <el-table-column
            align="center"
            prop="receiverPhone"
            label="手机号码"
            width="150px">
          </el-table-column>
          <el-table-column
            align="center"
            prop="receiverPostCode"
            label="邮政编码"
            width="100px">
          </el-table-column>
          <el-table-column
            label="收货人地址"
            align="center">
            <template slot-scope="scope">{{scope.row.receiverProvince}} {{scope.row.receiverCity}} {{scope.row.receiverRegion}} {{scope.row.receiverDetailAddress}}</template>
          </el-table-column>
          <el-table-column label="配送分式" align="center">
            <el-select v-model="shipData.deliveryCompany" placeholder="请选择" size="small">
              <el-option
                v-for="item in deliveryCompanyOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-table-column>
          <el-table-column label="物流单号" align="center">
            <template>
              <el-input></el-input>
            </template>
          </el-table-column>
        </el-table>
        <div class="btn-style">
          <el-button type="primary" size="small" @click="save">确定</el-button>
          <el-button type="info" size="small" @click="cancel">取消</el-button>
        </div>
      </el-card>
    </div>
</template>

<script>
export default {
  // name: "ShipList"
  data () {
    return {
      shipData: [
        {
          orderSn: '201820192020',
          receiverName: 'mino',
          receiverPhone: '12312312311',
          receiverPostCode: '123456',
          receiverProvince: '广东',
          receiverCity: '广州',
          receiverRegion: '萝岗',
          receiverDetailAddress: '香雪',
          deliveryCompany: '',
          deliverySn: ''
        }
      ],
      deliveryCompanyOptions: [
        { value: 0, label: '中通' },
        { value: 1, label: '顺丰' },
        { value: 2, label: '申通' },
        { value: 3, label: '韵达' }
      ]
    }
  },
  methods: {
    save () {
      this.$message({
        type: 'success',
        message: '保存成功!'
      })
    },
    cancel () {
      this.$router.push({ path: '/oms/orderList' })
    }
  }
}
</script>

<style scoped>
  .btn-style {
    margin-top: 20px;
    text-align: center;
  }
</style>
