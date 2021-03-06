package com.poly.datn.dao;

import com.poly.datn.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface SaleDAO extends JpaRepository<Sale, Integer> {

    @Query(nativeQuery = true,value = "select * from sale s where :currtime between s.start_time and s.end_time")
    List<Sale> findSalesAt(@Param("currtime") Timestamp time);
    @Query(nativeQuery = true,value = "select * from sale s where :currtime < s.start_time")
    List<Sale> findSalesAboutStart(@Param("currtime") Timestamp time);
    @Query(nativeQuery = true,value = "select * from sale s where :currtime > s.end_time")
    List<Sale> findSalesEnd(@Param("currtime") Timestamp time);
//    @Query(value = "")
//    Integer countAllByStartTime_DayAndStartTime_MonthAndEndTime_DayAndEndTime_Month(Integer StartTime_Day, Integer StartTime_Month, Integer EndTime_Day, Integer EndTime_Month);
}
