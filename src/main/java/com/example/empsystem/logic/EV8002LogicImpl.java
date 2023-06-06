package com.example.empsystem.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.empsystem.logic.Interface.EV8002Logic;
import com.example.empsystem.model.DO.AffiliationDO;

/**
 * EV8002Logicを実装するクラス
 * 
 * @author DC-PCN1139
 *
 */
@Service
public class EV8002LogicImpl implements EV8002Logic {

	private final JdbcTemplate jdbcTemplate;

	public EV8002LogicImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<AffiliationDO> findAll() {
		String sql = "SELECT * FROM m_affiliation";
		List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

		List<AffiliationDO> affiliationList = new ArrayList<AffiliationDO>();
		for (Map<String, Object> result : results) {
			affiliationList.add(new AffiliationDO(result));
		}

		for (AffiliationDO affiliation : affiliationList) {
			String affiliationNm = (String) affiliation.getManagementNm();

			if (!(affiliation.getBrunchCd().equals("00"))) {
				affiliationNm += " - " + affiliation.getBrunchNm();
			}

			if (!(affiliation.getGroupCd().equals("00"))) {
				affiliationNm += " - " + affiliation.getGroupNm();
			}

			affiliation.setAffiliationNm(affiliationNm);
		}

		return affiliationList;
	}

}