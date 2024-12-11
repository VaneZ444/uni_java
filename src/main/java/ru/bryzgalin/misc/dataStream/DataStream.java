package ru.bryzgalin.misc.dataStream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;


public class DataStream<T> {

    private final List<T> collection;
    private final List<Consumer<List<T>>> operations;

    private DataStream(List<T> collection) {
        this.collection = collection;
        this.operations = new ArrayList<>();
    }

    public static <P> DataStream<P> of(List<P> collection) {
        return new DataStream<>(collection);
    }

    public <R> DataStream<R> map(Function<T, R> mapper) {
        operations.add(list -> {
            List<R> mappedList = new ArrayList<>();
            for (T item : list) {
                mappedList.add(mapper.apply(item));
            }
            list.clear();
            list.addAll((List <T>)mappedList);
        });
        return (DataStream<R>) this;
    }

    public DataStream<T> filter(Predicate<T> predicate) {
        operations.add(list -> {
            List<T> filteredList = new ArrayList<>();
            for (T item : list) {
                if (predicate.test(item)) {
                    filteredList.add(item);
                }
            }
            list.clear();
            list.addAll(filteredList);
        });
        return this;
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, T> accumulator) {
        R result = supplier.get();
        List<T> intermediate = new ArrayList<>(collection);
        for (Consumer<List<T>> operation : operations) {
            operation.accept(intermediate);
        }
        for (T item : intermediate) {
            accumulator.accept(result, item);
        }
        return result;
    }

    public T reduce(T identity, BinaryOperator<T> reducer) {
        return collect(() -> identity, (result, item) -> result = reducer.apply(result, item));
    }
}