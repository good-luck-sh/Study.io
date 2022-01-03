package com.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Location;

@Mapper
public interface LocationDao {

	List<Location> getAllLocations();
}
