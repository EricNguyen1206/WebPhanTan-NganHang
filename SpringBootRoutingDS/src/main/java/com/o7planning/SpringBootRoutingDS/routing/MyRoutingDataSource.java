package com.o7planning.SpringBootRoutingDS.routing;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//22 MyRoutingDataSource là một DataSource, nó chứa một bản đồ (Map) giữa các khóa và các Datasource thực sự.
public class MyRoutingDataSource extends AbstractRoutingDataSource {

   @Override
   protected Object determineCurrentLookupKey() {

      HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
      // Xem thêm: DataSourceInterceptor
      String keyDS = (String) request.getAttribute("keyDS");
      System.out.println("KeyDS=" + keyDS);

      if (keyDS == null) keyDS = "BENTHANH_DS";

      return keyDS;
   }

   public void initDataSources(DataSource dataSource1, DataSource dataSource2) {
      Map<Object, Object> dsMap = new HashMap<Object, Object>();

      dsMap.put("BENTHANH_DS", dataSource1);
      dsMap.put("TANDINH_DS", dataSource2);

      this.setTargetDataSources(dsMap);
   }

}