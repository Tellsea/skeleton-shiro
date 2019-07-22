package cn.tellsea.skeleton.core.util;

import cn.tellsea.SkeletonApplicationTests;
import cn.tellsea.skeleton.business.entity.User;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class ShiroUtilsTest extends SkeletonApplicationTests {

    @Test
    public void test() {
        User currentUser = (User) ShiroUtils.getCurrentUser();
        ShiroUtils.clearCachedAuthenticationInfo((PrincipalCollection) currentUser);
        Subject subject = ShiroUtils.getSubject();
    }
}