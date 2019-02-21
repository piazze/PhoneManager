package com.hxzy.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hxzy.bean.Brand;
import com.hxzy.bean.Phone;
import com.hxzy.dao.PhoneDao;
import com.hxzy.util.DataSourceUtil;

public class PhoneDaoImpl implements PhoneDao {

	private DataSourceUtil util = DataSourceUtil.getInstance();
	
	@Override
	public int add(Phone t) {
		
		String sql = "insert into `phone` (p_name,brandId,price,cores,ram,rom,os,count,date)" + 
					" values (?,?,?,?,?,?,?,?,?)";
		Object[] params = {t.getpName(),t.getBrand().getBrandId(),t.getPrice(),t.getCores(),t.getRam(),t.getRom()
				,t.getOs(),t.getCount(),new Date()
		};
		return util.executeUpdate(sql, params);
	}

	@Override
	public int update(Phone t) {
		String sql = "update `phone` set p_name=?,brandId=?,price=?,cores=?,ram=?,rom=?,os=?,count=? " + 
				" where p_id=?";
		Object[] params = {t.getpName(),t.getBrand().getBrandId(),t.getPrice(),t.getCores(),t.getRam(),t.getRom()
				,t.getOs(),t.getCount(),t.getpId()
		};
		return util.executeUpdate(sql, params);
	}

	@Override
	public int remove(int id) {
		String sql = "delete from phone where p_id= ?";
		return util.executeUpdate(sql, id);
	}

	@Override
	public Phone queryOne(int id) {
		StringBuilder builder = new StringBuilder("select p_id pId, p_name pName,brandId,price,cores,ram,rom,os,count,date ");
		builder.append(" from phone where p_id=?");
		Map map = util.queryMap(builder.toString(), id).get(0);//因为根据主键查询，始终只能返回一条数据
		
		if (map.size() > 0) {
			Phone phone = new Phone( 
					(Integer)map.get("pId"),
					(String)map.get("pName"), 
					new Brand((Integer)map.get("brandId")), 
					(Double)map.get("price"), 
					(Integer)map.get("cores"), 
					(Integer)map.get("ram"), 
					(Integer)map.get("rom"), 
					(Integer)map.get("os"), 
					(Integer)map.get("count"), 
					(Date)map.get("date"));
			return phone;
		}
		return null;
	}

	@Override
	public List<Phone> queryAll() {
		StringBuilder builder = new StringBuilder("select t1.p_id pId, t1.p_name pName,t1.brandId,t2.brandName, t1.price,t1.cores,t1.ram,t1.rom,t1.os,t1.count,t1.date  ");
		builder.append(" from phone t1");
		builder.append(" inner join brands t2");
		builder.append(" on t1.brandId = t2.brandId");
		List<Map> listMap = util.queryMap(builder.toString());
		List<Phone> list = new ArrayList<>();
		listMap.parallelStream().forEach(t->{ //JDK8的stream流及lambda表达式组件对象
			Phone phone = new Phone( 
					(Integer)t.get("pId"),
					(String)t.get("pName"), 
					new Brand((Integer)t.get("brandId"),(String)t.get("brandName")), 
					(Double)t.get("price"), 
					(Integer)t.get("cores"), 
					(Integer)t.get("ram"), 
					(Integer)t.get("rom"), 
					(Integer)t.get("os"), 
					(Integer)t.get("count"), 
					(Date)t.get("date"));
			list.add(phone);
		});
		return list;
	}

}
