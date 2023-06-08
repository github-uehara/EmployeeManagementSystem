package com.example.empsystem.logic;

import java.util.Date;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.empsystem.logic.Interface.EV8001Logic;
import com.example.empsystem.model.EmployeeInfo;

/**
 * EV8001Logic実装クラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
public class EV8001LogicImpl implements EV8001Logic {

	private final String USER = "dcom";

	private final JdbcTemplate jdbcTemplate;

	public EV8001LogicImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 社員情報取得(PK)
	 * 
	 * @param employeeId
	 * @return
	 */
	@Override
	public EmployeeInfo findByPrimaryKey(String employeeId) {
		String sql = "SELECT * FROM employee WHERE employee_id = ?";
		RowMapper<EmployeeInfo> rowMapper = new BeanPropertyRowMapper<EmployeeInfo>(EmployeeInfo.class);

		EmployeeInfo empInfo = new EmployeeInfo();
		try {
			empInfo = jdbcTemplate.queryForObject(sql, rowMapper, employeeId);
		} catch (Exception ex) {
		}

		return empInfo;
	}

	/**
	 * 社員情報登録
	 * 
	 * @param empInfo
	 */
	@Override
	public void register(EmployeeInfo empInfo) {
		String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, empInfo.getEmployeeId(), empInfo.getAffiliationCd(), empInfo.getPositionCd(),
				empInfo.getEmployeeNm(), empInfo.getGender(), empInfo.getBirthday(), empInfo.getForeignNationality(),
				empInfo.getBaseSalary(), empInfo.getMemo(), USER, new Date(), USER, new Date());
	}

}
