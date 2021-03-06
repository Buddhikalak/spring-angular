package com.citypak.sandbox.daoimpl;

import com.citypak.sandbox.dao.regionDao;
import com.citypak.sandbox.model.region;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class RegionDaoImpl implements regionDao {

    private JdbcTemplate jdbcTemplate;

    public RegionDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void delete(int id) {
        String sql = "DELETE FROM region WHERE idregion = ?";
        jdbcTemplate.update(sql, id);

    }

    public region getdetails(String name) {
        String sql = "SELECT * FROM region WHERE name = '" + name + "' ";
region r = new region();
        System.out.println(sql);
        jdbcTemplate.query(sql, new ResultSetExtractor<region>() {

            public region extractData(ResultSet rs) throws SQLException, DataAccessException {
                
                if (rs.next()) {

                    r.setId(rs.getInt(1));
                    r.setName(rs.getString(2));
                    System.out.println("Region return id="+rs.getInt(1)+" & Name :"+rs.getString(2));
                    return r;
                   

                }

                return r;
            }

        });
        return r;
    }

    public List<region> list(HashMap<String, String> params) {
        String sql = "SELECT * FROM region";

        List<region> listActions = jdbcTemplate.query(sql, new RowMapper<region>() {

            @Override
            public region mapRow(ResultSet rs, int rowNum) throws SQLException {
                region r = new region();

                r.setId(rs.getInt(1));
                r.setName(rs.getString(2));

                return r;
            }

        });

        return listActions;
    }

    @Override
    public void saveOrUpdate(region region) {
        if (region.getId() > 0) {
            String sql = "UPDATE region SET  name = ? WHERE idregion = ? ";
            jdbcTemplate.update(sql, region.getName(), region.getId());
        } else {
            String sql = "INSERT INTO region ( name ) VALUES ( ? );";
            jdbcTemplate.update(sql, region.getName());
        }
    }

}
