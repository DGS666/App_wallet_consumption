package com.dgs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dgs.entity.Wallet;
import com.dgs.mapper.WalletMapper;
import com.dgs.service.WalletService;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet> implements WalletService {

}
