## Shiro 权限管理

核心解决功能

管理员的角度，


AuthenticationException 异常是Shiro在登录认证过程中，认证失败需要抛出的异常。

AuthenticationException包含以下子类：
    CredentitalsException 凭证异常
    IncorrentCredentialsException 不正确的凭证
    ExpiredCredentialsException 凭证过期

AccountException 账号异常
    ConcurrentAccessException 并发访问异常（多个用户同时登录时抛出）
    UnknownAccountException 未知的账号
    ExcessiveAttemptsException 认证次数超过限制
    DisabledAccountException 禁用的账号
        LockedAccountException 账号被锁定
        
UnsupportedTokenException 使用了不支持的Token