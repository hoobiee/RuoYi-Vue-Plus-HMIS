<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="酒店名称" prop="hotelName">
        <el-input
          v-model="queryParams.hotelName"
          placeholder="请输入酒店名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="英文名" prop="hotelNameEn">
        <el-input
          v-model="queryParams.hotelNameEn"
          placeholder="请输入英文名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="城市名称" prop="cityName">
        <el-input
          v-model="queryParams.cityName"
          placeholder="请输入城市名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话" prop="hotelPhone">
        <el-input
          v-model="queryParams.hotelPhone"
          placeholder="请输入电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开业时间" prop="openingTime">
        <el-date-picker clearable
          v-model="queryParams.openingTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开业时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="装修时间" prop="decorateTime">
        <el-date-picker clearable
          v-model="queryParams.decorateTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择装修时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="酒店介绍" prop="introduction">
        <el-input
          v-model="queryParams.introduction"
          placeholder="请输入酒店介绍"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="取消政策" prop="canclePolicy">
        <el-input
          v-model="queryParams.canclePolicy"
          placeholder="请输入取消政策"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="酒店地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入酒店地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="酒店英文地址" prop="addressEn">
        <el-input
          v-model="queryParams.addressEn"
          placeholder="请输入酒店英文地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建人" prop="creator">
        <el-input
          v-model="queryParams.creator"
          placeholder="请输入创建人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改人" prop="modifier">
        <el-input
          v-model="queryParams.modifier"
          placeholder="请输入修改人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改时间" prop="modifyTime">
        <el-date-picker clearable
          v-model="queryParams.modifyTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择修改时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="高德经度" prop="gaodeLat">
        <el-input
          v-model="queryParams.gaodeLat"
          placeholder="请输入高德经度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="高德维度" prop="gaodeLon">
        <el-input
          v-model="queryParams.gaodeLon"
          placeholder="请输入高德维度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="谷歌维度" prop="googleLat">
        <el-input
          v-model="queryParams.googleLat"
          placeholder="请输入谷歌维度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="谷歌经度" prop="googleLon">
        <el-input
          v-model="queryParams.googleLon"
          placeholder="请输入谷歌经度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="百度维度" prop="baiduLat">
        <el-input
          v-model="queryParams.baiduLat"
          placeholder="请输入百度维度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="百度经度" prop="baiduLon">
        <el-input
          v-model="queryParams.baiduLon"
          placeholder="请输入百度经度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目的地标签" prop="destinationLable">
        <el-input
          v-model="queryParams.destinationLable"
          placeholder="请输入目的地标签"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['hmis:hotel:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['hmis:hotel:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['hmis:hotel:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hmis:hotel:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="hotelList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="酒店编号" align="center" prop="hotelId" v-if="true"/>
      <el-table-column label="酒店名称" align="center" prop="hotelName" />
      <el-table-column label="英文名" align="center" prop="hotelNameEn" />
      <el-table-column label="城市名称" align="center" prop="cityName" />
      <el-table-column label="星级(1/2/3/4/5)" align="center" prop="star" />
      <el-table-column label="电话" align="center" prop="hotelPhone" />
      <el-table-column label="开业时间" align="center" prop="openingTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openingTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="装修时间" align="center" prop="decorateTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.decorateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="酒店介绍" align="center" prop="introduction" />
      <el-table-column label="取消政策" align="center" prop="canclePolicy" />
      <el-table-column label="支持的信用卡" align="center" prop="creditCards" />
      <el-table-column label="酒店设施列表" align="center" prop="facilities" />
      <el-table-column label="酒店地址" align="center" prop="address" />
      <el-table-column label="酒店英文地址" align="center" prop="addressEn" />
      <el-table-column label="创建人" align="center" prop="creator" />
      <el-table-column label="修改人" align="center" prop="modifier" />
      <el-table-column label="修改时间" align="center" prop="modifyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.modifyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="高德经度" align="center" prop="gaodeLat" />
      <el-table-column label="高德维度" align="center" prop="gaodeLon" />
      <el-table-column label="谷歌维度" align="center" prop="googleLat" />
      <el-table-column label="谷歌经度" align="center" prop="googleLon" />
      <el-table-column label="百度维度" align="center" prop="baiduLat" />
      <el-table-column label="百度经度" align="center" prop="baiduLon" />
      <el-table-column label="目的地标签" align="center" prop="destinationLable" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hmis:hotel:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hmis:hotel:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改酒店详情列对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="酒店名称" prop="hotelName">
          <el-input v-model="form.hotelName" placeholder="请输入酒店名称" />
        </el-form-item>
        <el-form-item label="英文名" prop="hotelNameEn">
          <el-input v-model="form.hotelNameEn" placeholder="请输入英文名" />
        </el-form-item>
        <el-form-item label="城市名称" prop="cityName">
          <el-input v-model="form.cityName" placeholder="请输入城市名称" />
        </el-form-item>
        <el-form-item label="电话" prop="hotelPhone">
          <el-input v-model="form.hotelPhone" placeholder="请输入电话" />
        </el-form-item>
        <el-form-item label="开业时间" prop="openingTime">
          <el-date-picker clearable
            v-model="form.openingTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择开业时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="装修时间" prop="decorateTime">
          <el-date-picker clearable
            v-model="form.decorateTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择装修时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="酒店介绍" prop="introduction">
          <el-input v-model="form.introduction" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="取消政策" prop="canclePolicy">
          <el-input v-model="form.canclePolicy" placeholder="请输入取消政策" />
        </el-form-item>
        <el-form-item label="酒店地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入酒店地址" />
        </el-form-item>
        <el-form-item label="酒店英文地址" prop="addressEn">
          <el-input v-model="form.addressEn" placeholder="请输入酒店英文地址" />
        </el-form-item>
        <el-form-item label="创建人" prop="creator">
          <el-input v-model="form.creator" placeholder="请输入创建人" />
        </el-form-item>
        <el-form-item label="修改人" prop="modifier">
          <el-input v-model="form.modifier" placeholder="请输入修改人" />
        </el-form-item>
        <el-form-item label="修改时间" prop="modifyTime">
          <el-date-picker clearable
            v-model="form.modifyTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择修改时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="高德经度" prop="gaodeLat">
          <el-input v-model="form.gaodeLat" placeholder="请输入高德经度" />
        </el-form-item>
        <el-form-item label="高德维度" prop="gaodeLon">
          <el-input v-model="form.gaodeLon" placeholder="请输入高德维度" />
        </el-form-item>
        <el-form-item label="谷歌维度" prop="googleLat">
          <el-input v-model="form.googleLat" placeholder="请输入谷歌维度" />
        </el-form-item>
        <el-form-item label="谷歌经度" prop="googleLon">
          <el-input v-model="form.googleLon" placeholder="请输入谷歌经度" />
        </el-form-item>
        <el-form-item label="百度维度" prop="baiduLat">
          <el-input v-model="form.baiduLat" placeholder="请输入百度维度" />
        </el-form-item>
        <el-form-item label="百度经度" prop="baiduLon">
          <el-input v-model="form.baiduLon" placeholder="请输入百度经度" />
        </el-form-item>
        <el-form-item label="目的地标签" prop="destinationLable">
          <el-input v-model="form.destinationLable" placeholder="请输入目的地标签" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listHotel, getHotel, delHotel, addHotel, updateHotel } from "@/api/hmis/hotel";

export default {
  name: "Hotel",
  data() {
    return {
      // 按钮loading
      buttonLoading: false,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 酒店详情列表格数据
      hotelList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        hotelName: undefined,
        hotelNameEn: undefined,
        cityName: undefined,
        star: undefined,
        hotelPhone: undefined,
        openingTime: undefined,
        decorateTime: undefined,
        introduction: undefined,
        canclePolicy: undefined,
        creditCards: undefined,
        facilities: undefined,
        address: undefined,
        addressEn: undefined,
        creator: undefined,
        modifier: undefined,
        modifyTime: undefined,
        gaodeLat: undefined,
        gaodeLon: undefined,
        googleLat: undefined,
        googleLon: undefined,
        baiduLat: undefined,
        baiduLon: undefined,
        destinationLable: undefined
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        hotelId: [
          { required: true, message: "酒店编号不能为空", trigger: "blur" }
        ],
        hotelName: [
          { required: true, message: "酒店名称不能为空", trigger: "blur" }
        ],
        hotelNameEn: [
          { required: true, message: "英文名不能为空", trigger: "blur" }
        ],
        cityName: [
          { required: true, message: "城市名称不能为空", trigger: "blur" }
        ],
        star: [
          { required: true, message: "星级(1/2/3/4/5)不能为空", trigger: "change" }
        ],
        hotelPhone: [
          { required: true, message: "电话不能为空", trigger: "blur" }
        ],
        openingTime: [
          { required: true, message: "开业时间不能为空", trigger: "blur" }
        ],
        decorateTime: [
          { required: true, message: "装修时间不能为空", trigger: "blur" }
        ],
        introduction: [
          { required: true, message: "酒店介绍不能为空", trigger: "blur" }
        ],
        canclePolicy: [
          { required: true, message: "取消政策不能为空", trigger: "blur" }
        ],
        creditCards: [
          { required: true, message: "支持的信用卡不能为空", trigger: "change" }
        ],
        facilities: [
          { required: true, message: "酒店设施列表不能为空", trigger: "change" }
        ],
        address: [
          { required: true, message: "酒店地址不能为空", trigger: "blur" }
        ],
        addressEn: [
          { required: true, message: "酒店英文地址不能为空", trigger: "blur" }
        ],
        creator: [
          { required: true, message: "创建人不能为空", trigger: "blur" }
        ],
        modifier: [
          { required: true, message: "修改人不能为空", trigger: "blur" }
        ],
        modifyTime: [
          { required: true, message: "修改时间不能为空", trigger: "blur" }
        ],
        gaodeLat: [
          { required: true, message: "高德经度不能为空", trigger: "blur" }
        ],
        gaodeLon: [
          { required: true, message: "高德维度不能为空", trigger: "blur" }
        ],
        googleLat: [
          { required: true, message: "谷歌维度不能为空", trigger: "blur" }
        ],
        googleLon: [
          { required: true, message: "谷歌经度不能为空", trigger: "blur" }
        ],
        baiduLat: [
          { required: true, message: "百度维度不能为空", trigger: "blur" }
        ],
        baiduLon: [
          { required: true, message: "百度经度不能为空", trigger: "blur" }
        ],
        destinationLable: [
          { required: true, message: "目的地标签不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询酒店详情列列表 */
    getList() {
      this.loading = true;
      listHotel(this.queryParams).then(response => {
        this.hotelList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        hotelId: undefined,
        hotelName: undefined,
        hotelNameEn: undefined,
        cityName: undefined,
        star: undefined,
        hotelPhone: undefined,
        openingTime: undefined,
        decorateTime: undefined,
        introduction: undefined,
        canclePolicy: undefined,
        creditCards: undefined,
        facilities: undefined,
        address: undefined,
        addressEn: undefined,
        creator: undefined,
        createTime: undefined,
        modifier: undefined,
        modifyTime: undefined,
        gaodeLat: undefined,
        gaodeLon: undefined,
        googleLat: undefined,
        googleLon: undefined,
        baiduLat: undefined,
        baiduLon: undefined,
        destinationLable: undefined
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.hotelId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加酒店详情列";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.loading = true;
      this.reset();
      const hotelId = row.hotelId || this.ids
      getHotel(hotelId).then(response => {
        this.loading = false;
        this.form = response.data;
        this.open = true;
        this.title = "修改酒店详情列";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.buttonLoading = true;
          if (this.form.hotelId != null) {
            updateHotel(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          } else {
            addHotel(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            }).finally(() => {
              this.buttonLoading = false;
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const hotelIds = row.hotelId || this.ids;
      this.$modal.confirm('是否确认删除酒店详情列编号为"' + hotelIds + '"的数据项？').then(() => {
        this.loading = true;
        return delHotel(hotelIds);
      }).then(() => {
        this.loading = false;
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      }).finally(() => {
        this.loading = false;
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hmis/hotel/export', {
        ...this.queryParams
      }, `hotel_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
