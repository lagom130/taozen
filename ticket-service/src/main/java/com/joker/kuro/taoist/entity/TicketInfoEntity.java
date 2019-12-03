package com.joker.kuro.taoist.entity;

import com.joker.kuro.taoist.consts.DBDocumentConstants;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static com.joker.kuro.taoist.consts.DBDocumentConstants.TICKET_INFO;

/**
 * 工单信息实体类
 *
 * @author kuro
 * @create 2019-12-03
 **/
@Document(collation = TICKET_INFO)
@Data
public class TicketInfoEntity {
    @Id
    private String id;

    /**
     * 工单编号
     */
    private String number;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 类型
     */
    private String type;

    /**
     * 优先级
     */
    private String priority;

    /**
     * 状态
     */
    private String status;

    /**
     * 客户邮箱
     */
    private String customerEmail;
    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 创建者ID
     * 游客创建为空
     */
    private String creatorId;

    /**
     * 创建者
     * 游客创建为空
     */
    private String creator;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 最后更新时间
     */
    private Long updateTime;

    /**
     * 处理记录
     */
    private List<TicketRecord> records;

    /**
     * 附件
     */
    private List<Annex> annexes;

    /**
     * 版本（乐观锁）
     */
    @Version
    private Long version;

}
