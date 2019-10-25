package com.biz.iolist.dao;

import java.util.List;

import com.biz.iolist.persistence.ProductDTO;

public interface ProductDao {

	public List<ProductDTO> selectAll();
	
	public ProductDTO findById(String p_code);
	public List<ProductDTO> findByName(String p_name);
	
	public int insert(ProductDTO productDTO);
	public int update(ProductDTO productDTO);
	public int delete(String p_code);
	
}
