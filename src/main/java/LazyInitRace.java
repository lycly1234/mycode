import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {
    //延迟初始化
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }

    /*
     * 注意这个 instance==null这个判断条件，可能会存在并发的情况，ab线程都达到这个竞态条件
     * instance被初始化了两次
     * 可能getInstance拿到的地址就不一致
     */

}
