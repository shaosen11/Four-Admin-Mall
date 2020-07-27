package com.edu.lingnan.fouradminmallboot.ums.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 管理员角色映射表
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@ApiModel(value="UmsAdminRole对象", description="管理员角色映射表")
public class UmsAdminRole implements Serializable {


    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long adminId;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    @TableLogic
    private Integer deleteId;

    @ApiModelProperty(value = "CAS乐观锁")
    @Version
    private Integer version;


}
