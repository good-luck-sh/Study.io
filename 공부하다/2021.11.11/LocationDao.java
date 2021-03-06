package com.sample.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.vo.Location;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static com.sample.utils.ConnectionUtils.getConnection;

public class LocationDao {
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Location> getAllLocations() throws SQLException {
		String sql ="select location_id, street_address, postal_code, city, state_province, country_id "
					+"from locations "
					+ "order by city asc ";
		Connection connection = getConnection();
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		List<Location> locations = new ArrayList<>();
		while(rs.next()) {
			Location location = new Location();
			location.setId(rs.getInt("location_id"));
			location.setStreetAddress(rs.getString("street_address"));
			location.setStateProvince(rs.getString("state_province"));
			location.setPostalCode(rs.getString("postal_code"));
			location.setCountryId(rs.getString("country_id"));
			location.setCity(rs.getString("city"));
			locations.add(location);
			
		}
		rs.close();
		ptmt.close();
		connection.close();
		return locations;
	}
}
