package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVO;

public class Product_Out_DaoImpl implements ProductDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<ProductVO> list() {
		List<ProductVO> list = null;
		list = sqlSession.selectList("product.product_out_list");
		return list;
	}

	@Override
	public int insert(ProductVO vo) throws Exception {
		int res = 0;
		res = sqlSession.insert("product.product_out_insert", vo);
		return res;
	}

	@Override
	public int update(ProductVO vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public ProductVO selectOne(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
