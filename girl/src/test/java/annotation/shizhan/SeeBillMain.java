package annotation.shizhan;

public class SeeBillMain {
    @ValidateRules(value = { @ValidateRule(ruleName = "notBlank", params = "", errorMsg = "交易码为空！") })
    private String transNo;// 交易码

    @ValidateRules(value = { @ValidateRule(ruleName = "notBlank", params = "", errorMsg = "交易流水号为空！") })
    private String serialNumber;// 交易流水号

    @ValidateRules(value = { @ValidateRule(ruleName = "notBlank", params = "", errorMsg = "交易时间为空！"),
            @ValidateRule(ruleName = "date_v", params = "yyyy-MM-dd HH:mm:ss", errorMsg = "交易时间格式错误") })
    private String transDate;// 交易时间

    private String transPortNum;

    private String resultCode;// 返回接口

    private String errorInfo;// 返回信息

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransPortNum() {
        return transPortNum;
    }

    public void setTransPortNum(String transPortNum) {
        this.transPortNum = transPortNum;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

}
