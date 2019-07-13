package com.github.mml.runner;

import java.lang.reflect.InvocationTargetException;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.mockito.junit.MockitoJUnitRunner;

public class FixedMockitoJUnitRunner extends MockitoJUnitRunner
{
	public FixedMockitoJUnitRunner(Class<?> klass) throws InvocationTargetException
	{
		super(klass);
	}

	@Override
	public void run(RunNotifier notifier)
	{
		final RunNotifierDelegate delegate = new RunNotifierDelegate(notifier);

		super.run(delegate);

		notifier.removeListener(delegate.recordedListener);
	}

	public static class RunNotifierDelegate extends RunNotifier
	{
		private final RunNotifier actual;

		private RunListener recordedListener;

		public RunNotifierDelegate(RunNotifier actual)
		{
			this.actual = actual;
		}

		@Override
		public void addFirstListener(RunListener listener)
		{
			actual.addFirstListener(listener);
		}

		@Override
		public void addListener(RunListener listener)
		{
			actual.addListener(listener);
			recordedListener = listener;
		}

		@Override
		public boolean equals(Object obj)
		{
			return actual.equals(obj);
		}

		@Override
		public void fireTestAssumptionFailed(Failure failure)
		{
			actual.fireTestAssumptionFailed(failure);
		}

		@Override
		public void fireTestFailure(Failure failure)
		{
			actual.fireTestFailure(failure);
		}

		@Override
		public void fireTestFinished(Description description)
		{
			actual.fireTestFinished(description);
		}

		@Override
		public void fireTestIgnored(Description description)
		{
			actual.fireTestIgnored(description);
		}

		@Override
		public void fireTestRunFinished(Result result)
		{
			actual.fireTestRunFinished(result);
		}

		@Override
		public void fireTestRunStarted(Description description)
		{
			actual.fireTestRunStarted(description);
		}

		@Override
		public void fireTestStarted(Description description) throws StoppedByUserException
		{
			actual.fireTestStarted(description);
		}

		@Override
		public int hashCode()
		{
			return actual.hashCode();
		}

		@Override
		public void pleaseStop()
		{
			actual.pleaseStop();
		}

		@Override
		public void removeListener(RunListener listener)
		{
			actual.removeListener(listener);
		}

		@Override
		public String toString()
		{
			return actual.toString();
		}
	}
}