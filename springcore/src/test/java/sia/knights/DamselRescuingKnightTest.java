package sia.knights;

import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class DamselRescuingKnightTest extends TestCase {

    @Test
    /**
     * 测试思路：
     * 测试embarkOnQuest能否成功调用，其实是测试内部quest的embark方法能否成功调用
     * 如果用变量或或者输出放到Quest里面，那么会影响到其他类的测试
     * 如果是在embarkOnQuest前后用一个变量值的改变（如count自增），那么只能保证方法运行过，却不能保证embark成功调用，而且更重要的是，
     * 这就和mockito, junit没什么关系了...
     */
    public void testEmbarkOnQuest() {
        DamselRescuingKnight mockedDamselRescuingKnight = Mockito.mock(DamselRescuingKnight.class);
        System.out.println(mockedDamselRescuingKnight.getCount());//0
        mockedDamselRescuingKnight.embarkOnQuest();
        System.out.println(mockedDamselRescuingKnight.getCount());//0.mock出来的对象，并没有真正执行方法

        DamselRescuingKnight damselRescuingKnight = new DamselRescuingKnight();
        System.out.println(damselRescuingKnight.getCount());
        damselRescuingKnight.embarkOnQuest();
        System.out.println(damselRescuingKnight.getCount());
    }
}