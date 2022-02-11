package com.example.controller;

import com.example.entities.Ticket;
import com.example.service.TicketBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value="/api/tickets")
@RequiredArgsConstructor
public class TicketBookingController {


    private  final TicketBookingService ticketBookingService;

    @GetMapping(value="/ticket/{ticketId}")
    public Ticket getTicketById(@PathVariable("ticketId")Integer ticketId){
        long start=System.currentTimeMillis();
        Ticket ticket=ticketBookingService.getTicketById(ticketId);
        long end=System.currentTimeMillis();
        System.out.println("Time evicted: "+(end-start));
        return ticket;

    }

    @DeleteMapping(value="/ticket/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId")Integer ticketId){
        ticketBookingService.deleteTicket(ticketId);
    }

    @PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
    public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId, @PathVariable("newEmail")String newEmail){
        return ticketBookingService.updateTicket(ticketId,newEmail);
    }
}
