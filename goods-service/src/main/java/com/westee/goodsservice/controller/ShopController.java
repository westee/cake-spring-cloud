package com.westee.goodsservice.controller;

import com.westee.common.entity.PageResponse;
import com.westee.common.entity.Response;
import com.westee.common.entity.ResponseMessage;
import com.westee.goodsservice.generate.Shop;
import com.westee.goodsservice.service.ShopService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shop")
    public PageResponse<Shop> getShop(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return shopService.getShopsByUserId(pageNum, pageSize);
    }

    @GetMapping("/shop/{shopId}")
    public Response<Shop> getShopByShopId(@PathVariable(name = "shopId", required = false) long shopId) {
        return Response.of(ResponseMessage.OK.toString(), shopService.getShopByShopId(shopId));
    }

    @PostMapping("/shop")
    public Response<Shop> createShop(@RequestBody Shop shop, HttpServletResponse response) {
        Response<Shop> ret = Response.of(ResponseMessage.OK.toString(), shopService.createShop(shop));
        response.setStatus(HttpStatus.CREATED.value());
        return ret;
    }

    @PatchMapping("/shop/{id}")
    public Response<Shop> updateShop(@PathVariable("id") Long id,
                                     @RequestBody Shop shop) {
        shop.setId(id);
        return Response.of(ResponseMessage.OK.toString(),shopService.updateShop(shop));
    }

    @DeleteMapping("/shop/{id}")
    public Response<Shop> deleteShop(@PathVariable("id") Long shopId) {
        return Response.of(ResponseMessage.OK.toString(), shopService.deleteShop(shopId));
    }

}
