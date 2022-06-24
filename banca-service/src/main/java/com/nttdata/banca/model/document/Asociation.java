package com.nttdata.banca.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "asociations")
public class Asociation {
    private String id;
    private String idCustomer;
    private String customer;
    private String category_customer;
    private String idProduct;
    private String product;
    private String category;
    private float amount;
}
