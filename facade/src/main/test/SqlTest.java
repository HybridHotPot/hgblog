import com.alibaba.fastjson.JSON;
import com.huoguo.bean.User;
import com.huoguo.dao.FollowMapper;
import com.huoguo.dao.UserMapper;
import com.huoguo.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SqlTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private FollowMapper followMapper;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void findArticleRecommend(){
        System.out.println(JSON.toJSON(articleService.findArticleRecommend(1)));
    }

    @Test
    public void top(){
//        Object o=articleService.findTopClicks();
//        Object oo=articleService.findTopNew();
//        Object ooo=articleService.findTopRecommend();
//        System.out.println(followMapper.getFollowNumber(1));
        User user=userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
