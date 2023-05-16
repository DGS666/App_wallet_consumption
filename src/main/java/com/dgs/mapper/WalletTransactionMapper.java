package com.dgs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dgs.entity.WalletTransaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WalletTransactionMapper extends BaseMapper<WalletTransaction> {
}