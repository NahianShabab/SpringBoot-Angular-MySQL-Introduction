package com.vinternship.task3.Repository;

import com.vinternship.task3.Model.BookShop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShopRepository extends CrudRepository<BookShop,Long> {

}
