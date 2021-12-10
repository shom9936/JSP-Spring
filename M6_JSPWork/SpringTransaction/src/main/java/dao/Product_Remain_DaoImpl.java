package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVO;

public class Product_Remain_DaoImpl implements ProductDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<ProductVO> list() {
		List<ProductVO> list = null;
		list = sqlSession.selectList("product.product_remain_list");
		return list;
	}

	@Override
	public int insert(ProductVO vo) throws Exception {
		int res = 0;
		res = sqlSession.insert("product.product_remain_insert", vo);
		return res;
	}

	@Override
	public int update(ProductVO vo) throws Exception {
		int res = 0;
		res = sqlSession.update("product.product_remain_update", vo);
		return res;
	}
	
	@Override
	public ProductVO selectOne(String name) {
		ProductVO vo = null;
		vo = sqlSession.selectOne("product.product_remain_one",name);
		return vo;
	}
}
