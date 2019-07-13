package com.github.mml;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractTest
{
	private BigObject subject;

	@Before
	public void setUp()
	{
		subject = new BigObject();
	}

	@Test
	public void test()
	{
		subject.fill();
	}
}