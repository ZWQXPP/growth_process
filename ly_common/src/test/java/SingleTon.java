/**
 * @program: leyou_99
 * @description:
 **/
public class SingleTon {

    //提交私有构造
    private SingleTon(){

    }

    private static final SingleTon single = new SingleTon();


    public static SingleTon getInstance(){
        return single;
    }

}
