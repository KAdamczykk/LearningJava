public class BrakPrzedmiotuException extends Exception{
    public BrakPrzedmiotuException(){}
    public BrakPrzedmiotuException(String msg){
        this.setMsg(msg);
        this.getMessage();
    }
    private String msg;

    @Override
    public String getMessage() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
