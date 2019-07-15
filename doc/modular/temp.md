Shiro的常用注解以及jsp中Shiro使用的标签

@RequiresPermissions ：要求当前Subject在执行被注解的方法时具备一个或多个对应的权限。
@RequiresRoles ：要求当前Subject在执行被注解的方法时具备所有的角色，否则将抛出AuthorizationException异常。
@RequiresAuthentication：要求在访问或调用被注解的类/实例/方法时，Subject在当前的session中已经被验证。


Shiro使用的标签

guest标签
　　<shiro:guest>
　　</shiro:guest>
　　用户没有身份验证时显示相应信息，即游客访问信息。

user标签
　　<shiro:user>　　
　　</shiro:user>
　　用户已经身份验证/记住我登录后显示相应的信息。

authenticated标签
　　<shiro:authenticated>　　
　　</shiro:authenticated>
　　用户已经身份验证通过，即Subject.login登录成功，不是记住我登录的。

notAuthenticated标签
　　<shiro:notAuthenticated>
　　
　　</shiro:notAuthenticated>
　　用户已经身份验证通过，即没有调用Subject.login进行登录，包括记住我自动登录的也属于未进行身份验证。

principal标签
　　<shiro: principal/>
　　
　　<shiro:principal property="username"/>
　　相当于((User)Subject.getPrincipals()).getUsername()。

lacksPermission标签
　　<shiro:lacksPermission name="org:create">
　
　　</shiro:lacksPermission>
　　如果当前Subject没有权限将显示body体内容。

hasRole标签
　　<shiro:hasRole name="admin">　　
　　</shiro:hasRole>
　　如果当前Subject有角色将显示body体内容。

hasAnyRoles标签
　　<shiro:hasAnyRoles name="admin,user">
　　　
　　</shiro:hasAnyRoles>
　　如果当前Subject有任意一个角色（或的关系）将显示body体内容。

lacksRole标签
　　<shiro:lacksRole name="abc">　　
　　</shiro:lacksRole>
　　如果当前Subject没有角色将显示body体内容。

hasPermission标签
　　<shiro:hasPermission name="user:create">　　
　　</shiro:hasPermission>
　　如果当前Subject有权限将显示body体内容

