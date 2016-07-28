/**
 * 
 */
package com.tie.dao;

/**
 * @author awang Base Dao as super class for other Daos
 */
public class BaseDao {
	TiePersister tiePersister;
	

	public BaseDao(TiePersister tiePersister) {
		//super();
		this.tiePersister = tiePersister;
	}

	public TiePersister getTiePersister() {
		return tiePersister;
	}

	public void setTiePersister(TiePersister tiePersister) {
		this.tiePersister = tiePersister;
	}
}
