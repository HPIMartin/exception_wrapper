package dev.schoenberg.exception_wrapper;

/**
 * Helper class for wrapping methods that throw checked exceptions into methods that throw unchecked exceptions. Here the checked exception is wrapped into an
 * unchecked {@link java.lang.RuntimeException RuntimeException}.
 */
public class ExceptionWrapper {
	/**
	 * Executes the given {@link dev.schoenberg.exception_wrapper.ThrowingRunnable ThrowingRunnable}. When a checked exception is thrown, it is wrapped in a
	 * {@link java.lang.RuntimeException RuntimeException} and thrown again.
	 * 
	 * @param runnable - Will be executed.
	 */
	public static void silentThrow(ThrowingRunnable runnable) {
		try {
			runnable.run();
		} catch (Throwable t) {
			throw runtimeException(t);
		}
	}

	/**
	 * Executes the given {@link dev.schoenberg.exception_wrapper.ThrowingSupplier ThrowingSupplier} and return result. When a checked exception is thrown, it
	 * is wrapped in a {@link java.lang.RuntimeException RuntimeException} and thrown again.
	 * 
	 * @param supplier - Will be executed.
	 * 
	 * @return Result of the given {@link dev.schoenberg.exception_wrapper.ThrowingSupplier ThrowingSupplier}.
	 */
	public static <T> T silentThrow(ThrowingSupplier<T> supplier) {
		try {
			return supplier.get();
		} catch (Throwable t) {
			throw runtimeException(t);
		}
	}

	private static RuntimeException runtimeException(Throwable t) {
		if (t instanceof RuntimeException) {
			return (RuntimeException) t;
		} else {
			return new RuntimeException(t);
		}
	}
}
