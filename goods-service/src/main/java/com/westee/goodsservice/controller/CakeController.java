package com.westee.goodsservice.controller;

import com.westee.common.entity.PageResponse;
import com.westee.common.entity.Response;
import com.westee.goodsservice.entity.CakeWithTag;
import com.westee.goodsservice.generate.Cake;
import com.westee.goodsservice.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CakeController {

    private final CakeService cakeService;

    @Autowired
    public CakeController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping("cake")
    public PageResponse<CakeWithTag> getCakeList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                 @RequestParam(name = "categoryId", required = false) Integer categoryId,
                                                 @RequestParam(name = "name", required = false) String name) {
        if (categoryId != null) { // categoryId参数已传递
            return cakeService.getCakeByCakeTag(pageNum, pageSize, categoryId);
        }
        if (name != null) { // categoryId参数已传递
            return cakeService.getCakeByCakeName(pageNum, pageSize, name);
        } else {
            return cakeService.getCakeList(pageNum, pageSize);
        }
    }

    @PostMapping("cake")
    public Response<Cake> createCake(@RequestBody CakeWithTag cake) {
        return Response.ok(cakeService.insertCake(cake));
    }

    @PatchMapping("cake")
    public Response<Cake> patchCake(@RequestBody CakeWithTag cake) {
        return Response.ok(cakeService.updateCake(cake));
    }

    @DeleteMapping("cake")
    public Response<Cake> deleteCake(@RequestParam long cakeId) {
        return Response.ok(cakeService.deleteCakeByCakeId(cakeId));
    }

}
