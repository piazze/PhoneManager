package com.hxzy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.hxzy.bean.Brand;
import com.hxzy.dao.BrandDao;
import com.hxzy.util.DataSourceUtil;

public class BrandDaoImpl implements BrandDao{
	private DataSourceUtil util = DataSourceUtil.getInstance();

	@Override
	public int add(Brand t) {
		String sql = "insert into `brands` (`brandName`) values(?)";
		
		return util.executeUpdate(sql, t.getBrandName());
	}

	@Override
	public int update(Brand t) {
		String sql = "update `brands` set `brandName` = ? where `brandId` = ?";
		return util.executeUpdate(sql, t.getBrandName(),t.getBrandId());
	}

	@Override
	public int remove(int id) {
		String removePhone = "delete from `phone` where `brandId` = ?";
		String removeBrand = "delete from `brands` where `brandId` = ?";
		PreparedStatement pstmt = null;
		Connection conn = util.getConnection();
	        try {
	        	util.startTransaction();//开启事务
	            pstmt = conn.prepareStatement(removePhone);
	            //为sql语句的参数赋值
	            pstmt.setObject(1,id);
	            pstmt.executeUpdate(); //执行删除子表中的数据
	            util.closePstmt(pstmt);
	           
	            
	            //删除主表中的数据
	            pstmt = conn.prepareStatement(removeBrand);
	            pstmt.setObject(1,id);
	            pstmt.executeUpdate(); 
	            util.closePstmt(pstmt);
	            
	            return 1;//操作成功
	        } catch (SQLException e) {
	        	util.rollBack();//回滚事务
	            e.printStackTrace();
	        } finally {
	        	util.commitAndRelease(); //提交事务并释放资源
	        }
		return 0;
	}

	@Override
	public Brand queryOne(int id) {
		String sql = "select `brandId`,`brandName` from `brands` where `brandId` = ?";
		return util.queryOne(Brand.class, sql, id);
	}

	@Override
	public List<Brand> queryAll() {
		String sql = "select `brandId`,`brandName` from `brands`";
		List<Brand> list = util.queryList(Brand.class, sql);
		return list;
	}

}
