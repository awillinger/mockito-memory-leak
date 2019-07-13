package com.github.mml;

import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MockitoRuleTest extends AbstractTest
{
	@Rule
	public final MockitoRule mockito = MockitoJUnit.rule().silent();
}