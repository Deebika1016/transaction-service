package com.maveric.transactionservice.model;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.maveric.transactionservice.constants.Type;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Document(collection="Transaction")
public class Transaction {
    @JsonTypeId
    private String _id;
    private String accountId;
    private Type type;
    private Number amount;
    private String createdAt;
}
