package com.example.Test;

import com.example.Test.Model.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListRepo extends CrudRepository<Entry,Long> {
    List<Entry>findByNameContaining (String keyword);
}
