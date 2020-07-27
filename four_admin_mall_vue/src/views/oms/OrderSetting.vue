<template>
    <div>
      <el-card>
        <div>
          <el-form label-position="right" label-width="150px" :model="orderSettingData">
            <el-form-item label="秒杀订单超过：">
              <el-input v-model="orderSettingData.flashOrderOvertime">
                <template slot="append">分</template>
              </el-input>
              <span class="s-span">未付款，订单自动关闭</span>
            </el-form-item>
            <el-form-item label="正常订单超过：">
              <el-input v-model="orderSettingData.normalOrderOvertime">
                <template slot="append">分</template>
              </el-input>
              <span class="s-span">未付款，订单自动关闭</span>
            </el-form-item>
            <el-form-item label="发货超过：">
              <el-input v-model="orderSettingData.confirmOvertime">
                <template slot="append">天</template>
              </el-input>
              <span class="s-span">未收货，订单自动完成</span>
            </el-form-item>
            <el-form-item label="订单完成超过：">
              <el-input v-model="orderSettingData.finishOvertime">
                <template slot="append">天</template>
              </el-input>
              <span class="s-span">自动结束交易，不能申请售后</span>
            </el-form-item>
            <el-form-item label="订单完成超过：">
              <el-input v-model="orderSettingData.commentOvertime">
                <template slot="append">天</template>
              </el-input>
              <span class="s-span">未评价，自动五星好评</span>
            </el-form-item>
          </el-form>
          <div style="margin-left: 20%">
            <el-button type="primary" size="small" @click="save">提交</el-button>
          </div>
        </div>
      </el-card>
    </div>
</template>

<script>
export default {
  // name: "OrderSetting"
  data () {
    return {
      orderSettingData: {
        flashOrderOvertime: 15,
        normalOrderOvertime: 30,
        confirmOvertime: 15,
        finishOvertime: 7,
        commentOvertime: 7
      }
    }
  },
  methods: {
    save () {
      this.$message({
        type: 'success',
        message: '保存成功!'
      })
    }
  }
}
</script>

<style scoped>
  .el-input {
    width: 250px;
  }
  .s-input {
    margin-top: 20px;
  }
  .s-span {
    margin-left: 15px;
  }
</style>
