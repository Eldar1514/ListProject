package com.example.Test;

import com.example.Test.Model.Entry;
import org.springframework.data.repository.CrudRepository;

public interface ListRepo extends CrudRepository<Entry,Long> {


}
