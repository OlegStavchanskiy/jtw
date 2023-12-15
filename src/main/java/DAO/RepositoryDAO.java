package DAO;

import java.util.List;


public interface RepositoryDAO<T> {
// Добавление сущности в таблицу базы данных
// возвращает ID добавленного должности
public Long insert(T о);
// Редактирование cущности
public void update(T o);
// Удаление сущности
public void delete(Long Id);
// Поиск сущности по Id
public T findById(Long Id);
// Получение списка сущностей
public List<T> findAll();
}