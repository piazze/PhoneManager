package com.hxzy.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hxzy.bean.Brand;
import com.hxzy.bean.Phone;
import com.hxzy.biz.PhoneBiz;
import com.hxzy.biz.impl.PhoneBizImpl;

public class PhoneBizImplTest {

	private PhoneBiz biz = new PhoneBizImpl();
	
	@Test
	@Ignore
	public void testAdd() {
		Phone phone = new Phone(0, "小米8", new Brand(1), new Double(1999), 4, 6, 128, 1, 1, new Date());
		int row = biz.add(phone);
		assertEquals(1, row);
	}

	@Test
	@Ignore
	public void testUpdate() {
		Phone phone = new Phone(2, "红米5s", new Brand(1), new Double(1999), 4, 6, 128, 1, 1, new Date());
		int row = biz.update(phone);
		assertEquals(1, row);
	}

	@Test
	@Ignore
	public void testRemove() {
		int row = biz.remove(1);
		assertEquals(1, row);
	}

	@Test
	@Ignore
	public void testQueryOne() {
		Phone phone = biz.queryOne(2);
		System.out.println(phone);
		assertNotNull(phone);
	}

	@Test
	public void testQueryAll() {
		List<Phone> list = biz.queryAll();
		list.parallelStream().forEach(System.out::println);
	}
}
