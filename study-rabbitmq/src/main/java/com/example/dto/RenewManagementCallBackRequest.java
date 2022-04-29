package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author huangwj.
 * @date 2021/7/12
 */
@Data
public class RenewManagementCallBackRequest {
    /**
     * 投保单号
     */
    private String sendCode;
    /**
     * 代理人代码
     */
    private String agentCode;
    /**
     * 代理人手机号
     */
    private String agentTel;
    /**
     * 处理结果 Y-审核通过 N-审核不通过 Z-待回访暂通过, 若超过2日会返回Z(不可靠)
     */
    private String result;
    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;
    /**
     * 备注
     */
    private String remark;
}
