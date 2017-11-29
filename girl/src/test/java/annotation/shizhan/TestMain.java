package annotation.shizhan;


/**
 * https://www.cnblogs.com/gqzmy/p/6846488.html
 */
import org.junit.Test;

public class TestMain {

    @Test
    public void test() throws Exception {
        ValidateService validateService = new ValidateService();
        StringBuffer stringBuffer = new StringBuffer();

        SeeBillAbandoRequset requset = new SeeBillAbandoRequset();
        SeeBillHead head = new SeeBillHead();
        head.setUserCode(null);
        head.setPassWord("123123123");
        
        SeeBillMain main = new SeeBillMain();
        main.setErrorInfo("errorInfo");
        main.setResultCode("resultCode");
        main.setSerialNumber("serialNumber");
        main.setTransDate("2017-05-12 16:38:54");
        main.setTransNo("transNo");
        main.setTransPortNum("transPortNum");
        
        SeeBillAbandonBase base = new SeeBillAbandonBase();
        base.setPolicyNo("policyNo");
        base.setReason("reason");
        
        requset.setHead(head);
        requset.setMain(main);
        requset.setBase(base);
        
        validateService.validateSeeRequest(requset,stringBuffer);
        System.out.println(stringBuffer);
    }
}