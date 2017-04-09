package ru.rinekri.udacitypopularmovies.ui.base.functions;

public interface UnsafeSupplier<T> {
  T get() throws Exception;
}