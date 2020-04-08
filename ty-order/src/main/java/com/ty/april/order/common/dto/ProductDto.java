package com.ty.april.order.common.dto;

import com.ty.april.tool.page.PageParam;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductDto extends PageParam {
     @NotBlank(message = "id不能为空")
     private String id;
}
