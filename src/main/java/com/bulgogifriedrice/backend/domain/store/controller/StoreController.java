package com.bulgogifriedrice.backend.domain.store.controller;

import com.bulgogifriedrice.backend.domain.store.dto.StoreGetDto;
import com.bulgogifriedrice.backend.domain.store.dto.StoreRegisterDto;
import com.bulgogifriedrice.backend.domain.store.service.StoreService;
import com.bulgogifriedrice.backend.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;
    private final AuthenticationFacade authenticationFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerStore(@Valid @RequestBody StoreRegisterDto.Request request) {
        storeService.registerStore(request, authenticationFacade.getUserEmail());
    }

    @GetMapping
    public List<StoreGetDto.Response> getStore() {
        return storeService.getStore();
    }

}
