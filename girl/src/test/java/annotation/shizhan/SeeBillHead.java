package annotation.shizhan;

public class SeeBillHead {
    @ValidateRules(value = { @ValidateRule(ruleName = "notBlank", params = "", errorMsg = "用户名为空！") })
    private String userCode;// 用户名

    @ValidateRules(value = { @ValidateRule(ruleName = "notBlank", params = "", errorMsg = "密码为空！") })
    private String passWord;// 密码

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
