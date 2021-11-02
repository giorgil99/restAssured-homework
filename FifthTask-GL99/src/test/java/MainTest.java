import Models.SuccessCase;
import Steps.LastCaseSteps;
import Steps.SuccessCaseSteps;
import Steps.UnSuccessFulCaseSteps;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class MainTest {


    @Test
    public  void successTest(){
        SuccessCaseSteps SuccessCase = new SuccessCaseSteps();
        SuccessCase.successCall()
                .successAssertId("4")
                .successAssertToken("QpwL5tke4Pnpja7X4");
    }



    @Test
    public void unsuccessfulTest(){
        UnSuccessFulCaseSteps failCase = new UnSuccessFulCaseSteps();
        failCase.unsuccessfulCall()
                .assertErrorMessage("Missing password");
    }



    @Test
    public void lastTest(){
        LastCaseSteps lastCase = new LastCaseSteps();
        lastCase.lastCall()
                .assertName("morpheus")
                .assertJob("leader")
                .assertId()
                .assertDate(ZonedDateTime.now().truncatedTo(ChronoUnit.MINUTES).minusHours(4));

    }




}
