package com.joker.kuro.taoist.repository;

import com.joker.kuro.taoist.entity.TicketInfoEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 工单持久层
 *
 * @author kuro
 * @create 2019-12-03
 **/
@Repository
public interface TicketRepository extends ReactiveMongoRepository<TicketInfoEntity, String> {
}
