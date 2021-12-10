package dao;

import java.util.List;

import vo.ProductVO;

public interface ProductDAO {
	List<ProductVO> list();
	int insert(ProductVO vo) throws Exception;
	int update(ProductVO vo) throws Exception;
	ProductVO selectOne(String name);
}
