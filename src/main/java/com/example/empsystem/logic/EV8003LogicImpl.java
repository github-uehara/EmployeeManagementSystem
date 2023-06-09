package com.example.empsystem.logic;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.empsystem.logic.Interface.EV8003Logic;
import com.example.empsystem.model.PositionList;
import com.example.empsystem.model.DO.PositionDO;

/**
 * EV8003Logicを実装するクラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
public class EV8003LogicImpl implements EV8003Logic {

	private final JdbcTemplate jdbcTemplate;
	private ModelMapper modelMapper = new ModelMapper();

	public EV8003LogicImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 役職マスタ情報全件取得
	 * 
	 * @return
	 */
	@Override
	public List<PositionDO> findAll() {
		String sql = "SELECT * FROM m_position";

		RowMapper<PositionDO> rowMapper = new BeanPropertyRowMapper<PositionDO>(PositionDO.class);
		List<PositionDO> results = jdbcTemplate.query(sql, rowMapper);

		return results;
	}

	/**
	 * 役職マスタ情報をセッション用のモデルにBeanマッピングする
	 * 
	 * @param results
	 * @return
	 */
	@Override
	public List<PositionList> converPositionList(List<PositionDO> results) {
		List<PositionList> lists = new ArrayList<PositionList>();

		for (PositionDO result : results) {
			lists.add(modelMapper.map(result, PositionList.class));
		}

		return lists;
	}

}
