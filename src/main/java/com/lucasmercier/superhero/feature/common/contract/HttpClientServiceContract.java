package com.lucasmercier.superhero.feature.common.contract;

public interface HttpClientServiceContract {

    <T, S> T post(String url, S data, T emptyInstance);
    <T> T get(String url, Class<T> tClass);
}
