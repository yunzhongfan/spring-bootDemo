package annotation.shizhan;

public class RuleReturn {
	 public final static RuleReturn SUCCESS;
	    public final static RuleReturn SUCCESS_BREAK;

	    public final static String BREAK = "break";
	    public final static String CONTINUE = "continue";

	    private boolean flag;

	    private String type = "";

	    private String errorMsg;

	    static {
	        SUCCESS = new RuleReturn();
	        SUCCESS.setFlag(true);
	        SUCCESS.setType(CONTINUE);

	        SUCCESS_BREAK = new RuleReturn();
	        SUCCESS_BREAK.setFlag(true);
	        SUCCESS_BREAK.setType(BREAK);
	    }

	    public RuleReturn() {
	        super();
	    }

	    public RuleReturn(String type, String errorMsg) {
	        this.flag = false;
	        this.type = type;
	        this.errorMsg = errorMsg;
	    }

	    public String getErrorMsg() {
	        return errorMsg;
	    }

	    public void setErrorMsg(String errorMsg) {
	        this.errorMsg = errorMsg;
	    }

	    public boolean isFlag() {
	        return flag;
	    }

	    public void setFlag(boolean flag) {
	        this.flag = flag;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	}
