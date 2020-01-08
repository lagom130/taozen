package com.kuro.taozen.service;

import com.kuro.taozen.repository.TicketRepository;
import org.springframework.stereotype.Service;

/**
 * 工单实现层
 *
 * @author kuro
 * @create 2019-12-03
 **/
@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
}
