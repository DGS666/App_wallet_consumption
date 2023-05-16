package com.dgs.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("wallet_transaction")
public class WalletTransaction implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;
    private TransactionType transactionType;
    private BigDecimal amount;
//    @TableField("")
    private LocalDateTime transactionTime;
}

