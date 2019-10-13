package dev.schoenberg.exception_wrapper;

/**
 * Like {@link java.util.function.Supplier Supplier} but with {@link java.lang.Throwable Throwable} declaration.
 */
@FunctionalInterface
public interface ThrowingSupplier<T> {
	T get() throws Throwable;
}
