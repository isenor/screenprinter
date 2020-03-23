package ca.isenor.screenprinter.core.processor;

public interface Processor<T, S> {
	public S process(T toProcess);
}
