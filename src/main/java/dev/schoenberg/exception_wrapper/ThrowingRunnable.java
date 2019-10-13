package dev.schoenberg.exception_wrapper;

/**
 * Like {@link java.lang.Runnable Runnable} but with {@link java.lang.Throwable Throwable} declaration.
 */
@FunctionalInterface
public interface ThrowingRunnable {
	void run() throws Throwable;
}
