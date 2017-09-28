package com.citypak.sandbox.daoimpl;

import com.citypak.sandbox.model.banglore;
import com.citypak.sandbox.dao.bangloreDao;
import com.citypak.sandbox.model.response;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class BangloreDaoImpl implements bangloreDao {

    private JdbcTemplate jdbcTemplate;

    public BangloreDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(banglore banglore) {
        if (banglore.getIdbanglore() > 0) {
            String sql = "UPDATE banglore SET  name = ? , regionId = ? WHERE idbanglore =?";
            jdbcTemplate.update(sql, banglore.getBanglorename(), banglore.getRegionid(), banglore.getIdbanglore());
        } else {
            String sql = "INSERT INTO banglore ( name,regionId ) VALUES ( ? );";
            jdbcTemplate.update(sql, banglore.getBanglorename(), banglore.getRegionid());

        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM banglore WHERE idbanglore = ?";
        jdbcTemplate.update(sql, id);

    }

    public banglore get(int regionID) {

        String sql = "SELECT * FROM banglore WHERE idbanglore = '" + regionID + "'";

        jdbcTemplate.query(sql, new ResultSetExtractor<banglore>() {

            public banglore extractData(ResultSet rs)
                    throws SQLException, DataAccessException {
                if (rs.next()) {

                    banglore r = new banglore();
                    r.setIdbanglore(rs.getInt(1));
                    r.setBanglorename(rs.getString(2));
                    r.setRegionid(rs.getInt(3));

                    return r;
                }

                return null;
            }

        });
        return null;
    }

   public List<response> list(HashMap<String, String> params) {

        String sql = "SELECT banglore.idbanglore , banglore.name , region.name FROM banglore.region INNER JOIN banglore.banglore ON (region.idregion = banglore.regionId)";

        List<response> listActions = jdbcTemplate.query(sql, new RowMapper<response>() {

            @Override
            public response mapRow(ResultSet rs, int rowNum) throws SQLException {
                banglore Actionsl = new banglore();

                response r = new response();
                r.setIdbanglore(rs.getInt(1));
                r.setBanglorename(rs.getString(2));
                r.setRegionid(rs.getString(3));

                return r;
            }

        });

        return listActions;
    }

   
}
