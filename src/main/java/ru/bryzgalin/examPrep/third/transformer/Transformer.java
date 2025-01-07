package ru.bryzgalin.examPrep.third.transformer;

import java.util.function.Function;

public class Transformer<T,P>{
    Reader<T> reader;
    Writer<P> writer;
    Function<T, P> function;
    final void transform(){
        T temp = reader.read();
        P temp2 = function.apply(temp);
        writer.write(temp2);
    }
}
