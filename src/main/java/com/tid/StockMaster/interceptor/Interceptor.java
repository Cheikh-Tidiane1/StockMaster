package com.tid.StockMaster.interceptor;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
@Configuration
public class Interceptor implements StatementInspector {

    @Override
    public String inspect(String sql) {
        if(StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
            if(sql.contains("where")){
                sql = sql + " and idEntreprise = 1";
            }else{
                sql = sql + " where idEntreprise = 1";
            }
        }
        return sql;
    }
}
