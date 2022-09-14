package com.maveric.transactionservice.model;
import com.maveric.transactionservice.userDefinedMethodsAndConstants.Type;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Document(collection="Transaction")
public class Transaction {
    @Id
    @NotEmpty
    private String _id;
    @NotEmpty(message = "AccountId should not be Null")
    private String accountId;
    private Type type;
    @NotEmpty(message = "Amount should be greater than zero")
    @Min(value =0)
    private Number amount;

    private String createdAt;


}
