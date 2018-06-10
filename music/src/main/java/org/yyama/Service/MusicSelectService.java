package org.yyama.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.yyama.Form.SelectList;

@Service
public class MusicSelectService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> findMusicList() {
		
		String query;
		
		query = "select keyword.id, keyword.keyword, category.category ";
		query += "from keyword ";
		query += "inner join category ";
		query += "on keyword.categoryid = category.id ";
		query += "ORDER BY random() ";
		query += "LIMIT 10 ;";
		
		 List<Map<String,Object>> list = jdbcTemplate.queryForList(query);
		 
		 return list;
		
	}
	
	public List<Map<String, Object>> test(String selectList) {
		
		String query;
		
		query = "select keyword.id, keyword.keyword, category.category ";
		query += "from keyword ";
		query += "inner join category ";
		query += "on keyword.categoryid = category.id ";
		query += "ORDER BY random() ";
		query += "LIMIT ";
		query += selectList + ";";
		
		 List<Map<String,Object>> list = jdbcTemplate.queryForList(query);
		 
		 return list;
		
	}

}
