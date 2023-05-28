package com.vinternship.task2.BookShop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShopRepository extends CrudRepository<BookShop,Long> {
}
