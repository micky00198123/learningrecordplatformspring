package com.fina.lrps.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
* @author MLPFIM
* @date 2019/11/21
*/
@Setter
@Getter
@ToString
public class NoticeVo {

    // 发件人学号
    @NotBlank(message = "发件人不能为空")
    @Size(max = 16, message = "发件人学号长度不能超过{max}")
    String studentId;

    // 收件人学号
    @NotEmpty(message = "收件人不能为空")
    String[] addressesId;

    // 正文
    @NotBlank(message = "正文不能为空")
    String content;

}
