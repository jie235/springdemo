package sia.knights;

import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class BraveKnightTest extends TestCase {

    @Test
    /**
     * 测试思路：
     * 测试BraveKnight类中的emBarkOnQuest方法，其实是测试内部的Quest对象的方法是否能成功使用
     * 因此要验证的是Quest
     * 那么用一个BraveKnight对象来调用BraveKnight的emBarkOnQuest方法，通过验证Quest是否成功调用来判断
     */
    public void testEmbarkOnQuest() {
        Quest mockedQuest = Mockito.mock(Quest.class);
        BraveKnight braveKnight = new BraveKnight(mockedQuest);
        braveKnight.embarkOnQuest();
        Mockito.verify(mockedQuest, Mockito.times(1)).embark();
    }
}