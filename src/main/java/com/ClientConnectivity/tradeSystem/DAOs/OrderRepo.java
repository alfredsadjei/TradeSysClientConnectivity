package com.ClientConnectivity.tradeSystem.DAOs;

import com.ClientConnectivity.tradeSystem.DTOs.Client;
import com.ClientConnectivity.tradeSystem.DTOs.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<ProductOrder,Long> {

    Optional<ProductOrder> findProductOrderByID(Long ID);

}
