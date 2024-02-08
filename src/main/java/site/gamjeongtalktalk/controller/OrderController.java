package site.gamjeongtalktalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.gamjeongtalktalk.domain.Member;
import site.gamjeongtalktalk.domain.Order;
import site.gamjeongtalktalk.domain.item.Item;
import site.gamjeongtalktalk.repository.MemberRepository;
import site.gamjeongtalktalk.repository.OrderSearch;
import site.gamjeongtalktalk.service.ItemService;
import site.gamjeongtalktalk.service.MemberService;
import site.gamjeongtalktalk.service.OrderService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model) {

        List<Member> members = memberRepository.findAll();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count) {

        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);

        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
