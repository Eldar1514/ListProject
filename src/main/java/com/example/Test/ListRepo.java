package com.example.Test;

import com.example.Test.Model.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListRepo extends CrudRepository<Entry,Long> {

    List<Entry> findByNameContainingOrSurnameContainingOrProfessionContaining
            (String nameKeyword, String surnameKeyword, String professionKeyword);

    @Query("SELECT e FROM Entry e WHERE CAST(e.age AS string) LIKE %?1%")
    List<Entry> findByAgeContaining(String age);

}
