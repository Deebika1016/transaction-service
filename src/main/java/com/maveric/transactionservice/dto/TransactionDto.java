package com.maveric.transactionservice.dto;

import com.maveric.transactionservice.userDefinedMethodsAndConstants.Type;
import lombok.*;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class TransactionDto {
    @Id
    private String _id;
    private String accountId;
    private Type type;
    private Number amount;
    private String createdAt;


}
