package com.dgs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dgs.entity.TransactionType;
import com.dgs.entity.Wallet;
import com.dgs.entity.WalletTransaction;
import com.dgs.mapper.WalletMapper;
import com.dgs.mapper.WalletTransactionMapper;
import com.dgs.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WalletImpl  {

//    private WalletService walletservice;
    @Autowired
    private WalletMapper walletMapper;

    @Autowired
    private WalletTransactionMapper walletTransactionMapper;

    public BigDecimal getWalletBalance(Long userId) {
        Wallet wallet = walletMapper.selectOne(new QueryWrapper<Wallet>().eq("user_id", userId));

//        LambdaQueryWrapper<Wallet> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Wallet::getUserId,userId);
//        Wallet wallet = walletservice.getOne(queryWrapper);
        return (wallet != null) ? wallet.getBalance() : new BigDecimal("0.0");
    }

//    @Transactional
    public boolean consume(Long userId, BigDecimal amount) {
        Wallet wallet = walletMapper.selectOne(new QueryWrapper<Wallet>().eq("user_id", userId));
//        LambdaQueryWrapper<Wallet> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Wallet::getUserId,userId);
//        Wallet wallet = walletservice.getOne(queryWrapper);
//        Wallet wallet = walletMapper.selectOne(new QueryWrapper<Wallet>().eq("user_id", userId));
        if (wallet != null) {
            BigDecimal balance = wallet.getBalance();

            if (balance.compareTo(amount)>=0) {
                BigDecimal newBalance = balance.subtract(amount);
                wallet.setBalance(newBalance);
                walletMapper.updateById(wallet);

                WalletTransaction transaction = new WalletTransaction();
                transaction.setUserId(userId);
                transaction.setAmount(amount.negate());
                transaction.setTransactionType(TransactionType.CONSUME);
                transaction.setTransactionTime(LocalDateTime.now());
                walletTransactionMapper.insert(transaction);

                return true;
            }
        }
        return false;
    }

//    @Transactional
    public void refund(Long userId, BigDecimal amount) {
        Wallet wallet = walletMapper.selectOne(new QueryWrapper<Wallet>().eq("user_id", userId));
//        LambdaQueryWrapper<Wallet> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Wallet::getUserId,userId);
//        Wallet wallet = walletservice.getOne(queryWrapper);
//        Wallet wallet = walletMapper.selectOne(new QueryWrapper<Wallet>().eq("user_id", userId));
        if (wallet != null) {
            BigDecimal balance = wallet.getBalance();

            BigDecimal newBalance = balance.add(amount);
            wallet.setBalance(newBalance);
            walletMapper.updateById(wallet);

            WalletTransaction transaction = new WalletTransaction();
            transaction.setUserId(userId);
            transaction.setAmount(amount);
            transaction.setTransactionType(TransactionType.REFUND);
            transaction.setTransactionTime(LocalDateTime.now());
            walletTransactionMapper.insert(transaction);
        }
    }

    public List<WalletTransaction> getWalletTransactions(Long userId) {
        return walletTransactionMapper.selectList(new QueryWrapper<WalletTransaction>().eq("user_id", userId));
    }

}
