package com.leyou.common.base;

import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * @Description TODO
 * @Author chenxudong
 * @Date 2019/9/19 20:24
 */
@Data
public class ClientVo extends BaseVo {

    @NotBlank
    private String branchId;
}
