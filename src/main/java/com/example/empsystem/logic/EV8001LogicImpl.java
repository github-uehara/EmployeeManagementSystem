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

	/**
	 * コンストラクタ
	 * 
	 * @param jdbcTemplate
	 */
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

		// BeanPropertyRowMapperの使用
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

	/**
	 * 社員情報更新
	 * 
	 * @param empInfo
	 * @return
	 */
	@Override
	public int update(EmployeeInfo empInfo) {
		String sql = "UPDATE employee "
				+ "SET affiliation_cd = ?, position_cd = ?, employee_nm = ?, gender = ?, birthday = ?, foreign_nationality = ?, base_salary = ?, memo = ?, update_user = ?, update_time = ? "
				+ "WHERE employee_id = ?;";

		int result = jdbcTemplate.update(sql, empInfo.getAffiliationCd(), empInfo.getPositionCd(),
				empInfo.getEmployeeNm(), empInfo.getGender(), empInfo.getBirthday(), empInfo.getForeignNationality(),
				empInfo.getBaseSalary(), empInfo.getMemo(), USER, new Date(), empInfo.getEmployeeId());

		return result;
	}

	/**
	 * 社員情報削除
	 * 
	 * @param employeeId
	 * @return
	 */
	@Override
	public int delete(String employeeId) {
		String sql = "DELETE FROM employee WHERE employee_id = ?";
		int result = jdbcTemplate.update(sql, employeeId);

		return result;
	}
}
