package com.westee.authservice.service;

import com.westee.authservice.generate.Menu;
import com.westee.authservice.generate.MenuExample;
import com.westee.authservice.generate.MenuMapper;
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
