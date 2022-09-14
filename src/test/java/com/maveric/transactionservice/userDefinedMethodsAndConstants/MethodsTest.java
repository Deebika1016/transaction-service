package com.maveric.transactionservice.userDefinedMethodsAndConstants;
import com.maveric.transactionservice.dto.TransactionDto;
import com.maveric.transactionservice.model.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;
import static com.maveric.transactionservice.userDefinedMethodsAndConstants.Type.CREDIT;
@ExtendWith(MockitoExtension.class)
 class MethodsTest {
    @Mock
    private Methods methods;

    @Test
    void ShouldReturnTransactionDtoWhenDtoMethodInvoked(){
        assertEquals(CREDIT,Methods.dto(new Transaction("1","12",CREDIT,233,"23")).getType());
    }
    @Test
    void ShouldReturnTransactionWhenToModelMethodInvoked(){
        assertEquals(CREDIT,Methods.toModel(new TransactionDto("1","12",CREDIT,233,"12")).getType());
    }
    @Test
    void ShouldReturnLocalTimeWhenGetTimeMethodInvoked() {

        assertEquals(LocalDateTime.now(), Methods.getCurrentDateTime());
    }
}
