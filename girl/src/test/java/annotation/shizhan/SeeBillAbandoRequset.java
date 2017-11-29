package annotation.shizhan;

public class SeeBillAbandoRequset {
    
    @Validate(errorMsg = "报文头不能为空")
    private SeeBillHead head;
    
    @Validate(errorMsg = "主节点不能为空")
    private SeeBillMain main;
    
    @Validate(errorMsg = "基本信息不能为空")
    private SeeBillAbandonBase base;

    public SeeBillHead getHead() {
        return head;
    }

    public void setHead(SeeBillHead head) {
        this.head = head;
    }

    public SeeBillMain getMain() {
        return main;
    }

    public void setMain(SeeBillMain main) {
        this.main = main;
    }

    public SeeBillAbandonBase getBase() {
        return base;
    }

    public void setBase(SeeBillAbandonBase base) {
        this.base = base;
    }

}
