package com.westee.loginservice.service;

import com.westee.loginservice.generate.Menu;
import com.westee.loginservice.generate.MenuExample;
import com.westee.loginservice.generate.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService  {

    private final MenuMapper mapper;

    @Autowired
    public MenuService(MenuMapper mapper) {
        this.mapper = mapper;
    }

    public List<Menu> getAllMenuByRoleId(){
        MenuExample menuExample = new MenuExample();
        return mapper.selectByExample(menuExample);
    }

}
