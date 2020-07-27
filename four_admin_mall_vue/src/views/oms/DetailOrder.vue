<template>
  <div>
    <el-card>
      <el-steps :active="4" finish-status="success" align-center>
        <el-step title="提交订单" description="2020-02-02 20:20:00"></el-step>
        <el-step title="支付订单" description="2020-02-02 20:20:00"></el-step>
        <el-step title="平台发货" description="2020-02-02 20:20:00"></el-step>
        <el-step title="确认收货" description="2020-02-02 20:20:00"></el-step>
        <el-step title="完成评价" description="2020-02-02 20:20:00"></el-step>
      </el-steps>
    </el-card>
    <p class="pc"><i class="el-icon-warning"></i>当前订单状态：已完成</p>
    <el-card>
      <h4><i class="el-icon-s-order"></i>基本信息</h4>
      <el-table
        :data="detailOrderData"
        border
        style="width: 100%"
        :header-cell-style="{background:'#eef1f6',color:'#606266'}">
        <el-table-column
          prop="orderSn"
          label="订单编号"
          align="center">
        </el-table-column>
        <el-table-column
          prop="serialNumber"
          label="发货单流水号"
          align="center">
        </el-table-column>
        <el-table-column
          prop="memberUsername"
          label="用户账号"
          align="center">
        </el-table-column>
        <el-table-column
          prop="payType"
          label="支付方式"
          align="center">
        </el-table-column>
        <el-table-column
          prop="sourceType"
          label="订单来源"
          align="center">
        </el-table-column>
        <el-table-column
          prop="orderType"
          label="订单类型"
          align="center">
        </el-table-column>
      </el-table>
      <el-table
        :data="detailOrderData"
        border
        style="width: 100%"
        :header-cell-style="{background:'#eef1f6',color:'#606266'}">
        <el-table-column
          prop="deliveryCompany"
          label="配送方式"
          align="center">
        </el-table-column>
        <el-table-column
          prop="deliverySn"
          label="物流单号"
          align="center">
        </el-table-column>
        <el-table-column
          prop="autoConfirmDay"
          label="自动确认收货时间"
          align="center">
        </el-table-column>
        <el-table-column
          prop="integration"
          label="可以获得的积分"
          align="center">
        </el-table-column>
        <el-table-column
          prop="growth"
          label="可以活动的成长值"
          align="center">
        </el-table-column>
        <el-table-column
          prop="promotionInfo"
          label="活动信息"
          align="center">
        </el-table-column>
      </el-table>
      <h4><i class="el-icon-s-custom"></i>收货人信息</h4>
      <el-table
        :data="detailOrderData"
        border
        style="width: 100%"
        :header-cell-style="{background:'#eef1f6',color:'#606266'}">
        <el-table-column
          prop="receiverName"
          label="收货人姓名"
          align="center"
          width="100px">
        </el-table-column>
        <el-table-column
          prop="receiverHone"
          label="收货人电话"
          align="center" width="150px">
        </el-table-column>
        <el-table-column
          prop="receiverPostCode"
          label="收货人邮编"
          align="center" width="150px">
        </el-table-column>
        <el-table-column
          label="收货人地址"
          align="center">
          <template slot-scope="scope">{{scope.row.receiverProvince}} {{scope.row.receiverCity}} {{scope.row.receiverRegion}} {{scope.row.receiverDetailAddress}}</template>
        </el-table-column>
      </el-table>
      <h4><i class="el-icon-menu"></i>商品信息</h4>
      <el-table
        :data="detailOrderProductData"
        border
        style="width: 100%"
        :header-cell-style="{background:'#eef1f6',color:'#606266'}">
        <el-table-column
          prop="productPic"
          label="商品图片"
          align="center"
          width="160px">
        </el-table-column>
        <el-table-column
          label="商品名称"
          align="center" width="150px">
          <template slot-scope="scope"><p>{{scope.row.productName}}</p><p>品牌：{{scope.row.productBrand}}</p></template>
        </el-table-column>
        <el-table-column
          label="价格/货号"
          align="center" width="150px">
          <template slot-scope="scope"><p>价格：￥{{scope.row.productPrice}}</p><p>货号：{{scope.row.productsn}}</p></template>
        </el-table-column>
        <el-table-column
          label="属性"
          align="center">
          <template slot-scope="scope">
            <span v-for="(key,value) in scope.row.productAttr" :key="value">{{key.key}}:{{key.value}};</span></template>
        </el-table-column>
        <el-table-column
          prop="productQuantity"
          label="数量"
          align="center" width="50px">
        </el-table-column>
        <el-table-column
            label="小计"
            align="center" width="100px">
            <template slot-scope="scope">￥：{{scope.row.productPrice}}</template>
        </el-table-column>
      </el-table>
      <div>
        <h4 style="float: right"><i class="el-icon-shopping-cart-2"></i>合计：￥18732</h4>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  // name: "DetailOrder"
  data () {
    return {
      detailOrderData: [{
        orderSn: '20160502',
        serialNumber: '暂无',
        memberUsername: 'MINO',
        payType: '支付宝',
        sourceType: 'APP',
        orderType: '正常订单',
        deliveryCompany: '京东',
        deliverySn: '20202020',
        autoConfirmDay: '7',
        integration: '100',
        growth: '100',
        promotionInfo: '促销',
        receiverName: 'MINO',
        receiverHone: '11111111111',
        receiverPostCode: '527300',
        receiverProvince: '广东省',
        receiverCity: '广州市',
        receiverRegion: '黄埔区',
        receiverDetailAddress: '企业加速器'
      }],
      detailOrderProductData: [{
        productPic: '',
        productName: 'huawei',
        productBrand: '华为',
        productPrice: 3788,
        productsn: '123456',
        productAttr: [{ key: '颜色', value: '红色' }, { key: '容量', value: '4G' }],
        productQuantity: 1
      }]
    }
  }
}
</script>

<style scoped>
  .pc {
    color: #b22c46;
    font-size: 16px;
  }
</style>
