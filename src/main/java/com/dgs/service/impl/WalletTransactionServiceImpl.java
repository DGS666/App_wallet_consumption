package com.dgs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dgs.entity.WalletTransaction;
import com.dgs.mapper.WalletTransactionMapper;
import com.dgs.service.WalletTransactionService;
import org.springframework.stereotype.Service;

@Service
public class WalletTransactionServiceImpl extends ServiceImpl<WalletTransactionMapper, WalletTransaction> implements WalletTransactionService {
}
