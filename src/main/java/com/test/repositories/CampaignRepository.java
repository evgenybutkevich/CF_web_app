package com.test.repositories;

import com.test.entities.Campaign;
import org.springframework.data.repository.CrudRepository;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    Campaign findById(Integer id);

}
