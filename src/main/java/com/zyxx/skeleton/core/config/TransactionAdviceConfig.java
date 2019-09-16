package com.zyxx.skeleton.core.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局事物配置
 *
 * @author Tellsea
 * @date 2019/8/15
 * REQUIRED ：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
 * SUPPORTS ：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
 * MANDATORY ：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
 * REQUIRES_NEW ：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
 * NOT_SUPPORTED ：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
 * NEVER ：以非事务方式运行，如果当前存在事务，则抛出异常。
 * NESTED ：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于 REQUIRED 。
 * 指定方法：通过使用 propagation 属性设置，例如：@Transactional(propagation = Propagation.REQUIRED)
 * 参考文章；https://blog.csdn.net/schcilin/article/details/93306826
 */
@Aspect
@Configuration
public class TransactionAdviceConfig {

    /**
     * 配置方法过期时间，默认-1,永不超时
     */
    private final static int TX_METHOD_TIME_OUT = 10;

    /**
     * 配置切入点表达式,这里解释一下表达式的含义
     * 1.execution(): 表达式主体
     * 2.第一个*号:表示返回类型，*号表示所有的类型
     * 3.com.schcilin.goods.service表示切入点的包名
     * 4.第二个*号:表示实现包
     * 5.*(..)*号表示所有方法名,..表示所有类型的参数
     * com.zyxx.common.service.impl.UserInfoServiceImpl
     * com.zyxx.skeleton.necessary.service.impl.ShiroServiceImpl
     */
    private static final String POITCUT_EXPRESSION = "execution(* com.zyxx.*.*.service.*.*(..))";

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Bean
    public TransactionInterceptor txadvice() {
        /* 配置事务管理规则,声明具备管理事务方法名.这里使用public void addTransactionalMethod(String methodName, TransactionAttribute attr)*/
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        Map<String, TransactionAttribute> nameMap = new HashMap<>(16);
        /*只读事物、不做更新删除等*/
        /*事务管理规则*/
        RuleBasedTransactionAttribute readOnlyRule = new RuleBasedTransactionAttribute();
        /*设置当前事务是否为只读事务，true为只读*/
        readOnlyRule.setReadOnly(true);
        /* transactiondefinition 定义事务的隔离级别；
         *  PROPAGATION_REQUIRED 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中*/
        readOnlyRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        RuleBasedTransactionAttribute requireRule = new RuleBasedTransactionAttribute();
        /*抛出异常后执行切点回滚*/
        requireRule.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        /*PROPAGATION_REQUIRED:事务隔离性为1，若当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。 */
        requireRule.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        /*设置事务失效时间，超过10秒,可根据hytrix，则回滚事务*/
        requireRule.setTimeout(TX_METHOD_TIME_OUT);

        nameMap.put("add*", requireRule);
        nameMap.put("save*", requireRule);
        nameMap.put("insert*", requireRule);
        nameMap.put("update*", requireRule);
        nameMap.put("delete*", requireRule);
        nameMap.put("remove*", requireRule);
        /*进行批量操作时*/
        nameMap.put("batch*", requireRule);
        nameMap.put("get*", readOnlyRule);
        nameMap.put("query*", readOnlyRule);
        nameMap.put("find*", readOnlyRule);
        nameMap.put("select*", readOnlyRule);
        nameMap.put("count*", readOnlyRule);
        source.setNameMap(nameMap);
        return new TransactionInterceptor(platformTransactionManager, source);
    }

    /**
     * 设置切面=切点pointcut+通知TxAdvice
     *
     * @return
     */
    @Bean
    public Advisor txAdviceAdvisorByBusiness() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(POITCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txadvice());
    }
}
