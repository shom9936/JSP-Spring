package service;

import java.util.Map;

import vo.ProductVO;

public interface ProductService {
	Map selectList();
	
	// 입고
	int insert_in(ProductVO vo) throws Exception;
	
	// 출고
	int insert_out(ProductVO vo) throws Exception;
}
