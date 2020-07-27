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
 * 角色资源映射表
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
@ApiModel(value="UmsRoleResource对象", description="角色资源映射表")
public class UmsRoleResource implements Serializable {


    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    @ApiModelProperty(value = "资源id")
    private Integer resourceId;

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
