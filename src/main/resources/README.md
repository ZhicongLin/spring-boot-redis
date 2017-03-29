# Redis配置

1.application.properties的配置

    spring.redis.host=1.1.20.24
    spring.redis.port=6379
    spring.redis.password=123456

2.Linux上Redis服务的配置，如果没有修改配置，远程连接会抱错

    修改redis配置文件/etc/redis/6379.conf
    Redis 在非本机访问redis要修改配置文件才行， 
    比如我的是vim /etc/redis/6379.conf。 
    protected-mode no(关闭保护模式) 
    #bind 127.0.0.1(注释掉绑定) 
    requirepass 666666(设置密码) 
    
3.如果Redis有密码，那么重启redis服务的时候会出现下面的问题

    Waiting for Redis to shutdown ...  
    Waiting for Redis to shutdown ...  
    Waiting for Redis to shutdown ...  
    Waiting for Redis to shutdown ...  
    Waiting for Redis to shutdown ...  
    
  解决这个问题，需要修改服务的注册文件
  
    vim /etc/rc.d/init.d/redis (修改这个文件相关的配置，如下)
    在shutdown前面添加 -a password（密码）
    
    stop)
        if [ ! -f $PIDFILE ]
            then
                echo "$PIDFILE does not exist, process is not running"
            else
                PID=$(cat $PIDFILE)
            echo "Stopping ..."
            $CLIEXEC -p $REDISPORT -a 666666 shutdown
            while [ -x /proc/${PID} ]
            do
                echo "Waiting for Redis to shutdown ..."
            sleep 1
            done
            echo "Redis stopped"
        fi
    ;;
    *)
    
    