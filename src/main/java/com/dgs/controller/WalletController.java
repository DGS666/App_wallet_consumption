package com.dgs.controller;

import com.dgs.entity.WalletTransaction;
import com.dgs.service.impl.WalletImpl;
//import com.dgs.service.impl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Resource
    private WalletImpl walletimpl;

    /**
     *
     * @param userId 用户id
     * @return
     */
//    查询用户钱包余额
    @GetMapping("/balance/{userId}")
    public BigDecimal getWalletBalance(@PathVariable Long userId) {
        return walletimpl.getWalletBalance(userId);
    }

    /**
     *
     * @param userId 用户id
     * @param amount 消费额度
     * @return
     */
//    用户消费100元的接口
    @PostMapping("/consume/{userId}")
    public ResponseEntity<String> consume(@PathVariable Long userId, @RequestParam(defaultValue = "100.0") Double amount) {
        if (walletimpl.consume(userId, new BigDecimal(amount))) {
            return ResponseEntity.ok("Successfully consumed " + amount + " from the wallet.");
        } else {
            return ResponseEntity.badRequest().body("Insufficient balance in the wallet.");
        }
    }

//    用户退款20元接口

    /**
     *
     * @param userId 用户id
     * @param amount 退款额度
     * @return
     */
    @PostMapping("/refund/{userId}")
    public ResponseEntity<String> refund(@PathVariable Long userId, @RequestParam(defaultValue = "20.0") Double amount) {
        walletimpl.refund(userId, new BigDecimal(amount));
        return ResponseEntity.ok("Successfully refunded " + amount + " to the wallet.");
    }

    /**
     *
     * @param userId 用户id
     * @return
     */
//    查询用户钱包金额变动明细的接口
    @GetMapping("/transactions/{userId}")
    public List<WalletTransaction> getWalletTransactions(@PathVariable Long userId) {
        List<WalletTransaction> out = walletimpl.getWalletTransactions(userId);
        return out;
    }
}