package com.example.Test;

import com.example.Test.Model.List;
import org.springframework.data.repository.CrudRepository;

public interface ListRepo extends CrudRepository<List,Long> {
}
