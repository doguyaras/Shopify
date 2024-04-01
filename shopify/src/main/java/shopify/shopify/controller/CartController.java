package shopify.shopify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shopify.shopify.entity.DTO.CartDTO;
import shopify.shopify.entity.DTO.CartRequest;
import shopify.shopify.entity.DTO.CartResponse;
import shopify.shopify.service.ICartService;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final ICartService iCartService;

    @PostMapping("/add")
    public void add(@RequestBody CartDTO cartDTO){
        this.iCartService.add(cartDTO);
    }

    @DeleteMapping("/remove")
    public void remove(@RequestBody CartDTO cartDTO){
        this.iCartService.remove(cartDTO);
    }

    @PostMapping("/cartResponse")
    public CartResponse getResponse(@RequestBody CartRequest cartRequest){
        return  this.iCartService.getResponse(cartRequest);
    }


}