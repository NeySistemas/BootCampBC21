package com.nttdata.customerservice.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "categoriesCustomer")
public class CategoryCustomer {
    private String id;
    private String name;
}
