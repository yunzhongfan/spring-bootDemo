package annotation.shizhan;

public class SeeBillAbandonBase {
    @ValidateRules(value = { @ValidateRule(ruleName = "notBlank", params = "", errorMsg = "保单号不能为空！") })
    private String policyNo;

    @ValidateRules(value = { @ValidateRule(ruleName = "notBlank", params = "", errorMsg = "退保原因不能为空！") })
    private String reason;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}