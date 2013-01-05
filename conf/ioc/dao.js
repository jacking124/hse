var ioc = {
		dao : {
                type : "org.nutz.dao.impl.NutDao",
                args : [{refer:"dataSource"}]
        },
        dataSource : {
                type : "com.alibaba.druid.pool.DruidDataSource",
                events : {
                	depose : "close"
                },
                fields : {
                	driverClassName : 'oracle.jdbc.driver.OracleDriver',
        			url             : 'jdbc:oracle:thin:@10.79.139.5:1521:tdmis',
        			username        : 'hsedb',
        			password        : 'hsedb',
        			filters : "stat"
                }
        }
};