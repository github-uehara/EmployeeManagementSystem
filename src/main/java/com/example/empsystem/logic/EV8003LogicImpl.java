package com.example.empsystem.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
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
		List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

		List<PositionDO> positionList = new ArrayList<PositionDO>();
		for (Map<String, Object> result : results) {
			positionList.add(new PositionDO(result));
		}

		return positionList;
	}

	/**
	 * 役職マスタ情報をセッション用のモデルに変換する
	 * 
	 * @param results
	 * @return
	 */
	@Override
	public List<PositionList> converPositionList(List<PositionDO> results) {
		List<PositionList> lists = new ArrayList<PositionList>();

		for (PositionDO result : results) {
			lists.add(new PositionList(result));
		}

		return lists;
	}

}
