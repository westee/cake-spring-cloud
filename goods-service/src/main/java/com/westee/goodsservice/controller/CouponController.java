package com.westee.goodsservice.controller;

import com.westee.common.entity.PageResponse;
import com.westee.common.entity.Response;
import com.westee.common.exception.HttpException;
import com.westee.goodsservice.generate.Coupon;
import com.westee.goodsservice.service.CouponService;
import com.westee.goodsservice.validator.CouponValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1")
public class CouponController {
    private final CouponService couponService;
    private final RestTemplate restTemplate;

    @Autowired
    public CouponController(CouponService couponService, RestTemplate restTemplate) {
        this.couponService = couponService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("coupon")
    public PageResponse<Coupon> getCouponHistory(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                 @RequestHeader("Token") String token) {
        Long tokenUserId = getUserId(token);
        return couponService.getCouponList(pageNum, pageSize);
    }

    @PostMapping("coupon")
    public Response<Coupon> createCoupon(@Valid @RequestBody Coupon coupon,
                                         @RequestHeader("Token") String token) {
        if (CouponValidator.validateCouponParameters(coupon)) {
            Long userId = getUserId(token);
            return Response.ok(couponService.insertCoupon(coupon));
        }
        throw HttpException.badRequest("金额不合法");
    }

    @GetMapping("coupon/send")
    public Response<String> distributeCoupon(@RequestParam long couponId,
                                             @RequestHeader("Token") String token) {
        Long tokenUserId = getUserId(token);
        couponService.insertUserCoupon(couponId);
        return Response.ok("");
    }

    @GetMapping("coupon/user")
    public Response<ArrayList<Coupon>> getUserCoupons(@RequestParam(defaultValue = "", required = false) String status,
                                                      @RequestHeader("Token") String token) {
        Long tokenUserId = getUserId(token);
        ArrayList<Coupon> userCouponList = couponService.getUserCouponList(tokenUserId, status);
        return Response.ok(userCouponList);
    }

    @GetMapping("coupon/user/count")
    public Response<Long> getUserCouponCount(@RequestHeader("Token") String token) {
        Long tokenUserId = getUserId(token);
        return Response.ok(couponService.countUserCoupon(tokenUserId));
    }

    public Long getUserId(String token) {
        restTemplate.exchange("1L", HttpMethod.GET, null, Long.class);
        return null;
    }

}
