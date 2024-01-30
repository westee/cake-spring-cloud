package com.westee.goodsservice.controller;

import com.westee.common.entity.PageResponse;
import com.westee.common.entity.Response;
import com.westee.common.entity.ResponseMessage;
import com.westee.common.exception.HttpException;
import com.westee.goodsservice.entity.GoodsWithImages;
import com.westee.goodsservice.generate.Goods;
import com.westee.goodsservice.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class GoodsController {
    private final GoodsService goodsService;
    RestTemplate restTemplate;

    @Autowired
    public GoodsController(GoodsService goodsService, RestTemplate RestTemplate) {
        this.goodsService = goodsService;
        this.restTemplate = RestTemplate;
    }

    @GetMapping("/goods")
    public PageResponse<GoodsWithImages> getShop(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                                 @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize,
                                                 @RequestParam(name = "status", defaultValue = "ok", required = false) String status,
                                                 @RequestParam(name = "shopId") Long shopId) {

        return goodsService.getGoodsByShopIdAndCategoryId(pageNum, pageSize, shopId, status);
    }

    @GetMapping("/goods-category")
    public Response<List<GoodsWithImages>> getGoodsByCategoryAndShop(
            @RequestParam(name = "shopId") Long shopId,
            @RequestParam(name = "categoryId") Long categoryId) {

        return Response.of(ResponseMessage.OK.toString() ,goodsService.getGoodsByShopIdAndCategoryId(shopId, categoryId)) ;
    }

    @GetMapping("/goods/{goodsId}")
    public Response<Goods> getShopByShopId(@PathVariable(name = "goodsId") long goodsId,
                                           @RequestHeader("Token") String token) {
        return Response.of(ResponseMessage.OK.toString(), goodsService.getGoodsByGoodsId(goodsId));
    }

    @PostMapping("/goods")
    public Response<Goods> createGoods(@RequestBody GoodsWithImages goods,
                                       @RequestHeader("Token") String token) {
        xx(token);
        return Response.of(ResponseMessage.OK.toString(), goodsService.createGoods(goods));
    }

    @DeleteMapping("/goods/{goodsId}")
    public Response<Goods> deleteGoods(@PathVariable Long goodsId,
                                       @RequestHeader("Token") String token) {
        xx(token);
        return Response.of(ResponseMessage.OK.toString(), goodsService.deleteGoods(goodsId));
    }

    @PatchMapping("/goods")
    public Response<GoodsWithImages> updateGoods(@RequestBody GoodsWithImages goods,
                                                 @RequestHeader("Token") String token) {
        xx(token);
        return Response.of(ResponseMessage.OK.toString(), goodsService.updateGoods(goods));
    }

    @GetMapping("/goods/search")
    public PageResponse<Goods> updateGoods(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                           @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize,
                                           @RequestParam String goodsName) {
        int start = (pageNum - 1) * pageSize;
        int count = goodsService.countGoodsByName(goodsName);
        int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        return PageResponse.pageData(pageNum,pageSize, totalPage, goodsService.getGoodsByName(start, pageSize, goodsName));
    }

    public void xx(String jwt) {
        Boolean userPermission = restTemplate.getForObject(
                "http://auth-service/validate-jwt-and-get-permissions", Boolean.class, jwt);
        if(Boolean.FALSE.equals(userPermission)) {
            throw HttpException.notAuthorized("没有权限");
        }
    }

}
