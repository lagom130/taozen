package com.joker.kuro.taoist.entity;

import lombok.Data;

/**
 * 工单记录
 *
 * @author kuro
 * @create 2019-12-03
 **/
@Data
public class TicketRecord {
    /**
     * 操作人员ID
     */
    private String operatorId;
    /**
     * 操作人员
     */
    private String operator;
    /**
     * 操作类型
     */
    private String operateType;
    /**
     * 操作时间
     */
    private Long operateTime;
    /**
     * 备注
     */
    private String remark;
}
