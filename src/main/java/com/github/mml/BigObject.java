package com.github.mml;

class BigObject
{
	private static final int COUNT = 1_000_000;

	private Long[] data = new Long[COUNT];

	void fill()
	{
		for (int i = 0; i < COUNT; i++)
		{
			data[i] = (long) i;
		}
	}
}