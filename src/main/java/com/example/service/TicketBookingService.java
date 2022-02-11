package com.example.service;

import com.example.dao.TicketBookingDao;
import com.example.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingDao ticketBookingDao;

    @Cacheable(value="ticketsCache",key="#ticketId",unless = "#result==null")
    public Ticket getTicketById(Integer ticketId) {
        return ticketBookingDao.findById(ticketId).get();
    }

    @CacheEvict(value="ticketsCache",key="#ticketId")
    public void deleteTicket(Integer ticketId) {
        ticketBookingDao.deleteById(ticketId);
    }

    @CachePut(value="ticketsCache",key="#ticketId")
    public Ticket updateTicket(Integer ticketId, String newEmail) {
        Ticket ticketFromDb = ticketBookingDao.findById(ticketId).get();
        ticketFromDb.setEmail(newEmail);
        Ticket upadedTicket = ticketBookingDao.save(ticketFromDb);
        return upadedTicket;
    }
}
