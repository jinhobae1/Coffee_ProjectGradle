package kr.or.dgit.Coffe.dao;

import java.util.List;

import kr.or.dgit.Coffe.dao.exception.DAOException;



public interface DAOInterface<T> {
	void insertItem(T item) throws DAOException;
	void updateItem(T item) throws DAOException;
	void deleteItem(T item) throws DAOException;
	List<T> selectAllItem() throws DAOException;
	T selectItemByCode(String code) throws DAOException;
}
