springsession {
    maxInactiveInterval = 1800
    redis {
        connectionFactory {
            hostName = "localhost"
            port = 6379
            timeout = 2000
            usePool = true
            dbIndex = 0
            convertPipelineAndTxResults = true
        }
        poolConfig {
            maxTotal = 8
            maxIdle = 8
            minIdle = 0
        }
        sentinel {
            master = "mymaster"
            nodes = [[host: '127.0.0.1', port: 26379]]
            password = ''
            timeout = 2000
        }
    }
    strategy {
        defaultStrategy = "COOKIE"
        cookie.name = "SESSION"
        httpHeader.headerName = "x-auth-token"
    }
}
